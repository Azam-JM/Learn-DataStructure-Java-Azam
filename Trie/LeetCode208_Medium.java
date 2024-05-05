/*
Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
*/

// Visualize what is trie and how it works
// Create Node of type trie
// Insert function to insert children
// Search if the word is present
// Search with for auto complete functionality
class Node {
    char val;
    Node[] children;
    boolean isEnd;

    Node(char val){
        this.val = val;
        this.children = new Node[26];
        this.isEnd = false;
    }
}
class Trie {
    Node root;

    public Trie() {
        root = new Node('\0');
    }
    
    public void insert(String word) { // azam
        Node currentNode = root;
        for(char currentWord : word.toCharArray()){
            if(currentNode.children[currentWord - 'a'] == null){
                currentNode.children[currentWord - 'a'] = new Node(currentWord);
            }
            currentNode = currentNode.children[currentWord - 'a'];
        }
        currentNode.isEnd = true;
        
    }
    
    public Node searchTrie(String word){
        Node currentNode = root;
        for(char currentWord: word.toCharArray()){
            if(currentNode.children[currentWord - 'a'] == null){
                return null;
            }
            currentNode = currentNode.children[currentWord - 'a'];
        }

        return currentNode;
    }
    
    public boolean search(String word) {
        Node result = searchTrie(word);
        return result != null && result.isEnd == true;
        
    }
    
    public boolean startsWith(String prefix) {
        Node result = searchTrie(prefix);
        return result != null;   
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
