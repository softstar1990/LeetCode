public class Solution {
    public int romanToInt(String s) {
        int result = 0;
        int current = 0;
        int prev = 0;
        char[] chars = s.toCharArray();
        
        for(int i = (chars.length - 1) ; i >= 0; i--){
            switch (chars[i]){
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
