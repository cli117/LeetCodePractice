public class _WordSearch_dfs_79 {
    public boolean exist(char[][] board, String word) {
        if(board.length == 0) return false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index)
    {

        int row = board.length;
        int col = board[0].length;

        if(i < 0 || j < 0 || i >= row || j >= col || board[i][j] != word.charAt(index))
        {
            return false;
        }

        if(index == word.length()-1)
        {
            return true;
        }

        char cur = board[i][j];
        // Delete the used letter
        board[i][j] = '#';
        boolean flag = dfs(board,word,i+1,j,index+1) || dfs(board,word,i-1,j,index+1) || dfs(board,word,i,j+1,index+1) || dfs(board,word,i,j-1,index+1);
        board[i][j] = cur;
        return flag;

    }
}
