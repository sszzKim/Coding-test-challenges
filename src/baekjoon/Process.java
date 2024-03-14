package baekjoon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Process {

    public int solution(int[] priorities, int location) {
        /*
        * 우선순위따라 프로세스가 실행될 때 특정 프로세스가 몇번째로 실행되는지 알아내는 것
        * 조건 1) 대기중인 것들 중에 우선순위가 더 높은 게 있다면 꺼낸 프로세스는 뒤로
        * 조건 2) 그렇지 않다면 실행
        * */

        int answer = 0;
        int maxPriority = 0; //최대 우선순위 값 저장

        List<Integer> list = new ArrayList<>();
        for(int i :priorities) list.add(i);

        while(true){
            maxPriority = Collections.max(list); //Collections : 컬렉션을 다루기 위한 static 메서드를 제공하는 유틸 클래스
            if(list.get(0) == maxPriority){
                answer++;
                list.remove(0);
                if(location==0) break;
            }else{
                int tmp = list.get(0);
                list.remove(0);
                list.add(tmp);
            }
            //location 움직이기
            //location = (location == 0) ? list.size()-1:(location--);
            location = (location == 0) ? list.size()-1:location-1;
        }
        return answer;
    }

    public static void main(String[] args) {
        Process ob = new Process();
        System.out.println(ob.solution(new int[]{1, 1, 9, 1, 1, 1},0));
    }

}
