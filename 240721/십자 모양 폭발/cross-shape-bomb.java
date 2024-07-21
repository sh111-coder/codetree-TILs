import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer mapInput = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(mapInput.nextToken());
            }
        }

        StringTokenizer positionInput = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(positionInput.nextToken()) - 1;
        int c = Integer.parseInt(positionInput.nextToken()) - 1;

        // 터진 곳 0으로 초기화
        int bombNum = map[r][c];
        map[r][c] = 0;

        int[] dx = new int[]{1, 0, 0, -1};
        int[] dy = new int[]{0, 1, -1, 0};

        for (int i = 1; i < bombNum; i++) {
            for (int j = 0; j < 4; j++) {
                int newR = r + (dx[j] * i);
                int newC = c + (dy[j] * i);

                if (newR >= 0 && newR < n && newC >= 0 && newC < n) {
                    map[newR][newC] = 0;
                }
            }
        }

        int[][] tempMap = new int[n][n];
        for (int col = 0; col < n; col++) {
            int tempRow = n - 1;
            for (int row = n - 1; row >= 0; row--) {
                int num = map[row][col];
                if (num != 0) {
                    tempMap[tempRow][col] = num;
                    tempRow--;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(tempMap[i][j] + " ");
            }
            System.out.println();
        }
    }
}