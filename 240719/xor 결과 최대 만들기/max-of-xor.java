import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static int[] nums;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        n = Integer.parseInt(input.nextToken());
        m = Integer.parseInt(input.nextToken());
        nums = new int[n];
        
        StringTokenizer inputNum = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(inputNum.nextToken());
        }

        back(0, new int[m], 0);
        System.out.println(max);
    }

    private static void back(int depth, int[] choice, int start) {
        if (depth == m) {
            int score = calculateXor(choice);
            max = Math.max(max, score);
            return;
        }

        for (int i = start; i < n; i++) {
            choice[depth] = i;
            back(depth + 1, choice, i + 1);
        }
    }

    private static int calculateXor(int[] choice) {
        int size = choice.length;
        if (size == 1) {
            return nums[choice[0]];
        }

        int score = nums[choice[0]] ^ nums[choice[1]];

        for (int i = 2; i < size; i++) {
            score ^= nums[choice[i]];
        }

        return score;
    }
}