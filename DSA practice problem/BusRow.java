import java.util.Scanner;

public class BusRow {
    static void busiestRow(int[][] grid, int rows, int cols) {
        int bestRowIndex = 0;
        int maxTotal = -1;

        for (int i = 0; i < rows; i++) {
            int rowSum = 0;
            for (int j = 0; j < cols; j++) {
                rowSum += grid[i][j];
            }
            if (rowSum > maxTotal) {
                maxTotal = rowSum;
                bestRowIndex = i;
            }
        }

        System.out.println("Row " + bestRowIndex + ", Total " + maxTotal);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] grid = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            System.out.println("Enter seat values for row " + i + " (" + cols + " values): ");
            for (int j = 0; j < cols; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println("\n=== Result ===");
        busiestRow(grid, rows, cols);
        sc.close();
    }
}