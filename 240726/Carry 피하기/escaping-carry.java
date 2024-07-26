import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static String[] nums;
    static boolean isAvailable;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new String[n];
        for (int i = 0; i < n; i++) {
            nums[i] = br.readLine();
        }

        for (int i = 2; i <= n; i++) {
            isAvailable = false;
            back(0, i, 0, new int[i]);
            if (!isAvailable) {
                System.out.println(i - 1);
                return;
            }
        }

        System.out.println(n);
    }

    private static void back(int depth, int target, int start, int[] choices) {
        if (depth == target) {
            String[] choiceNums = new String[target];
            
            int maxLen = Integer.MIN_VALUE;
            for (int i = 0; i < target; i++) {
                choiceNums[i] = nums[choices[i]];
                maxLen = Math.max(maxLen, choiceNums[i].length());
            }
            int curLen = 1;
            boolean canCarry = true;
            while (curLen <= maxLen) {
                int sum = 0;
                for (String choiceNum : choiceNums) {
                    if (curLen > choiceNum.length()) {
                        continue;
                    }
                    int idx = choiceNum.length() - curLen;
                    sum += choiceNum.charAt(idx) - '0';
                }

                if (sum >= 10) {
                    canCarry = false;
                    break;
                }
                curLen++;
            }

            if (canCarry) {
                isAvailable = true;   
            }

            return;
        }

        for (int i = start; i < n; i++) {
            choices[depth] = i;
            back(depth + 1, target, i + 1, choices);
        }
    }
}