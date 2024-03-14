package baekjoon;
import java.util.*;
import java.util.stream.Collectors;

public class MoreSpicy {
    static public int solution(int[] scoville, int K) {

        int cnt=0;
        List<Integer> list = Arrays.stream(scoville).boxed().collect(Collectors.toList());
        //Int배열을 Integer List로 변환
        //boxed() primitive type -> 래퍼 클래스로 변경

        while(true){
            Collections.sort(list);
            if(list.get(0)>=K) break; //Collctions 유틸리티 클래스, list.sort(Comparator.naturalOrder()); //List I/F에 있는 sort()로 변경
            if(list.size()==1 && list.get(0)<K) {cnt=-1; break;} //모든 스코빌 지수 k이상으로 만들 수 없을 때 -1리턴

            int v1 = list.remove(0);
            int v2 = list.remove(0);
            list.add(v1+(v2*2));
            cnt++;
        }

        int answer = cnt;
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[]{0,1,1,2,4,3,1},7));
    }
}
