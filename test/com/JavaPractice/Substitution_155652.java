package com.JavaPractice;

import java.util.HashSet;

public class Substitution_155652 {
    // https://school.programmers.co.kr/learn/courses/30/lessons/155652#


    public String solution(String s, String skip, int index) {
        // 아이디어 : skip set을 만들고 , s를 탐색하는데 만약 skip set에 포함된거면 다음칸으로 넘김
        // 시간복잡도 s를 탐색하는동안 s의 길이 * index 일테니 최대 50*20 이니 괜찮을듯
        String answer = "";

        HashSet<Character> fset = new HashSet<>();
        for(int i=0; i<skip.length(); i++){
            fset.add(skip.charAt(i));
        }

        for(int j=0; j<s.length(); j++){
            char a = s.charAt(j);
            for(int k=0; k<index; k++){
                // 두가지 검사 -> 범위내의 값인지, 금지된 값인지(금지된값이라면 +1 한번 더)
                if(a+1-122 >= 1){
                    a = (char)(97+a+1-122-1);
                }else{
                    a += 1;
                }

                // 이렇게짜면 금지리스트끼리 연달아있는데 다음값으로 넘길수도있으니
//                if(fset.contains(a)){
//                    if(a == 122){
//                        a = 97;
//                    }else{
//                        a += 1;
//                    }
//                }

                for (char f : fset) {
                    if(fset.contains(a)){
                        if(a == 122){
                            a = 97;
                        }else{
                            a += 1;
                        }
                    }else{
                        break;
                    }
                }
            }

            answer += a;
        }

        return answer;
    }
}
