import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, k;
    static int[][] map;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};
    static int cnt = 0;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        n = Integer.parseInt(input.nextToken());
        k = Integer.parseInt(input.nextToken());
        visited = new boolean[n][n];
        map = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer mapInput = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(mapInput.nextToken());
            }
        }

        // 1 1
        // 0 
        // 1 1
        for (int i = 0; i < k; i++) {
            StringTokenizer startInput = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(startInput.nextToken());
            int startY = Integer.parseInt(startInput.nextToken());
            bfs(startX - 1, startY - 1);
        }
        


        System.out.println(cnt);
    }

    private static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        cnt++;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] position = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int cx = position[0] + dx[j];
                    int cy = position[1] + dy[j];

                    if (cx >= 0 && cx < n && cy >= 0 && cy < n) {
                        if (!visited[cx][cy] && map[cx][cy] == 0) {
                            cnt++;
                            visited[cx][cy] = true;
                            queue.add(new int[]{cx, cy});
                        }
                    }
                }
            }
            
        }
    }
}