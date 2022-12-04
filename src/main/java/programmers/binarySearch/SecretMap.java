package programmers.binarySearch;

import java.util.Arrays;

public class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        //n의 배열크기
        String[] answer = new String[n];
        String[] answer1 = new String[n];
        String[] answer2 = new String[n];
        //배열 1, 2 두중하나개만 있으면 #, 아예 없으면 공백 -> 비트 연산
        for (int i = 0; i < n; i++) { // (9|30)
            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]); //2진법 로직

            //1->#, 0-> 공백
            answer[i] = answer[i].replace('1', '#').replace('0', ' ');

            //맨 앞자리가 공백일 경우 처리
            answer[i] = String.format("%" + n + "s", answer[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        SecretMap sm = new SecretMap();
        System.out.println(Arrays.toString(sm.solution(5, arr1, arr2)));

    }
}
