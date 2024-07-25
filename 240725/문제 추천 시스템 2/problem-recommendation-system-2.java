import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // 그룹별 문제
        Map<Integer, List<Integer>> problemsByGroup = new HashMap<>();

        // 문제별 난이도
        Map<Integer, Integer> difficultByProblem = new HashMap<>();

        // 모든 문제
        List<Integer> problems = new ArrayList<>();


        // 문제 번호 (P), 난이도 (L), 그룹 (G)
        for (int i = 0; i < n; i++) {
            StringTokenizer problemInput = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(problemInput.nextToken());
            int L = Integer.parseInt(problemInput.nextToken());
            int G = Integer.parseInt(problemInput.nextToken());

            if (!problemsByGroup.containsKey(G)) {
                problemsByGroup.put(G, new ArrayList<>());
            }
            problemsByGroup.get(G).add(P);
            difficultByProblem.put(P, L);
            problems.add(P);
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer commandInput = new StringTokenizer(br.readLine());
            String command = commandInput.nextToken();
            if (command.equals("rc1")) {
                int x = Integer.parseInt(commandInput.nextToken());
                int G = Integer.parseInt(commandInput.nextToken());

                if (!problemsByGroup.containsKey(G)) {
                    System.out.println(-1);
                    continue;
                }

                List<Integer> groupProblems = problemsByGroup.get(G);
                Collections.sort(groupProblems, (problem1, problem2) -> {
                    int difficult1 = difficultByProblem.get(problem1);
                    int difficult2 = difficultByProblem.get(problem2);
                    if (difficult1 == difficult2) {
                        return problem1 - problem2;
                    }
                    return difficult1 - difficult2;
                });
            
                if (x == 1) {
                    System.out.println(groupProblems.get(groupProblems.size() - 1));
                } else {
                    System.out.println(groupProblems.get(0));
                }
            } else if (command.equals("rc2")) {
                int x = Integer.parseInt(commandInput.nextToken());
                Collections.sort(problems, (problem1, problem2) -> {
                    int difficult1 = difficultByProblem.get(problem1);
                    int difficult2 = difficultByProblem.get(problem2);
                    if (difficult1 == difficult2) {
                        return problem1 - problem2;
                    }
                    return difficult1 - difficult2;
                });

                if (x == 1) {
                    System.out.println(problems.get(problems.size() - 1));
                } else {
                    System.out.println(problems.get(0));
                }
            } else if (command.equals("rc3")) {
                int x = Integer.parseInt(commandInput.nextToken());
                int L = Integer.parseInt(commandInput.nextToken());

                if (x == 1) {
                    List<Integer> overDifficultProblems = problems.stream()
                        .filter(problem -> difficultByProblem.get(problem) >= L)
                         .sorted((problem1, problem2) -> {
                            int difficult1 = difficultByProblem.get(problem1);
                            int difficult2 = difficultByProblem.get(problem2);
                            if (difficult1 == difficult2) {
                                return problem1 - problem2;
                            }
                            return difficult1 - difficult2;
                        })
                        .collect(Collectors.toList());
                    if (overDifficultProblems.isEmpty()) {
                        System.out.println(-1);
                        continue;
                    }
                    System.out.println(overDifficultProblems.get(0));
                } else {
                    List<Integer> underDifficultProblems = problems.stream()
                        .filter(problem -> difficultByProblem.get(problem) < L)
                         .sorted((problem1, problem2) -> {
                            int difficult1 = difficultByProblem.get(problem1);
                            int difficult2 = difficultByProblem.get(problem2);
                            if (difficult1 == difficult2) {
                                return problem2 - problem1;
                            }
                            return difficult2 - difficult1;
                        })
                        .collect(Collectors.toList());
                    if (underDifficultProblems.isEmpty()) {
                        System.out.println(-1);
                        continue;
                    }
                    System.out.println(underDifficultProblems.get(0));
                }
            } else if (command.equals("ad")) {
                int P = Integer.parseInt(commandInput.nextToken());
                int L = Integer.parseInt(commandInput.nextToken());
                int G = Integer.parseInt(commandInput.nextToken());

                if (!problemsByGroup.containsKey(G)) {
                    problemsByGroup.put(G, new ArrayList<>());
                }
                problemsByGroup.get(G).add(P);
                difficultByProblem.put(P, L);
                if (!problems.contains(P)) {
                    problems.add(P);
                }
            } else if (command.equals("sv")) {
                int P = Integer.parseInt(commandInput.nextToken());
                for (List<Integer> eachProblems1 : problemsByGroup.values()) {
                    if (eachProblems1.contains(P)) {
                        eachProblems1.remove(P);
                        break;
                    }
                }
                for (Integer eachProblems2 : difficultByProblem.keySet()) {
                    if (eachProblems2 == P) {
                        difficultByProblem.remove(P);
                    }
                }
                problems.remove(P);
            }
        }
    }
}