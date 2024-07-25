import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, A, B;
    static int[][] nums;
    static boolean isAvailable = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        n = Integer.parseInt(input.nextToken());
        A = Integer.parseInt(input.nextToken());
        B = Integer.parseInt(input.nextToken());
        nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer numInput = new StringTokenizer(br.readLine());
            nums[i][0] = Integer.parseInt(numInput.nextToken());
            nums[i][1] = Integer.parseInt(numInput.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            isAvailable = false;
            m = i;
            back(0, 0, new int[i]);
            if (!isAvailable) {
                System.out.println(i - 1);
                return;
            }
        }
        System.out.println(n);
    }

    private static void back(int depth, int start, int[] choices) {
        if (depth == m) {
            int aSum = 0;
            int bSum = 0;
            for (int choice : choices) {
                aSum += nums[choice][0];
                bSum += nums[choice][1];
            }
            
            if (aSum <= A && bSum <= B) {
                isAvailable = true;
            } 

            return;
        }

        for (int i = start; i < n; i++) {
            choices[depth] = i;
            back(depth + 1, i + 1, choices);
        }
    }
}