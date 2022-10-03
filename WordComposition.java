import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class WordComposition {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		//storing current start time 
		long startTime = System.currentTimeMillis();
		
		// change the file name accordingly
		File file = new File("C:\\Users\\Ragini Gupta\\Desktop\\Input_01.txt");
		Trie trie = new Trie();
		
		//for adding the pairs of current word and its suffix
		LinkedList<Pair<String>> queue = new LinkedList<Pair<String>>();
		
		// scan the file
		@SuppressWarnings("resource")
		Scanner s = new Scanner(file);

		String word;	
		// indices of suffixes of a word
		List<Integer> sufIndices;	

		/*read words from the file 
		  fill up the queue with words which have suffixes, who are
		  candidates to be compound words
	      insert each word in trie
		*/
		while (s.hasNext()) {
			word = s.next();		
			sufIndices = trie.getSuffixesStartIndices(word);

			for (int i : sufIndices) {
				if (i >= word.length())		// if index is out of bound
					break;					
				// it means suffixes of the word has
				// been added to the queue if there is any
				queue.add(new Pair<String>(word, word.substring(i)));
			}

			trie.insert(word);
		}

		Pair<String> p;				// a pair of word and its remaining suffix
		int maxLength = 0;			// longest compound word length		
		String longest = "";		// longest compound word
		String sec_longest = "";	// second longest compound word

		while (!queue.isEmpty()) {
			p = queue.removeFirst();
			word = p.second();

			sufIndices = trie.getSuffixesStartIndices(word);

			// if no suffixes found, which means no prefixes found
			// discard the pair and check the next pair
			if (sufIndices.isEmpty()) {
				continue;
			}

			//System.out.println(word);
			for (int i : sufIndices) {
				if (i > word.length()) { 
					// sanity check 
					break;
				}
				if (i == word.length()) { 
					/*no suffix, means it is a compound word
				     check if the compound word is the longest
				     if it is then update both longest and second longest words records.
					 */
					if (p.first().length() > maxLength) {
						//sec_maxLength = maxLength;
						sec_longest = longest;
						maxLength = p.first().length();
						longest = p.first();
					}
				} 
				else {
					queue.add(new Pair<String>(p.first(), word.substring(i)));
				}
			}
		}     
		System.out.println("Longest Compound Word: " + longest);
		System.out.println("Second Longest Compound Word: " + sec_longest);
		
		//storing end time of file processing
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken to process the input file: " + (endTime - startTime) + " milliseconds");
		
	}

}
