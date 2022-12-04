package programmers.completeSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//가장 많은 문제를 맞힌 사람이 누구인지 반환
//가장 높은 점수가 동점일때 , 사람 오름차순
//수포자1 ={1, 2, 3, 4, 5}
//수포자2 ={2, 1, 2, 3, 2, 4, 2, 5}
//수포자3 ={3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
public class MockTest {
    public int[] solution(int[] answers) {
        int[] scores = {0, 0, 0}; //점수
        int[] first = {1, 2, 3, 4, 5}; // 5개씩 반복
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5}; // 8개씩 반복
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10개씩 반복

        //맞은 개수 구하기
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == first[i % 5]) scores[0]++;
            if (answers[i] == second[i % 8]) scores[1]++;
            if (answers[i] == third[i % 10]) scores[2]++;
        }

        //가장 높은 점수를 받은사람이 여러명일 경우 오름차순
        //가장 높은 점수를 받은 사람
        int max = scores[0];
        for (int i = 0; i < scores.length; i++) {
            if (max < scores[i]) max = scores[i];
        }

        //list에 수포자 번호넣기
        List<Integer> list = new ArrayList<>();

        //max가 같은사람 오름차순
        for (int i = 0; i < scores.length; i++) {
            if (max == scores[i]) {
                list.add(i+1);
            }
        }

        //list값 출력
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] answers = {1,2,3,4,5};
        MockTest mt =new MockTest();
        System.out.println(Arrays.toString(mt.solution(answers)));
    }
}
