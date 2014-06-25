//Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//The replacement must be in-place, do not allocate extra memory.
//Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
//1,2,3 → 1,3,2
//3,2,1 → 1,2,3
//1,1,5 → 1,5,1
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