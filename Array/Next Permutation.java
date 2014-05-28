public class Solution {
    public void nextPermutation(int[] num) {
        if(num.length <= 1) return;
        
        for(int i = num.length-2; i>=0; i--){
            for(int j = num.length-1; j>i; j--){
                if(num[j]>num[i]){
                    int temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                    
                    Arrays.sort(num,i+1,num.length);

                    return;
                }
            }
        }
        
        Arrays.sort(num);
        return;
    }
}