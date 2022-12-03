package programmers.sort;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    public String solution(int[] numbers) {
        String answer = "";
        //배열의 값 string으로 바꾸기
        String[] stringNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            stringNumbers[i] = String.valueOf(numbers[i]);
        }
        // 가장 큰 수 구하기(사전순으로 내림차순)
        Arrays.sort(stringNumbers, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        });
        //람다식 Arrays.sort(stringNumbers, (a, b)->(b + a).compareTo(a + b));

        //배열의 모든 값이 0일때 인덱스0이 "0" 이기 때문에 0으로 처리
        if (stringNumbers[0].equals("0")) return "0";

        //문자 배열 붙이기
        return answer = String.join("", stringNumbers);
    }

    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
        LargestNumber ln = new LargestNumber();
        System.out.println(ln.solution(numbers));
    }
}
