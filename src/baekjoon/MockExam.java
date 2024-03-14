package baekjoon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MockExam {
    static public int[] solution(int[] answers) {
        int a[] = {1, 2, 3, 4, 5};
        int b[] = {2, 1, 2, 3, 2, 4, 2, 5};
        int c[] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] answerCnt = new int[3];
        //List<Integer> answerCnt = List.of(0,0,0);

        for(int i=0;i< answers.length;i++){
            if(answers[i]==a[i%a.length]) answerCnt[0]++; //증감식은 배열이 더 편하다. list는 get과 set 2개를 써야하기 때문에
            if(answers[i]==b[i%b.length]) answerCnt[1]++;
            if(answers[i]==c[i%c.length]) answerCnt[2]++;
        }

        //int max = Math.max(Math.max(answers[0],answers[1]),answers[2]);
        //Arrays.sort(answers);
        //for(int i :answers)

        //toList
        List<Integer> list = Arrays.stream(answerCnt).boxed().collect(Collectors.toList()); //int배열 -> Integer List
        List<Integer> ansser = new ArrayList<>();
        int max = Collections.max(list);
        System.out.println(list.toString());
        System.out.println(max);
        Collections.sort(list); //이걸 왜 했을까?? 최대값을 가져오려고??
        for(int i=0; i<list.size();i++){
            //if(list.get(i)!=max){list.remove(i);} // index를 컨트롤 할 땐는 remove사용하면 안 됨, index가 변경됨
            //else{list.set(i,i+1);} //list index값을 어케 가져올지 모르겠다. 이렇게 사용할바엔 ket value 형식의 Map 사용이 좋아보임
            if(list.get(i) == max){ansser.add(i);System.out.println("i: "+i);}
            //System.out.println("i: "+i);
        }
        //System.out.println( Collections.max(list).getClass().getName()); //형 확인
        //System.out.println("dd"+list.indexOf(Collections.max(list))); //이 메소드는 첫번째 위치값을 찾을 경우 그 자리에서 종료, 최고득점자가 중복일 때는 사용할 수 없음

        int[] answer = ansser.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1,2,3,4,5})));
    }
}
