import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        Set<Integer> compareNums = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            nums[i] = num;
            compareNums.add(num);
        }

        int totalMax = Integer.MIN_VALUE;
        for (Integer compareNum : compareNums) {
            int[] temp = nums.clone();
            for (int i = 0; i < temp.length; i++) {
                int tempNum = temp[i];
                if (tempNum == compareNum) {
                    temp[i] = Integer.MIN_VALUE;
                }
            }

            int curNum = temp[0];
            int len = 1;
            int max = Integer.MIN_VALUE;
            for (int i = 1; i < temp.length; i++) {
                int tempNum = temp[i];
                if (tempNum == Integer.MIN_VALUE) {
                    continue;
                }
                
                if (curNum != tempNum) {
                    curNum = tempNum;
                    max = Math.max(max, len);
                    len = 1;
                } else {
                    len++;
                }

            }

            totalMax = Math.max(max, totalMax);
        }
        if (totalMax == Integer.MIN_VALUE) {
            System.out.println(0);
            return;
        } 
        System.out.println(totalMax);
    }
}