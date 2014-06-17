// You are climbing a stair case. It takes n steps to reach to the top.
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
public class Solution {
    public int climbStairs(int n) {
        int[] nums = new int[n+1];
        
        if(n == 0) return 1;
        if(n == 1) return 1;
        
        nums[0] = 1;
        nums[1] = 1;
        
        for(int i = 2; i < n+1; i++){
            nums[i] = nums[i-1]+nums[i-2];
        }
        
        return nums[n];
    }
}
