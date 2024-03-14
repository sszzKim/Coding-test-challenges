package baekjoon;
public class MinimumRectangle {
    static public int solution(int[][] sizes) {
        /*
        * 각 명함의 가로, 세로 길이가 주어졌을 때 모든 명함을 담을 수 있는 크기를 구하기
        * 명함의 길이 중 긴 길이는 긴 길이끼리 비교, 짧은 길이는 짧은 길이끼리 비교
        * */
        int MaxOfMax = 0, MaxOfMin = 0;
        for(int i=0; i< sizes.length; i++){
            MaxOfMax = Math.max(MaxOfMax, (Math.max(sizes[i][0],sizes[i][1])));
            MaxOfMin = Math.max(MaxOfMin, (Math.min(sizes[i][0],sizes[i][1])));
        }

        int answer = MaxOfMax*MaxOfMin;
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}));
    }
}
