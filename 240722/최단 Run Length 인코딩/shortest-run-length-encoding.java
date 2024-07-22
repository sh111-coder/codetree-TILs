import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int len = str.length();

        if (len == 1) {
            System.out.println(2);
            return;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= len; i++) {
            String[] splitStr = str.split("");
            StringBuilder sb = new StringBuilder();
            sb.append(splitStr[len - 1]);
            for (int j = 0; j < len - 1; j++) {
                sb.append(splitStr[j]);
            }

            String newStr = sb.toString();
            str = newStr;
            StringBuilder newSb = new StringBuilder();
            int temp = 1;
            boolean isAllSame = true;
            for (int j = 0; j < len; j++) {
                char c1;
                char c2;
                if (j == len - 1) {
                    c1 = newStr.charAt(j);
                    c2 = newStr.charAt(j - 1);
                } else {
                    c1 = newStr.charAt(j);
                    c2 = newStr.charAt(j + 1);
                }
                
                if (c1 == c2 && j != len - 1) {
                    temp++;
                } else if (c1 == c2 && j == len - 1) {
                    newSb.append(c1 + String.valueOf(temp));
                } else {
                    newSb.append(c1 + String.valueOf(temp));
                    temp = 1;
                }
            }

            int tempLen = newSb.toString().length();
            min = Math.min(min, tempLen);
        }

        System.out.println(min);
    }
}