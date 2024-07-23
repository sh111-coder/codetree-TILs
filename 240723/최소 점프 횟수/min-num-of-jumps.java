import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int min = Integer.MIN_VALUE;
    static int[] jump;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        jump = new int[n];
        StringTokenizer jumpInput = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            jump[i] = Integer.parseInt(jumpInput.nextToken());
        }

        bfs(0);

        if (min == Integer.MIN_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }


    }

    private static void bfs(int startIdx) {
        // idx, jumpCnt
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startIdx);

        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int idx = queue.poll();
                if (idx == n - 1) {
                    min = cnt;
                    return;
                }

                for (int j = idx + 1; j <= idx + jump[idx]; j++) {
                    if (j >= n) {
                        break;
                    }
                    queue.add(j);
                }
            }
            cnt++;
        }
    }
}