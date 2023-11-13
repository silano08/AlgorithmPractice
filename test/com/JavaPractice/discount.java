package com.JavaPractice;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class discount {



    @Test
    public void test(){
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int [] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        int result = 3;
        assertEquals(solution(want,number,discount),result);
    }

    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> wishList = new HashMap<String, Integer>();
        int total = 0;
        int checkZero = 0;

        for(int i=0; i<number.length; i++){
            wishList.put(want[i],number[i]);
            total += number[i];
        }
        checkZero = total;

        for(int i=0; i<discount.length; i++){
            // 현재 탐색중인 키
            String inSearchKey = discount[i];

            // wishList 에 key 값으로 존재하면 빼줌
            if(wishList.containsKey(inSearchKey)){
                wishList.put(inSearchKey,wishList.get(inSearchKey)-1);
                checkZero -= 1;

                // total이 0인지 체크하는 함수
                if(checkZero == 0){
                    if((i-total) > 0){
                        return (i-total);
                    }
                    return 0;
                }
            }

        }

        int answer = 0;
        return answer;
    }

    // 원래 total이 0인지 이걸로 체크했는데 인덱싱용 변수(checkZero)를 따로 만들어서 사용안함
    private boolean checkTotalSumZero(HashMap<String,Integer> map){
        int total =0;
        for (String key: map.keySet()) {
            total += map.get(key);
        }

        if(total == 0){
            return true;
        }

        return false;
    }
}
