package baekjoon;
import java.util.ArrayList;
import java.util.List;

public class StockPrice {
   static public int[] solution(int[] prices) {
       //값을 하나하나 비교하나..??

       List<Integer> list = new ArrayList<>();

       for(int i=0; i<prices.length; i++){
           int cnt=0;
           if(i==prices.length-1) {list.add(0); break;} //마지막 값
           for(int j=i+1; j<prices.length; j++){
               if(prices[i] <= prices[j]){
                   cnt++;
               }else{ cnt++; break; }
           }
           list.add(cnt);
       }

        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
    public static void main(String[] args) {
        int[] answer = solution(new int[]{1, 2, 3, 2, 3});
        for(int i : answer){
            System.out.print(i +" ");
        }
    }
}
