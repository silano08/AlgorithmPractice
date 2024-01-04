package com.JavaPractice.pccp;

import java.util.ArrayList;

public class pccp1_no2 {


    // 순열로 모든 경우의수를 구하고 해당 경우의수의 점수를 구한뒤 max를 찾기

    static int N; //원소개수
    static int M; // 몇개를 뽑는지
    static ArrayList<int[]> scoreList = new ArrayList<>(); // 점수목록
    static boolean[] chk;
    static ArrayList<Integer> rs = new ArrayList<>();

    public int solution(int[][] ability) {
        M = ability[0].length;
        N = ability.length;

        chk = new boolean[N+1]; // N+1로 하는 이유는 경우의수는 1부터세니까 (1,2,3) 이런조합이라
        recur(0);

        int max = 0;
        for(int[] array: scoreList){
            int target = 0;
            for(int i=0; i<M; i++){
                target += ability[array[i]][i];
            }
            max = Math.max(max,target);
        }

        return max;
    }

    private void recur(int num){
        if(num == M){
            int[] rsint = new int[M];
            for (int i = 0; i < M; i++) {
                rsint[i] = rs.get(i)-1;
                // System.out.println(rs.get(i));
            }
            scoreList.add(rsint);
            return;
        }else{
            for(int i=1; i<N+1; i++){
                if(chk[i] == false){
                    chk[i] = true;
                    rs.add(i);
                    recur(num+1); // 이 코드에서 계속해서 재귀를 돌것임
                    // 재귀에서 돌아온다면
                    rs.remove(rs.size() - 1);
                    chk[i] = false;
                }

            }
        }

    }
}
