package baekjoon;
import java.util.LinkedList;
import java.util.Queue;

public class TruckPassingBridge {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        /*
         * 모든 트럭이 다리를 건너는데 걸리는 시간을 구하는 문제
         * bridge_length 대 올라갈 수있고, weight 이하까지 무게를 견딜 수 있다.
         * 큐를 1개 이동하는데 1초가 걸림
         * */
        Queue<Integer> queue = new LinkedList<>();
        int time = 0;
        int current_weight = 0;
        for(int truck : truck_weights){
            int current_truck = truck;

            while (true){
                //case1) 큐에 아무것도 없을 때
                //case2) 큐가 다 차있을 때
                //case3) 다리 길이만큼 큐가 차지 않았을 때
                if(queue.isEmpty()){
                    queue.add(current_truck);
                    time++;
                    current_weight+=current_truck;
                    break;
                }else if(queue.size()==bridge_length){
                    current_weight-=queue.poll();
                }
                else{
                    if(current_weight+current_truck > weight){
                        queue.add(0);
                        time++;
                    }else{
                        queue.add(current_truck);
                        time++;
                        current_weight+=current_truck;
                        break;
                    }
                }
            }
        }

        int answer = time+bridge_length; //마지막 트럭이 다 건널 때까지
        return answer;

    }

    public static void main(String[] args) {
        TruckPassingBridge ob = new TruckPassingBridge();
        System.out.println(ob.solution(2, 10, new int[]{7,4,5,6}));
    }
}
