package programmers.sort;

import java.util.Arrays;

//학생들 번호는 체격순
//바로 앞번호의 학생이나 뒷번호의 학생에게만 빌려줄수있다
//전체 학생수 n, 체육복을 도난당한 학생들의 번호 lost, 여벌의 체육복을 가진 학생 번호 reserve
//최대한 많은 학생이 들을 수 있도록 return
public class GymSuit {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);

        //여벌 있는 사람이 잃어버렸을 경우
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    answer++;
                    break;
                }
            }
        }
        //여벌 있는 사람 한테 빌리는 경우
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i]-1 == reserve[j] || lost[i]+1 == reserve[j]) {
                    reserve[j] = -1;
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        GymSuit gs = new GymSuit();
        System.out.println(gs.solution(n, lost, reserve));

    }
}
