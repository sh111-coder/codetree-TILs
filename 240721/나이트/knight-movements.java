import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = {2, 1, 1, 2, -2, -1, -1, -2};
    static int[] dy = {1, 2, -2, -1, 1, 2, -2, -1};
    static int n;
    static boolean[][] visited;
    static int min = Integer.MAX_VALUE;
    static int r1, c1, r2, c2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n][n];

        StringTokenizer positionInput = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(positionInput.nextToken()) - 1;
        c1 = Integer.parseInt(positionInput.nextToken()) - 1;
        r2 = Integer.parseInt(positionInput.nextToken()) - 1;
        c2 = Integer.parseInt(positionInput.nextToken()) - 1;

        bfs(r1, c1);
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    private static void bfs(int startR, int startC) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startR, startC});
        visited[startR][startC] = true;

        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt++;
            for (int i = 0; i < size; i++) {
                int[] position = queue.poll();
                for (int j = 0; j < 8; j++) {
                    int cx = position[0] + dx[j];
                    int cy = position[1] + dy[j];

                    if (cx == r2 && cy == c2) {
                        min = cnt;
                        return;
                    }

                    if (cx >= 0 && cx < n && cy >= 0 && cy < n) {
                        if (!visited[cx][cy]) {
                            visited[cx][cy] = true;
                            queue.add(new int[]{cx, cy});
                        }
                    }
                }
            }
        }
    }
}