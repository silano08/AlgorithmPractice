import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genrePlayCount = new HashMap<>();
        HashMap<String, LinkedList<int[]>> genreTracks = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);
            genreTracks.computeIfAbsent(genres[i], k -> new LinkedList<>()).add(new int[]{i, plays[i]});
        }

        List<Integer> answerList = new ArrayList<>();
        
        genrePlayCount.entrySet().stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
            .forEach(entry -> {
                LinkedList<int[]> tracks = genreTracks.get(entry.getKey());
                tracks.sort((a, b) -> b[1] - a[1]);
                answerList.add(tracks.get(0)[0]);
                if (tracks.size() > 1) {
                    answerList.add(tracks.get(1)[0]);
                }
            });

        return answerList.stream().mapToInt(i -> i).toArray();
    }
}
