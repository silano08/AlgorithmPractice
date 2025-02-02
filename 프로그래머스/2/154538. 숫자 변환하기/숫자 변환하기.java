import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        // x와 y가 같다면 바로 0을 반환
        if(x == y) return 0;
        
        // y 이하의 값까지만 방문하면 되므로, y+1 크기의 배열을 사용
        boolean[] visited = new boolean[y + 1];
        
        // 각 상태를 {현재 값, 연산 횟수} 형태로 저장
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, 0});
        visited[x] = true;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int curVal = current[0];
            int count = current[1];
            
            // 세 가지 연산 적용
            int[] nextValues = {curVal + n, curVal * 2, curVal * 3};
            for (int next : nextValues) {
                // 목표 값 y에 도달하면 연산 횟수 +1 반환
                if(next == y) return count + 1;
                // 다음 값이 y 이하이고 아직 방문하지 않았다면
                if(next <= y && !visited[next]){
                    visited[next] = true;
                    queue.offer(new int[]{next, count + 1});
                }
            }
        }
        
        // y로 변환하는 것이 불가능하면 -1 반환
        return -1;
    }
}
