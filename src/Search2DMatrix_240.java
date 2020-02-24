public class Search2DMatrix_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0 || target < matrix[0][0]) return false;
        int up = 0, right = matrix[0].length - 1;
        while (up < matrix.length && right > -1)
        {
            if (matrix[up][right] > target)
            {
                right--;
            }
            else if (matrix[up][right] < target)
            {
                up++;
            }
            else
            {
                return true;
            }
        }
        return false;
    }
}
