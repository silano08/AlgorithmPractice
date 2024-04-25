import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int r = w * 2 + 1;                         // 범위
        int start = 1;
        int end = 0;

        for (int station : stations) {
            end = station - w - start;             // 기지국에서 닿지 않는 거리
            if (station - w > start) {             // 현재 닿지 않는 거리만큼의 값을 범위값으로 나눠 기지국 갯수 추가
                answer += (end) / r;
                if (end % r != 0) answer++;
            }
            start = station + w + 1;
        }

        if (start <= n) {                          // 마지막 기지국 뒤에 안 닿는 곳 남아 있으면 기지국 추가
            end = (n + 1) - start;
            answer += (end) / r;
            if (end % r != 0) answer++;
        }

        return answer;
    }
}