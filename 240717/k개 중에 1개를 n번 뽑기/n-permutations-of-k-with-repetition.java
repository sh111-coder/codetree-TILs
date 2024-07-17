import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int K, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        K = Integer.parseInt(input.nextToken());
        N = Integer.parseInt(input.nextToken());

        back(0, "");
    }

    private static void back(int depth, String cur) {
        if (depth == N) {
            System.out.println(cur);
            return;
        }

        for (int i = 1; i <= K; i++) {
            back(depth + 1, cur + i + " ");
        }
    }
}