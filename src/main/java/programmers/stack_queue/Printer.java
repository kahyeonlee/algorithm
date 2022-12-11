package programmers.stack_queue;
//중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발
//1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
//2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
//3. 그렇지 않으면 J를 인쇄합니다.
//내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return

import java.util.Comparator;
import java.util.PriorityQueue;

public class Printer {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        //내림차순 정렬
        PriorityQueue<Integer> pq = new PriorityQueue(Comparator.reverseOrder());
        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
        }
        System.out.println(pq);

        //priorities의 위치랑 일치하면 리턴
        //1, 1, 9, 1, 1, 1
        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                System.out.printf("priorities[%d](%d) = pq.peek(%d)\n",i,priorities[i],pq.peek());
                if (priorities[i]==pq.peek()){
                    if (i == location) {
                        answer++;
                        return answer;
                    }
                    pq.poll();
                    answer++;
                    System.out.printf("answer = %d\n",answer);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 9, 1, 1, 1};
        Printer p = new Printer();
        System.out.println(p.solution(arr,0));
    }
}
