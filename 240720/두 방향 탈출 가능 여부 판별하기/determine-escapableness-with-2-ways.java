import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static boolean isAvailable = false;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        n = Integer.parseInt(input.nextToken());
        m = Integer.parseInt(input.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            StringTokenizer mapInput = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(mapInput.nextToken());
            }
        }

        dfs(0, 0);

        if (isAvailable) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static void dfs(int startX, int startY) {
        if (startX == n - 1 && startY == m - 1) {
            isAvailable = true;
            return;
        }

        for (int i = 0; i < 2; i++) {
            int cx = startX + dx[i];
            int cy = startY + dy[i];

            if (cx >= 0 && cx < n && cy >= 0 && cy < m) {
                if (!visited[cx][cy] && map[cx][cy] == 1) {
                    visited[cx][cy] = true;
                    dfs(cx, cy);
                }
            }
        }
    }   
}