// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

public class Solution {
    public int trap(int[] A) {
        if(A.length <= 2) return 0;
        
        int[] maxL = new int[A.length];
        int[] maxR = new int[A.length];
        maxL[0] = A[0];
        maxR[A.length - 1] = A[A.length - 1];
        
        for(int i = 1; i < A.length; i++){
            if(A[i]>maxL[i-1]){
                maxL[i] = A[i];
            }else{
                maxL[i] = maxL[i-1];
            }
            
            if(A[A.length - 1 - i] > maxR[A.length - i]){
                maxR[A.length -i - 1] = A[A.length - i - 1]; 
            }else{
                maxR[A.length -i - 1] = maxR[A.length - i];
            }
        }
        
        int result = 0;
        for(int i = 0; i<A.length; i++){
            result += ( Math.min(maxL[i], maxR[i]) - A[i] );
        }
        
        return result;
    }
}
