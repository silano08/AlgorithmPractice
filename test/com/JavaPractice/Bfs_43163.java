package com.JavaPractice;

public class Bfs_43163 {
    // https://school.programmers.co.kr/learn/courses/30/lessons/43163
    // 다시 풀어봐야할듯



    static int answer;
    static List<String> wordsList;
    static boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE; // 이후 Math.min 비교를 위해 최댓값으로 선언
        wordsList = Arrays.asList(words);

        if(!wordsList.contains(target)){
            return 0;
        }

        for(int i=0; i<words.length; i++){
            if(canChange(begin,wordsList.get(i))){
                visited = new boolean[words.length];
                visited[i] = true;
                dfs(1,wordsList.get(i),target);
            }
        }

        return answer;

    }

    private void dfs(int index, String begin, String target){
        if(begin.equals(target)){
            // 만약 시작값과 목표값이 같아진 상황이라면
            answer = Math.min(index,answer);
            return;
        }

        for(int i=0; i<wordsList.size(); i++){
            // 방문한적 없고, 바꿀수있는 값이라면
            if(!visited[i] && canChange(begin, wordsList.get(i))){
                visited[i] = true;
                // 재귀
                dfs(index+1, wordsList.get(i),target);
                visited[i] = false;
            }
        }

    }

    private static boolean canChange(String begin, String target) {
        int notEqualsSize = 0;

        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != target.charAt(i)) {
                notEqualsSize++;
            }
        }

        return notEqualsSize == 1;
    }
}
