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

        int size = n * 3;
        int realT = t % size;

        int[][] conveyor = new int[3][n];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        StringTokenizer st4 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            conveyor[0][i] = Integer.parseInt(st2.nextToken());
            conveyor[1][i] = Integer.parseInt(st3.nextToken());
            conveyor[2][i] = Integer.parseInt(st4.nextToken());
        }

        for (int i = 0; i < realT; i++) {
            int upTemp = conveyor[0][n - 1];
            int middleTemp = conveyor[1][n - 1];
            int bottomTemp = conveyor[2][n - 1];
            
            for (int j = n - 1; j >= 1; j--) {
                conveyor[0][j] = conveyor[0][j - 1];
                conveyor[1][j] = conveyor[1][j - 1];
                conveyor[2][j] = conveyor[2][j - 1];
            }

            conveyor[0][0] = bottomTemp;
            conveyor[1][0] = upTemp;
            conveyor[2][0] = middleTemp;
        }

        for (int[] eachConveyor : conveyor) {
            for (int num : eachConveyor) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}