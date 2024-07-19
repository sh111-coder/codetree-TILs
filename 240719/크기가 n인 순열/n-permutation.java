import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];

        back(0, new int[n]);
    }

    private static void back(int depth, int[] choice) {
        if (depth == n) {
            for (int num : choice) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                choice[depth] = i;
                back(depth + 1, choice);
                visited[i] = false;
            }
        }
    }
}