public class _NumOfIslands_200 {
    public static int numIslands(char[][] grid)
    {
        int result = 0;
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (grid[i][j] == '0') continue;
                grid[i][j] = '0';
                findConnected(grid, i, j);
                result++;
            }
        }
        return result;
    }

    private static void findConnected(char[][] grid, int i, int j)
    {
        int iCopy = i, jCopy = j;
        // Go up
        while (i > 0)
        {
            i--;
            if (grid[i][jCopy] == '1')
            {
                grid[i][jCopy] = '0';
                findConnected(grid, i, jCopy);
            }
            else
            {
                break;
            }
        }
        i = iCopy;
        // Go down
        while (i < grid.length - 1)
        {
            i++;
            if (grid[i][jCopy] == '1')
            {
                grid[i][jCopy] = '0';
                findConnected(grid, i, jCopy);
            }
            else
            {
                break;
            }
        }
        i = iCopy;
        // Go left
        while (j > 0)
        {
            j--;
            if (grid[iCopy][j] == '1')
            {
                grid[iCopy][j] = '0';
                findConnected(grid, iCopy, j);
            }
            else
            {
                break;
            }
        }
        // Go right
        j = jCopy;
        while (j < grid[0].length - 1)
        {
            j++;
            if (grid[iCopy][j] == '1')
            {
                grid[iCopy][j] = '0';
                findConnected(grid, iCopy, j);
            }
            else
            {
                break;
            }
        }
    }
}
