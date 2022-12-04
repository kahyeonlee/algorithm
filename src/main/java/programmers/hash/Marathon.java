package programmers.hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Marathon {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        //해쉬- 참가자 키, 값(1) 기본설정
        HashMap<String, Integer> map = new HashMap<>();
        for (String player : participant)
            map.put(player, map.getOrDefault(player, 0) + 1);
        //해쉬- 완주자일때 값 -1
        for (String player : completion)
            map.put(player, map.get(player) - 1);

        //읽기 - 값이 0인 key 출력
        Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> result = iterator.next();
            if (result.getValue() != 0) {
                answer = result.getKey();
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        Marathon marathon =new Marathon();
        System.out.println(marathon.solution(participant,completion));
    }
}
