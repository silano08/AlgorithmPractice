import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        PriorityQueue<Integer> AQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> BQueue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<A.length; i++){
            AQueue.add(A[i]);
            BQueue.add(B[i]);
        }
        
        for(int i=0; i< A.length; i++){
            if(AQueue.peek() < BQueue.peek()){
                answer+= 1;
                AQueue.poll();
                BQueue.poll();
            }else{ //(AQueue.peek() > BQueue.peek()), 같을때도 별개로 고려해야하나?
                // 더 클때는 B가 졌다고 치고 B에서 값을 뽑지 않는것(다음에 올 A와 싸워하니까)
                AQueue.poll();
            }
            
        }
        
        return answer;
    }
}