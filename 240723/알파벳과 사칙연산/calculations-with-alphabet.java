import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int choiceCnt;
    static int max = Integer.MIN_VALUE;
    static Map<Character, Integer> charIdxMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int idx = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isAlphabetic(c) && !charIdxMap.containsKey(c)) {
                charIdxMap.put(c, idx);
                idx++;
            }
        }

        choiceCnt = charIdxMap.size();
        if (choiceCnt == 1) {
            System.out.println(4);
            return;
        }


        back(0, input, new int[choiceCnt]);
        System.out.println(max);
    }

    private static void back(int depth, String input, int[] choice) {
        if (depth == choiceCnt) {
            int result = calculate(input, choice);
            max = Math.max(max, result);
            return;
        }

        for (int i = 1; i <= 4; i++) {
            choice[depth] = i;
            back(depth + 1, input, choice);
        }
    }

    private static int calculate(String input, int[] choice) {
        int result = 0;

        // 처음 계산
        char firstC = input.charAt(0);
        int firstNum = choice[charIdxMap.get(firstC)];
        char secondC = input.charAt(2);
        int secondNum = choice[charIdxMap.get(secondC)];
        char firstSymbol = input.charAt(1);
        
        result = calculateBySymbol(firstNum, secondNum, firstSymbol);

        // 이후 계산
        for (int i = 3; i < input.length(); i += 2) {
            char c = input.charAt(i + 1);
            int num = choice[charIdxMap.get(c)];
            char symbol = input.charAt(i);
            int newResult = calculateBySymbol(result, num, symbol);
            result = newResult;
        }

        return result;
    }

    private static int calculateBySymbol(int num1, int num2, char symbol) {
        if (symbol == '+') {
            return num1 + num2;
        } else if (symbol == '-') {
            return num1 - num2;
        }
        return num1 * num2;
    }
}