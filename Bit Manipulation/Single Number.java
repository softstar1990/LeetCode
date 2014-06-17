// Given an array of integers, every element appears twice except for one. Find that single one.
public class Solution {
    //this answer use bit manipulation...
    public int singleNumber(int[] A) {
        int xor = 0;
        
        for(int i=0;i<A.length;i++)
            xor = xor ^ A[i];

        return xor;
    }
}
