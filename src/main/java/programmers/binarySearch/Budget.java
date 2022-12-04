package programmers.binarySearch;
//예산 budget
//d -> 부서별 필요한 예산의 배열

import java.util.Arrays;

public class Budget {
qq
    public int solution(int[] d, int budget) {
        int answer = 0;
        //오름차순 정렬해서 0번 부서부터 주면 최대한 많은 부서한테 줄수 있지 않을까?
        Arrays.sort(d);

        for (int i = 0; i < d.length; i++) {
            if (budget >= d[i]) {
                budget -= d[i];
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] d = {1, 3, 2, 5, 4};
        Budget budget = new Budget();
        System.out.println(budget.solution(d, 9));
    }

}
