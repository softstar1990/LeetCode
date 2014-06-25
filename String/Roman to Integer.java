// Given a roman numeral, convert it to an integer.
// Input is guaranteed to be within the range from 1 to 3999.
public class Solution {
    public int romanToInt(String s) {
        int result = 0;
        int current = 0;
        int prev = 0;

        for(int i = s.length() - 1; i >= 0; i--){
            switch (s.charAt(i)){
                case 'M':
                    current = 1000;
                    break;
                case 'D':
                    current = 500;
                    break;
                case 'C':
                    current = 100;
                    break;
                case 'L':
                    current = 50;
                    break;
                case 'X':
                    current = 10;
                    break;
                case 'V':
                    current = 5;
                    break;
                case 'I':
                    current = 1;
                    break;
                default:
                    break;
            }
            if(current >= prev){
                result += current;
                prev = current;
            }else{
                result -= current;
            }
        }
        return result;
    }
}
