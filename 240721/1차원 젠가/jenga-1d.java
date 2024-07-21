import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] block = new int[n];

        for (int i = 0; i < n; i++) {
            block[i] = Integer.parseInt(br.readLine());
        }

        int size = block.length;

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            size -= (end - start + 1);

            for (int j = start; j <= end; j++) {
                block[j] = 0;
            }

            int[] temp = new int[size];
            
            int tempIdx = 0;
            for (int j = 0; j < block.length; j++) {
                int num = block[j];
                if (num != 0) {
                    temp[tempIdx] = num;
                    tempIdx++;
                }
            }

            block = new int[size];
            for (int j = 0; j < size; j++) {
                block[j] = temp[j];
            } 
        }

        System.out.println(size);
        for (int i = 0; i < size; i++) {
            System.out.println(block[i]);
        }
    }
}