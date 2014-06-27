//Given an array of integers, every element appears twice except for one. Find that single one.
//Note:
//Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
public class Solution {
    //this answer use bit manipulation...
    public int singleNumber(int[] A) {
        int xor = 0;
        
        for(int i=0;i<A.length;i++)
            xor = xor ^ A[i];

        return xor;
    }
}
