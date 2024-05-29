class Solution {
    public boolean exist(char[][] board, String word) {

        // Loop to start
        for(int row=0; row < board.length; row++){
            for(int col=0; col < board[0].length; col++){
                if(wordSearch(row, col, word, 0, board)){
                    return true;
                }
            }
        }
        return false;   
    }

    public boolean wordSearch(int row, int col, String word, int index, char[][] board){
        if(index == word.length()){
            return true;
        }

        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || (board[row][col] != word.charAt(index))){
            return false;
        }

        boolean isPresent = false; 

        if(board[row][col] == word.charAt(index)){
            board[row][col] += 100;
            isPresent = wordSearch(row, col+1, word, index+1, board) || 
            wordSearch(row, col-1, word, index+1, board) || wordSearch(row+1, col, word, index+1, board) || wordSearch(row-1, col, word, index+1, board);
            board[row][col] -= 100;
        }
        return isPresent;
    }
}
