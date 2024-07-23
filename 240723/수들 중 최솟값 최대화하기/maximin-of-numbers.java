import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int[][] map;
    static boolean[] visitedCol;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visitedCol = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer mapInput = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(mapInput.nextToken());
            }
        }

        back(0, new int[n]);
        System.out.println(max);
    }

    private static void back(int depth, int[] choiceCol) {
        if (depth == n) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int num = map[i][choiceCol[i]];
                min = Math.min(min, num);
            }
            
            max = Math.max(max, min);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visitedCol[i]) {
                visitedCol[i] = true;
                choiceCol[depth] = i;
                back(depth + 1, choiceCol);
                visitedCol[i] = false;
            }
        }
    }
}