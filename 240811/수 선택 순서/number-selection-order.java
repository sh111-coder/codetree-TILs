import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(input.nextToken());
        int targetIdx = Integer.parseInt(input.nextToken());
        int target = 0;

        // num, idx
        Queue<int[]> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        StringTokenizer queueInput = new StringTokenizer(br.readLine());        
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(queueInput.nextToken());
            queue.add(new int[]{num, i});
            pq.add(num);

            if (targetIdx == i) {
                target = num;
            }
        }

        int cnt = 0;
        while (true) {

            int[] head = queue.peek();
            int pqHead = pq.peek();

            if (head[0] == pqHead) {
                queue.poll();
                pq.poll();
                cnt++;
                if (head[0] == target && head[1] == targetIdx) {
                    System.out.println(cnt);
                    break;
                }
            } else {
                int[] nums = queue.poll();
                queue.add(nums);
            }

        }
    }
}