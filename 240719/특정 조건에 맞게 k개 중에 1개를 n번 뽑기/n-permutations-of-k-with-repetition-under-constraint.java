import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        back(0, new int[N]);
    }

    private static void back(int depth, int[] choice) {
        if (depth == N) {
           if (isAvailableNums(choice)) {
                for (int num : choice) {
                    System.out.print(num + " ");
                }
                System.out.println();
           } 
           return;
        }

        for (int i = 1; i <= K; i++) {
            choice[depth] = i;
            back(depth + 1, choice);
        }
    }

    private static boolean isAvailableNums(int[] choice) {
        int size = choice.length;
        if (size < 3) {
            return true;
        }

        int max = size - 3;
        for (int i = 0; i <= max; i++) {
            int num = choice[i];
            if (num == choice[i + 1] && num == choice[i + 2]) {
                return false;
            }
        }
        return true;
    }
}