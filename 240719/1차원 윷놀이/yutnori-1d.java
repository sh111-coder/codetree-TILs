import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, k;
    static int[] distance;
    static int[] scores;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        
        distance = new int[n + 1];
        StringTokenizer distanceInput = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            distance[i] = Integer.parseInt(distanceInput.nextToken());
        }

        

        // 턴 4번
        // 1 ~ 6
        // 말 번호 1, 2, 3
        // 1, 2, 2, 3
        // 1 -> 
        back(0, new int[n + 1]);
        System.out.println(max);
    }

    private static void back(int depth, int[] choice) {
        if (depth == n) {
            int score = calculateScore(choice);
            max = Math.max(max, score);
            return;
        }

        for (int i = 1; i <= k; i++) {
            choice[depth + 1] = i;
            back(depth + 1, choice);
        }
    }

    private static int calculateScore(int[] choice) {
        scores = new int[k + 1];
        Set<Integer> finishedPieces = new HashSet<>();
        int score = 0;
        for (int i = 1; i <= n; i++) {
            int curDistance = distance[i];
            int piece = choice[i];
            int curScore = scores[piece];
            if (finishedPieces.contains(piece)) {
                continue;
            }

            scores[piece] += curDistance;
            if (scores[piece] >= (m - 1)) {
                score++;
                finishedPieces.add(piece);
            }
        }
        return score;
    }
}