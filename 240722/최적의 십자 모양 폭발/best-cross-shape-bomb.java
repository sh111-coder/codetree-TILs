import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int max = Integer.MIN_VALUE;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer mapInput = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(mapInput.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int[][] tempMap = new int[n][n];
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        tempMap[k][l] = map[k][l];
                    }
                }

                int bombCnt = map[i][j];

                // 폭탄 터트리기
                int cnt = 0;
                while (cnt != bombCnt) {
                    for (int k = 0; k < 4; k++) {
                        int cx = i + (dx[k] * cnt);
                        int cy = j + (dy[k] * cnt);
                        if (cx >= 0 && cx < n && cy >= 0 && cy < n) {
                            if (tempMap[cx][cy] != 0) {
                                tempMap[cx][cy] = 0;
                            }
                        }
                    }
                    cnt++;
                }

                // 중력 작용
                int[][] resultMap = new int[n][n];
                for (int col = 0; col < n; col++) {
                    int tempRowIdx = n - 1;
                    for (int row = n - 1; row >= 0; row--) {
                        if (tempMap[row][col] == 0) {
                            continue;
                        }
                        resultMap[tempRowIdx][col] = tempMap[row][col];
                        tempRowIdx--;
                    }
                }
        
                // 쌍 개수 세기
                boolean[][] visited = new boolean[n][n];
                int pairCnt = 0;
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        int num = resultMap[k][l];
                        if (num == 0) {
                            continue;
                        }
                        visited[k][l] = true;
                        for (int r = 0; r < 4; r++) {
                            int cx = k + dx[r];
                            int cy = l + dy[r];
                            if (cx >= 0 && cx < n && cy >= 0 && cy < n) {
                                if (!visited[cx][cy] && resultMap[cx][cy] == num) {
                                    pairCnt++;
                                }
                            }
                        }
                    }
                }

                max = Math.max(max, pairCnt);
            }
        }

        System.out.println(max);  
    }
}