import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] map = new String[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], "BLANK");
        }
        int startRow = n / 2;
        int startCol = n / 2;

        int curH = 1;
        int curCharAscii = 'A' - 0;

        while (startCol >= 0) {
            int curRow = startRow;
            int curCol = startCol;

            for (int i = 0; i < curH; i++) {
                map[curRow][curCol] = String.valueOf((char) curCharAscii);
                curRow++;
                if ((char) curCharAscii == 'Z') {
                    curCharAscii = 'A' - 0;
                } else {
                    curCharAscii++;
                }
            }
            startRow--;
            startCol--;
            curH += 2;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].equals("BLANK")) {
                    break;
                }
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}