class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        // O(n^2)까지 허용
        
        for(int i=0; i<prices.length; i++){
            int count = 0;
            
            for(int j=i+1; j<prices.length; j++){
                if(j == prices.length) break;
                if(prices[j] >= prices[i]){
                    count+= 1;
                }else{
                    count+= 1;
                    break;
                }
            }
            
            
            // if(count == 0 && i != (prices.length-1)) count = 1;
            
            answer[i] = count;
        }
        
        return answer;
    }
}