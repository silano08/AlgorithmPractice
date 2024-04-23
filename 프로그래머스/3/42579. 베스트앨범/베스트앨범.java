import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String,Integer> GenreSet = new HashMap<>();
        HashMap<String,LinkedList<int[]>> EachIndexSet = new HashMap<>(); 
        //LinkedList<int[]>에서 int[0]에는 index, int[1]에는 재생횟수를 넣을것
        
        for(int i=0; i<genres.length; i++){
            if(GenreSet.containsKey(genres[i])){
                GenreSet.put(genres[i],GenreSet.get(genres[i])+plays[i]);
                LinkedList<int[]> preList = EachIndexSet.get(genres[i]);
                preList.add(new int[]{i,plays[i]});
            }else{
                GenreSet.put(genres[i],plays[i]);
                LinkedList<int[]> list = new LinkedList<>();
                EachIndexSet.put(genres[i],list);
                list.add(new int[]{i,plays[i]});
            }
        }
        
        int resultIndexNum = 0;
        for(String G : EachIndexSet.keySet()){
            // System.out.println(G+":"+EachIndexSet.get(G).size());
            if(EachIndexSet.get(G).size() < 2){
                resultIndexNum+= EachIndexSet.get(G).size();
                // System.out.println(G+":"+EachIndexSet.get(G).size());
            }else{
                resultIndexNum+= 2;
            }
        }
        
        
        TreeMap<Integer, String> sortedByValue = new TreeMap<>(Comparator.reverseOrder());
        for (Map.Entry<String, Integer> entry : GenreSet.entrySet()) {
            sortedByValue.put(entry.getValue(), entry.getKey());
        }
        
        
        int[] answer = new int[resultIndexNum];
        for(int i=0; i<resultIndexNum; i+=2){
            
            Map.Entry<Integer, String> pollFirstEntry = sortedByValue.pollFirstEntry();
            LinkedList<int[]> genreList = EachIndexSet.get(pollFirstEntry.getValue());
            Collections.sort(genreList, (a, b) -> Integer.compare(b[1], a[1]));
            
            if(genreList.size() >= 2){
                answer[i] = genreList.pollFirst()[0];
                answer[i+1] = genreList.pollFirst()[0];
            }else{
                answer[i] = genreList.pollFirst()[0];
                i -= 1;
            }
        }
        
        return answer;
    }
}