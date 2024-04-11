import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
    int preIndex = 0; // 뒤쪽 포인터
    int proIndex = 0; // 앞쪽 포인터
    int minLength = Integer.MAX_VALUE;
    int[] answer = {0,0};
    long sum = 0L;
    
    while(true) {
        if(sum>=k){
            if(sum==k && proIndex-preIndex < minLength){
                minLength = proIndex-preIndex;
                answer[0] = preIndex;
                answer[1] = proIndex -1;
            }
            sum -= sequence[preIndex];
            preIndex += 1;
        }else{
            if (proIndex == sequence.length) break;
            sum += sequence[proIndex++];
        }
    }

    return answer;
}
}