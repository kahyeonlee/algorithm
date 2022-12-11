package programmers.stack_queue;

import java.util.Stack;

public class BracketCount {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }

        }

        if (!stack.isEmpty()) {
            return false;
        }

        return answer;
    }

    public static void main(String[] args) {
        BracketCount bc = new BracketCount();
        System.out.println(bc.solution(")()()"));
    }

}
