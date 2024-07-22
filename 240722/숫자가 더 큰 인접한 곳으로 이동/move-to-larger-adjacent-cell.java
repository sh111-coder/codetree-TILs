import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        n = Integer.parseInt(input.nextToken());
        int r = Integer.parseInt(input.nextToken()) - 1;
        int c = Integer.parseInt(input.nextToken()) - 1;

        int[][] map = new int[n][n];   
        for (int i = 0; i < n; i++) {
            StringTokenizer mapInput = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(mapInput.nextToken());
            }
        }

        System.out.print(map[r][c] + " ");

        while (true) {
            int num = map[r][c];
            
            boolean isStop = true;
            for (int i = 0; i < 4; i++) {
                int newR = r + dx[i];
                int newC = c + dy[i];
                if (newR >= 0 && newR < n && newC >= 0 && newC < n) {
                    int compareNum = map[newR][newC];
                    if (compareNum > num) {
                        System.out.print(map[newR][newC] + " ");
                        r = newR;
                        c = newC;
                        isStop = false;
                        break;
                    }
                }
            }

            if (isStop) {
                break;
            }
        }

    }
}