package baekjoon;
import java.util.Scanner;

public class SugarDelivery {

    public static int solution(int gram){
        //3킬로그램 봉지와 5킬로그램 봉지
        //총량(gram)을 최소의 봉지 개수로 배달하기
        int cnt=0;

        while(gram>0){
            if(gram%5 == 0){
                cnt += gram/5;
                break;
            }
            gram-=3;
            cnt++;
        }

        if(gram < 0) return -1;
        int count=cnt;
        return count;
    }

    //5킬로, 3킬로
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(solution(in.nextInt()));
    }
}