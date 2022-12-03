package programmers.sort;

import java.util.Arrays;

public class SmallestNum {
    public int[] solution(int[] arr) {
        //배열길이가 1이하 일때는 return - 1
        if (arr.length == 1) {
            return new int[]{-1};
        }
        int minIdx =0;
        int[] answer = new int[arr.length-1];

        // 가장 작은 수 찾기
        for (int i = 0; i < arr.length; i++) {
            if(arr[minIdx] > arr[i]) minIdx = i;
        }

        //가장 작은 수 빼고 answer에 넣기
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[minIdx]) continue;
            answer[idx++] = arr[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        int[] arr2 = {10};
        SmallestNum sn = new SmallestNum();
        System.out.println(Arrays.toString(sn.solution(arr2)));
        System.out.println(Arrays.toString(sn.solution(arr)));
    }
}
