import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(input.nextToken());
        int B = Integer.parseInt(input.nextToken());

        int[][] prices = new int[N][2];
        int[] sumPrices = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer priceInput = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(priceInput.nextToken());
            int S = Integer.parseInt(priceInput.nextToken());
            prices[i][0] = P;
            prices[i][1] = S;
            sumPrices[i] = P + S;
        }

        Arrays.sort(sumPrices);

        // 2 6 9 9 17
        int overIdx = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (sum + sumPrices[i] > B) {
                overIdx = i;
                break;
            }
            sum += sumPrices[i];
        }

        if (overIdx == Integer.MAX_VALUE) {
            System.out.println(N);
        } else {
            int discountP = prices[overIdx][0] / 2;
            int S = prices[overIdx][1];
            if (sum + (discountP + S) <= B) {
                System.out.println(overIdx + 1);
            } else {
                System.out.println(overIdx);
            }
        }
    }
}