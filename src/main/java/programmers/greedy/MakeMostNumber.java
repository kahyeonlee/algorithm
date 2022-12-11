package programmers.greedy;


import java.util.Stack;

public class MakeMostNumber {
    public String solution(String number, int k) {

        char[] results = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);

            //1231234
            System.out.printf("k의값 %d\n",k);
            System.out.printf("c의값 %c\n",c);
            System.out.println(stack);
            System.out.println("---------------");

            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }

        //stack 배열로 바꾸기
        for (int i = 0; i < results.length; i++) {
            results[i] = stack.get(i);
        }

        //가장 큰 문자열 반환
        return new String(results);
    }


    public static void main(String[] args) {
        MakeMostNumber mmn = new MakeMostNumber();
        System.out.println(mmn.solution("1231234", 3));
    }

}
