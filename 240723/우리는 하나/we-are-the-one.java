import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, k, u, d;
    static int[][] map;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        n = Integer.parseInt(input.nextToken());
        k = Integer.parseInt(input.nextToken());
        u = Integer.parseInt(input.nextToken());
        d = Integer.parseInt(input.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer mapInput = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(mapInput.nextToken());
            }
        }

        back(0, 0, new int[k]);
        System.out.println(max);
    }

    private static void back(int depth, int start, int[] choices) {
        if (depth == k) {
            int cityCnt = bfs(choices);
            max = Math.max(max, cityCnt);
            return;
        }

        for (int i = start; i < (n * n); i++) {
            choices[depth] = i;
            back(depth + 1, i + 1, choices);
        }
    }

    private static int bfs(int[] choices) {
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        int cityCnt = 0;
        for (int choice : choices) {
            int row = choice / n;
            int col = choice % n;
            visited[row][col] = true;
            queue.add(new int[]{row, col});
            cityCnt++;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] city = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int cx = city[0] + dx[j];
                    int cy = city[1] + dy[j];
                    if (cx >= 0 && cx < n && cy >= 0 && cy < n) {
                        int curH = map[city[0]][city[1]];
                        int nextH = map[cx][cy];
                        int diff = Math.abs(curH - nextH);
                        if (!visited[cx][cy] && (diff >= u && diff <= d)) {
                            visited[cx][cy] = true;
                            queue.add(new int[]{cx, cy});
                            cityCnt++;
                        }
                    }
                }
            }
        }

        return cityCnt;
    }
}