package com.JavaPractice;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void test(){
        String [] phone_book = {"23","24","235"};
        boolean returnAnswer = solution(phone_book);
        assert !returnAnswer;
    }


    // 효율성 테스트에서 실패~!
    // 아.. 정확성도 틀렸길래 왜지 했는데 접두사였네 고쳤음
    public boolean solution1(String[] phone_book) {
        boolean answer = true;

        for(int i=0; i<phone_book.length; i++){
            for (String pN :phone_book) {
                if (phone_book[i].startsWith(pN) && !phone_book[i].equals(pN)){
                    answer = false;
                }
            }
        }
        return answer;
    }

    // 2트. for문 한번만 돌아야 효율성 통과가능할듯
    // sort해서 앞자리 뒤에거랑 똑같은지 비교 ㄱㄱ
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        // 23 24 235 ? 23 235 24
        // lexicographical sort가 보장되는가?(사전식 정렬)
        Arrays.sort(phone_book); // sort하면 앞자리 같은애들끼리 정렬됨

        for(int i=0; i<phone_book.length; i++){
            if(i == phone_book.length -1){
                break;
            }

            if(phone_book[i+1].startsWith(phone_book[i])){
                answer = false;
                break;
            }
        }

        return answer;
    }

}