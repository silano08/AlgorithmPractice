package com.JavaPractice;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class test1 {

    @Test
    public void test() {
//        int [] info = {2,1,1,1,0,0,0,0,0,0,0};
//        int[] result = {0,2,2,0,1,0,0,0,0,0,0};
//        int n = 5;
//        assertEquals(solution(n,info),result);

        // 스택 생성
        Stack<Integer> stack = new Stack<>();

// 원소 추가 (push)
        stack.push(1);
        stack.push(2);
        stack.push(3);

// 스택의 상태 출력
        System.out.println("Stack: " + stack);

// 스택에서 원소 제거 (pop)
        int removedElement = stack.pop();
        System.out.println("Popped element: " + removedElement);
        System.out.println("Stack after popping: " + stack);

// 스택의 맨 위 원소 조회 (peek)
        int topElement = stack.peek();
        System.out.println("Top element: " + topElement);

// 스택이 비어있는지 확인 (empty)
        boolean isEmpty = stack.empty();
        System.out.println("Is the stack empty? " + isEmpty);

// 스택의 크기 확인 (size)
        int size = stack.size();
        System.out.println("Stack size: " + size);
    }

    static int[] res = {-1};
    static int[] lion;
    static int max = -1000;

    public void dfs(int[] info, int cnt, int n) {
        if (cnt == n + 1) {
            int apeach_point = 0;
            int lion_point = 0;
            for (int i = 0; i <= 10; i++) {
                if (info[i] != 0 || lion[i] != 0) {
                    if (info[i] < lion[i])
                        lion_point += 10 - i;
                    else
                        apeach_point += 10 - i;
                }
            }
            if (lion_point > apeach_point) {
                if (lion_point - apeach_point >= max) {
                    res = lion.clone();
                    max = lion_point - apeach_point;
                }
            }
            return;
        }
        for (int j = 0; j <= 10 && lion[j] <= info[j]; j++) {
            lion[j]++;
            dfs(info, cnt + 1, n);
            lion[j]--;
        }
    }

    public int[] solution(int n, int[] info) {
        lion = new int[11];
        dfs(info, 1, n);
        return res;
    }
}
