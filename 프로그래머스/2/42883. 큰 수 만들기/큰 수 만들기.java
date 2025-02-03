import java.util.*;
import java.lang.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < number.length(); i++) {
            char digit = number.charAt(i);
            while (k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) < digit) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(digit);
        }
        
        if (k > 0) {
            sb.setLength(sb.length() - k);
        }
        
        return sb.toString();
    }
}