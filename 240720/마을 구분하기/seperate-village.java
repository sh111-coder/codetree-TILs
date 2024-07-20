import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int[][] map;
    static boolean[][] visited;
    static boolean isAvailable = false;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    static int peopleCount;
    static int homeCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        n = Integer.parseInt(input.nextToken());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer mapInput = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(mapInput.nextToken());
            }
        }

        PriorityQueue<Integer> peopleCounts = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    visited[i][j] = true;
                    homeCount++;
                    peopleCount = 1;
                    dfs(i, j);
                    peopleCounts.add(peopleCount);
                }
            }
        }

        System.out.println(homeCount);
        int size = peopleCounts.size();
        for (int i = 0; i < size; i++) {
            System.out.println(peopleCounts.poll());            
        }
    }

    private static void dfs(int startX, int startY) {
        for (int i = 0; i < 4; i++) {
            int cx = startX + dx[i];
            int cy = startY + dy[i];

            if (cx >= 0 && cx < n && cy >= 0 && cy < n) {
                if (!visited[cx][cy] && map[cx][cy] == 1) {
                    visited[cx][cy] = true;
                    peopleCount++;
                    dfs(cx, cy);
                }
            }
        }
    }   
}