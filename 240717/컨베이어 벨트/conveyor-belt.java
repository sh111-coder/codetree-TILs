import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int t = Integer.parseInt(st1.nextToken());

        int[] up = new int[n];
        int[] bottom = new int[n];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            up[i] = Integer.parseInt(st2.nextToken());
            bottom[i] = Integer.parseInt(st3.nextToken());
        }


        int size = n * 2;
        int realT = t % size;

        for (int i = 0; i < realT; i++) {
            int upTemp = up[n - 1];
            int bottomTemp = bottom[n - 1];
            
            for (int j = n - 1; j >= 1; j--) {
                up[j] = up[j - 1];
                bottom[j] = bottom[j - 1];
            }
            up[0] = bottomTemp;
            bottom[0] = upTemp;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(up[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(bottom[i] + " ");
        }
    }
}