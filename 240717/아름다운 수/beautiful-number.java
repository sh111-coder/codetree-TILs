import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        back(0, "");
        System.out.println(result);
    }

    private static void back(int depth, String cur) {
        if (depth == n) {
            int index = 0;
            while (index < cur.length()) {
                char c = cur.charAt(index);
                int num = c - '0';
                int cnt = 0;
                int max = index + num;
                for (int j = index; j < max; j++) {
                    if (j >= cur.length()) {
                        break;
                    }

                    char newC = cur.charAt(j);
                    if (c == newC) {
                        cnt++;
                        index++;
                    }
                }

                if (cnt % num != 0) {
                    return;
                }
            }

            result++;
            return;
        }

        for (int i = 1; i <= 4; i++) {
            back(depth + 1, cur + i);
        }
    }
}