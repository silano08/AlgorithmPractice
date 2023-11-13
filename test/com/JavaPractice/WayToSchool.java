package com.JavaPractice;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class WayToSchool {
    @Test
    public void test() {
        int[][] puddles = {{2, 2}};
        int m = 4;
        int n = 3;
        int result = 4;
        assertEquals(solution(m,n,puddles), result);
    }

    public int solution(int x, int y, int[][] puddles) {
        int mod = 1000000007;

        // 1. 그림과 똑같은 크기의 벡터를 생성 -> 그러나 좌표를 (1,1)부터 세니까 헷갈리지 않게 +1 해줌
        int[][] board = new int[x+1][y+1];

        // 2. 물웅덩이가 있는 곳을 -1로 인덱싱 (2,2) -> 각각 [0,1]니까 puddles를 for문으로 훑으며 할당
        for(int i=0; i<puddles.length; i++){
            board[puddles[i][0]][puddles[i][1]] = -1;
        }

        // 3. 첫 시작은 1로 할당해줌(가짓수니까)
        board[1][1] = 1;
        // 4. y축 훑고 -> x축 한칸 내려가서 -> y축 또 훑고 이런식
        for(int i = 1; i < x + 1; i++) {
            for(int j = 1; j < y + 1; j++) {
                // 4-1. 만약 웅덩이가 아니라면
                if(board[i][j] != -1) {
                    // 목표 경로로 갈때 우 -> 하 니까, 경로를 훑을때 해당 인덱스 기준으로 왼쪽과 위쪽을 더해줌
                    // 4-2. 좌측에서 온 경로의 값을 더하고
                    if(board[i - 1][j] > 0) {
                        board[i][j] += board[i - 1][j] % mod;
                    }
                    // 4-3. 위에서 온 경로의 값을 더하고
                    if(board[i][j - 1] > 0) {
                        board[i][j] += board[i][j - 1] % mod;
                    }
                    
                    // 이렇게되면 비어있는 벡터에 지나온 경로들로 채워지는 셈
                }
            }
        }
        
        // 5. 까지했는데 계속 효율성에서 실패뜨길래 왜지? 하고 다른사람 코드 봤더니 중간중간 mod로 나눠줘야함
        return board[x][y] % mod;
    }
}
