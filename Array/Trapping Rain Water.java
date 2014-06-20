// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

public class Solution {
    public int trap(int[] A) {
        if(A.length <= 2) return 0;
        
        int[] maxL = new int[A.length];
        int[] maxR = new int[A.length];
        maxL[0] = A[0];
        maxR[A.length - 1] = A[A.length - 1];
        
        for(int i = 1; i < A.length; i++){
            maxL[i] = Math.max(maxL[i-1], A[i]);
            maxR[A.length -1 - i] = Math.max(maxR[A.length - i], A[A.length - 1 - i]);
        }
        
        int count = 0;
        for(int i = 1; i < A.length - 1; i++){
            count += (Math.min(maxL[i], maxR[i]) - A[i]);
        }
        
        return count;
    }
}