// Visualize the use case
// Write it down
// How to handle when char is '.' on any of the positions
class Node {
    char val;
    Node[] children;
    boolean isEnd;
    Node(char val){
        this.val = val;
        children = new Node[26];
        isEnd = false;
    }
}
class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node('\0');
    }
    
    public void addWord(String word) {
        Node currentNode = root;
        for(char currentWord : word.toCharArray()){
            if(currentNode.children[currentWord - 'a'] == null){
                currentNode.children[currentWord - 'a'] = new Node(currentWord);
            }
            currentNode = currentNode.children[currentWord - 'a'];
        }
        currentNode.isEnd = true;
    }
    
    public boolean searchTrie(Node root, String word, int index){
        if(index == word.length()){
            return root.isEnd;
        }

        char currentWord = word.charAt(index);
        if(currentWord == '.'){
            for(Node child : root.children){
                if(child != null && searchTrie(child, word, index+1)){
                    return true;
                }
            }
            return false;
        } else {
            if(root.children[currentWord - 'a'] == null){
                return false;
            }
            return searchTrie(root.children[currentWord - 'a'], word, index+1);

        }
    }

    public boolean search(String word) {
        return searchTrie(root, word, 0);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
