class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] list = s.split("");
        boolean start = true;
        
        for(String i : list){
            
            // System.out.println(start);
            
            if(start){
                answer+= i.toUpperCase();
                start = false;
            }else{
                answer+= i.toLowerCase();
            }
            
            if(i.equals(" ")){ start = true;}
            // System.out.println(answer);
            
        }
        
        return answer;
    }
}