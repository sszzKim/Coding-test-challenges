package baekjoon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MockExam2 {
    static public int[] solution(int[] answers) {
        int a[] = {1, 2, 3, 4, 5};
        int b[] = {2, 1, 2, 3, 2, 4, 2, 5};
        int c[] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] answerCnt = new int[3];

        for(int i=0;i< answers.length;i++){
            if(answers[i]==a[i%a.length]) answerCnt[0]++; //증감식은 배열이 더 편하다. list는 get과 set 2개를 써야하기 때문에
            if(answers[i]==b[i%b.length]) answerCnt[1]++;
            if(answers[i]==c[i%c.length]) answerCnt[2]++;
        }

        int max = (Math.max( Math.max(answerCnt[0],answerCnt[1]),answerCnt[2]));
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<answerCnt.length;i++){
            if(answerCnt[i] == max){list.add(i+1);}
        }
        //System.out.println( Collections.max(list).getClass().getName()); //형 확인
        //System.out.println("dd"+list.indexOf(Collections.max(list))); //이 메소드는 첫번째 위치값을 찾을 경우 그 자리에서 종료, 최고득점자가 중복일 때는 사용할 수 없음

        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1,2,3,4,5})));
    }
}
