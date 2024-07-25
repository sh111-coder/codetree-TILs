import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());
        String str = input.nextToken();
        int n = Integer.parseInt(input.nextToken());

        for (int i = 0; i < n; i++) {
            int idx = Integer.parseInt(br.readLine()) - 1;
            if (idx >= str.length()) {
                continue;
            }
            String s1 = str.substring(0, idx);
            String s2 = str.substring(idx + 1, str.length());
            str = s1 + s2;
            System.out.println(str);
        }
    }
}