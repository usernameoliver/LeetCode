/**
 * Created by olive on 5/7/2017.
 */
public class LongestLine {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 1}};
        LongestLine longestLineFinder = new LongestLine();
        int result = longestLineFinder.longestLine(matrix);
        System.out.print(result);
    }

    private int longestLine(int[][] matrix) {
        int max = 0;
        if (matrix == null || matrix.length == 0)   return max;
        int m = matrix.length, n = matrix[0].length;
        int[][][] count = new int[m][n][4];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0)  continue;
                for (int k = 0; k < 4; k++) {
                    count[i][j][k] = 1;
                }
                // honrizontal
                if (j > 0)  count[i][j][0] += count[i][j - 1][0];
                //vertical
                if (i > 0)  count[i][j][1] += count[i - 1][j][1];
                //left upper-down lower
                if (i > 0 && j > 0) count[i][j][2] += count[i - 1][j - 1][2];
                //right upper-down lower
                if (i > 0 && j < m - 1) count[i][j][3] += count[i - 1][j + 1][3];
                max = Math.max(max, Math.max(count[i][j][0], count[i][j][1]));
                max = Math.max(max, Math.max(count[i][j][2], count[i][j][3]));
            }
        }
        return max;
    }
}
