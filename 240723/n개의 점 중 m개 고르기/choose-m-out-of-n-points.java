import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] map;
    static int min = Integer.MAX_VALUE;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

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

        back(0, 0, new int[m]);
        System.out.println(min);
    }

    private static void back(int depth, int start, int[] choice) {
        if (depth == m) {
            pq = new PriorityQueue<>(Collections.reverseOrder());
            back2(0, 0, choice, new int[2]);
            min = Math.min(min, pq.poll());
            return;
        }

        for (int i = start; i < n; i++) {
            choice[depth] = i;
            back(depth + 1, i + 1, choice);
        }
    }

    private static void back2(int depth, int start, int[] choice, int[] choice2) {
        if (depth == 2) {
            int x1 = map[choice2[0]][0];
            int x2 = map[choice2[1]][0];
            int y1 = map[choice2[0]][1];
            int y2 = map[choice2[1]][1];

            int xResult = (x1 - x2) * (x1 - x2);
            int yResult = (y1 - y2) * (y1 - y2);
            int result = xResult + yResult;

            pq.add(result);
            return;
        }

        for (int i = start; i < choice.length; i++) {
            choice2[depth] = choice[i];
            back2(depth + 1, i + 1, choice, choice2);
        }
    }
}