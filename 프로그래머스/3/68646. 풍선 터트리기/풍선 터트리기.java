import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 1;
        int leftIndex = 0;
        int rightIndex = a.length - 1;
        int leftMin = a[leftIndex];
        int rightMin = a[rightIndex];
        
        while(leftIndex < rightIndex){
            if(leftMin > rightMin){
                leftIndex++;
                
                if(a[leftIndex] < leftMin){
                    answer++;
                }
                
                leftMin = Math.min(leftMin,a[leftIndex]);
                
            }else{
                rightIndex--;
                
                if(a[rightIndex] < rightMin){
                    answer++;
                }
                
                rightMin = Math.min(rightMin,a[rightIndex]);
                
            }
            
        }
        
        return answer;
    }
}