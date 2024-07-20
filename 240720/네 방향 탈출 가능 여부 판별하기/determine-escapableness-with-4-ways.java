import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] map;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};
    static boolean isAvailable = false;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        n = Integer.parseInt(input.nextToken());
        m = Integer.parseInt(input.nextToken());
        visited = new boolean[n][m];
        map = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer mapInput = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(mapInput.nextToken());
            }
        }

        bfs(0, 0);
        if (isAvailable) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] position = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int cx = position[0] + dx[j];
                    int cy = position[1] + dy[j];

                    if (cx >= 0 && cx < n && cy >= 0 && cy < m) {
                        if (!visited[cx][cy] && map[cx][cy] == 1) {
                            if (cx == n - 1 && cy == m - 1) {
                                isAvailable = true;
                                return;
                            }
                            visited[cx][cy] = true;
                            queue.add(new int[]{cx, cy});
                        }
                    }
                }
            }
            
        }
    }
}