import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] map;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        n = Integer.parseInt(input.nextToken());
        m = Integer.parseInt(input.nextToken());
        map = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer xyInput = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(xyInput.nextToken());
            int y = Integer.parseInt(xyInput.nextToken());
            map[i][0] = x;
            map[i][1] = y;
        }

        Arrays.sort(map, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        back(0, 0, new int[m]);
        System.out.println(min);
    }

    private static void back(int depth, int start, int[] choice) {
        if (depth == m) {
            int minIdx = choice[0];
            int maxIdx = choice[m - 1];

            int x1 = map[minIdx][0];
            int x2 = map[maxIdx][0];
            int y1 = map[minIdx][1];
            int y2 = map[maxIdx][1];

            int xResult = (x1 - x2) * (x1 - x2);
            int yResult = (y1 - y2) * (y1 - y2);
            int result = xResult + yResult;
            min = Math.min(min, result);
            return;
        }

        for (int i = start; i < n; i++) {
            choice[depth] = i;
            back(depth + 1, i + 1, choice);
        }
    }
}