package com.JavaPractice.kakao;

import java.util.Stack;

public class kakalv1_64061 {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board.length;
        Stack<Integer> boxQ = new Stack<>();

        for (int m : moves) {
            int col = m - 1; // 크레인의 위치

            // 해당 열에서 가장 위에 있는 인형 찾기
            for (int i = 0; i < n; i++) {
                int doll = board[i][col];
                if (doll != 0) {
                    if (!boxQ.isEmpty() && boxQ.peek() == doll) {
                        // 바구니 맨 위의 인형과 같은 모양이면 터뜨리고 인형 개수 증가
                        boxQ.pop();
                        answer += 2;
                    } else {
                        // 다른 모양의 인형이면 바구니에 넣기
                        boxQ.push(doll);
                    }
                    // 인형을 집어 온 후 해당 칸은 비어있도록 설정
                    board[i][col] = 0;
                    break;
                }
            }
        }

        return answer;
    }
}
