class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        row = len(board)
        col = len(board[0])
        path = set()

        def wordSearch(row: int, col: int, word: str, index: int, board: List[List[str]]) -> bool:
            if index == len(word):
                return True
            
            if row < 0 or col < 0 or row >= len(board) or col >= len(board[0]) or (board[row][col] != word[index] or (row,col) in path):
                return False

            if board[row][col] == word[index]:
                path.add((row, col))
                res = (wordSearch(row, col+1, word, index+1, board) or
                wordSearch(row, col-1, word, index+1, board) or 
                wordSearch(row+1, col, word, index+1, board) or
                wordSearch(row-1, col, word, index+1, board))

                path.remove((row, col))
            
            return res

        for row in range(len(board)):
            for col in range(len(board[0])):
                if wordSearch(row, col, word, 0, board):
                    return True
        return False
