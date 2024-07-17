import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, Q;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());

        N = Integer.parseInt(input.nextToken());
        M = Integer.parseInt(input.nextToken());
        Q = Integer.parseInt(input.nextToken());

        // 전파 방향 맵
        Map<String, String> waveDirection = new HashMap<>();
        waveDirection.put("L", "R");
        waveDirection.put("R", "L");

        // 맵 초기화
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer status = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(status.nextToken());
            }
        }

        // 바람에 따라 이동
        for (int i = 0; i < Q; i++) {
            StringTokenizer wind = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(wind.nextToken()) - 1;
            String direction = wind.nextToken();
            moveMap(row, direction);

            int upRow = row;
            String upDirection = direction;
            int downRow = row;
            String downDirection = direction;
       
            // 위로 전파
            while (canUpWave(upRow)) {
                upRow--;
                upDirection = waveDirection.get(upDirection);
                moveMap(upRow, upDirection);
            }

            // 아래로 전파
            while (canDownWave(downRow)) {
                downRow++;
                downDirection = waveDirection.get(downDirection);
                moveMap(downRow, downDirection);
            }
        }

        for (int i = 0; i < N; i++) {
            int[] rowMap = map[i];
            for (int status : rowMap) {
                System.out.print(status + " ");
            }
            System.out.println();
        }
    }

    private static void moveMap(int row, String direction) {
        int[] target = map[row];
        if (direction.equals("L")) {
            int temp = target[M - 1];
            for (int i = M - 1; i >= 1; i--) {
                map[row][i] = target[i - 1];
            }
            map[row][0] = temp;
        }
        if (direction.equals("R")) {
            int temp = target[0];
            for (int i = 0; i < M - 1; i++) {
                map[row][i] = target[i + 1];
            }
            map[row][M - 1] = temp;
        }
    }

    private static boolean canUpWave(int row) {
        int targetRow = row - 1;
        if (targetRow < 0) {
            return false;
        }
        
        for (int i = 0; i < M; i++) {
            int status1 = map[row][i];
            int status2 = map[targetRow][i];
            if (status1 == status2) {
                return true;
            }
        }

        return false;
    }

    private static boolean canDownWave(int row) {
        int targetRow = row + 1;
        if (targetRow >= N) {
            return false;
        }

        for (int i = 0; i < M; i++) {
            int status1 = map[row][i];
            int status2 = map[targetRow][i];
            if (status1 == status2) {
                return true;
            }
        }

        return false;


    }
}