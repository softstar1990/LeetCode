public class Solution {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length-1; i >= 0 ; i--){
            int d = digits[i] + 1;
            if(d<10){
                digits[i] = d;
                break;
            }else{
                digits[i]=0;
            }
        }
        
        if(digits[0] != 0){
            return digits;
        }else{
            int[] temp = new int[digits.length+1];
            temp[0] = 1;
            for(int i = 0; i<digits.length; i++){
                temp[i+1] = digits[i];
            }
            return temp;
        }
    }
}
