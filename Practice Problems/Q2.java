import java.util.Scanner;

public class Q2 {
    public static int[] warehouseSummary(int[][] grid) {
        int total = 0;
        int maxVal = -1;
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];
                if (grid[i][j] > maxVal) {
                    maxVal = grid[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        return new int[]{total, maxRow, maxCol};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int[] res = warehouseSummary(grid);
        System.out.println("total = " + res[0] + ", maxCoordinate = (" + res[1] + ", " + res[2] + ")");
        sc.close();
    }
}