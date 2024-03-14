package baekjoon;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Clothes {

    public int solution(String[][] clothes) {
        //1. 문제 설명
        /* 옷 조합수를 구하기
        * 조건1. 종류별 최대 1가지 의상만 착장 가능 (ex) 안경을 2개 쓸 수 없음)
        * 조건2. 모든 종류를 전부 입을 필요는 없다.
        * 조건3. 대신 최소 한 개의 의상은 입는다.
        * */

        //2. 전체적 흐름
        //3. 세부 설명

        //MAP 생성 및 초기화
        Map<String, Integer> map = new HashMap<>();
        for( String[] arr : clothes){
            map.put(arr[1],map.getOrDefault(arr[1],0)+1);
        }

        //입지않은 경우를 추가하여 모든 조합 계산하기
        Iterator<Integer> it  =map.values().iterator();
        int answer = 1;

        while (it.hasNext()){
            answer *= it.next() + 1;
        }

        //모든 입지 않은 경우 제외(조건 3)
        return answer-1;
    }
    public static void main(String[] args) {
        String[][] s = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        Clothes clothes = new Clothes();
        System.out.println(clothes.solution(s));
    }
}
