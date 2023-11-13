package com.JavaPractice;


import java.util.ArrayList;
import java.util.Collections;

public class failLate {

    class Solution {
        public int[] solution(int N, int[] stages) {

            int pNum = stages.length;
            ArrayList<Integer> denomList = new ArrayList<Integer>();
            ArrayList<Integer> numeList = new ArrayList<Integer>();

            // 1. 실패율 구하기
            int denom = pNum; // 분모는 처음에 array 길이로

            for (int p = 0; p < N; p++) {
                int nume = 0;

                for (int i = 0; i < pNum; i++) {
                    if (stages[i] == (p + 1)) {
                        nume = nume + 1;
                    }
                }


                // 분자
                numeList.add(nume);
                // 분모
                denomList.add(denom);

                // 다음 분모는 이전 분자만큼 줄여주기
                denom = denom - nume;

            }

            // 분모 값 맞춰주기
            for (int i = 0; i < numeList.size(); i++) {
                for (int j = 0; j < denomList.size(); j++) {
                    // 분자에게 분모값 곱해주기
                    if (i != j) {
                        // +) 보완로직 -> 정규화한답시고 곱할때 분모가 0인 케이스를 생각을 못함
                        if (denomList.get(j) == 0) {
                            Integer normalize = numeList.get(i) * 1;
                            numeList.set(i, normalize);
                        } else {
                            Integer normalize = numeList.get(i) * denomList.get(j);
                            numeList.set(i, normalize);
                        }
                    }
                }

            }

            // 2. 실패율 구하고나서
            // 마지막엔 failRate에서 maxValue 찾고
            // Collections.max -> 이걸로 해당값 인덱스 찾고 myList.indexOf -> 해당값 인덱스 0으로 바꿔주고 반복(구버전 풀이)

            // 2(리트). numeList는 정규화된 분자 그룹이 있음.. 이걸로 대소 비교 가능한셈
            int[] failRate = new int[numeList.size()];
            for (int i = 0; i < numeList.size(); i++) {
                int max = Collections.max(numeList);
                for (int j = 0; j < numeList.size(); j++) {
                    if (numeList.get(j) == max && failRate[i] == 0) {
                        failRate[i] = j + 1; // 인덱스로하니까 0 -> 1 레벨인셈
                        numeList.set(j, -1); // 실패율이 0인 경우도 세기 위해서
                    }
                }
            }

            return failRate;

        }
    }
}
