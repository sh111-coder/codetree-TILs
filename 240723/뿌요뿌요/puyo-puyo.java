import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};

    static int bombCnt = 0;
    static int tempBlockSize = 0;
    static int maxBlockSize = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer mapInput = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(mapInput.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    tempBlockSize = 1;
                    dfs(i, j, map[i][j]);

                    if (tempBlockSize >= 4) {
                        bombCnt++;
                    }
                    maxBlockSize = Math.max(maxBlockSize, tempBlockSize);
                }    
            }
        }

        System.out.println(bombCnt + " " + maxBlockSize);
    }

    private static void dfs(int startX, int startY, int num) {
        for (int i = 0; i < 4; i++) {
            int cx = startX + dx[i];
            int cy = startY + dy[i];

            if (cx >= 0 && cx < n && cy >= 0 && cy < n) {
                if (!visited[cx][cy] && map[cx][cy] == num) {
                    visited[cx][cy] = true;
                    tempBlockSize++;
                    dfs(cx, cy, num);
                }
            }
        }
    }
}