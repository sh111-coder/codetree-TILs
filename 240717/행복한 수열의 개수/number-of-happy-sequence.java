import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        
        int cnt = 0;

        // 행 수열 고르기
        for (int i = 0; i < n; i++) {
            int length = 1;
            int cur = map[i][0];
            for (int j = 1; j < n; j++) {
                if (cur == map[i][j]) {
                    length++;
                } else {
                    length = 1;
                    cur = map[i][j];
                }

                if (length == m) {
                    cnt++;
                    break;
                }
            }
        }

        // 열 수열 고르기
        for (int i = 0; i < n; i++) {
            int length = 1;
            int cur = map[0][i];
            for (int j = 1; j < n; j++) {
                if (cur == map[j][i]) {
                    length++;
                } else {
                    length = 1;
                    cur = map[j][i];
                }

                if (length == m) {
                    cnt++;
                    break;
                }
            }
        }
        
        System.out.println(cnt);
    }
}