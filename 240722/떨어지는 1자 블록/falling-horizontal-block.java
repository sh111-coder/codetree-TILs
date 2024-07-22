import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        int m = Integer.parseInt(input.nextToken());
        int k = Integer.parseInt(input.nextToken()) - 1;

        int[][] block = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer blockInput = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                block[i][j] = Integer.parseInt(blockInput.nextToken());
            }
        }

        int minRow = Integer.MAX_VALUE;
        for (int col = k; col <= (k + m - 1); col++) {
            int tempRow = n - 1;
            for (int row = n - 1; row > 0; row--) {
                if (block[row][col] == 1) {
                    tempRow = row - 1;
                }
            }
            minRow = Math.min(minRow, tempRow);
        }


        for (int i = k; i <= (k + m - 1); i++) {
            block[minRow][i] = 1;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(block[i][j] + " ");
            }
            System.out.println();
        }

    }
}