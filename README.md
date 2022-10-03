# Word Composition Problem

To find longest and second longest words constructed by concatenating shorter words also found in the file which are in sorted order.

## Input (files)

- Input_01.txt
- Input_02.txt

## Output

```
ratcatdogcat catsdogcats time taken to process the input file(in milliseconds)
ethylenediaminetetraacetates ethylenediaminetetraacetate time taken to process the input file(in milliseconds)
```

## Approach

Used `Trie` data structure its a special tree that stores strings. Maximum number of children of a node is equal to size of alphabet. Trie supports search, insert and delete operations in `O(k)` time where k is length of key/word. This is obviously faster than BST and Hashing. and we can efficiently do `Prefix search`.
