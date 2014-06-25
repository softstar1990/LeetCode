//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//Each element in the array represents your maximum jump length at that position.
//Your goal is to reach the last index in the minimum number of jumps.
//For example:
//Given array A = [2,3,1,1,4]
//The minimum number of jumps to reach the last index is 2. 
//(Jump 1 step from index 0 to 1, then 3 steps to the last index.)
public class Solution {
    public int jump(int[] A) {
        if(A==null||A.length==0||A.length==1) return 0;
        
        int start = 0;
        int end   = 0;
        int jump_times = 0;
        int reach  = 0;  
        while(end<A.length) {
            reach = 0;
            jump_times++;
            //find the max index we can jump to from current closure
            for(int i=start;i<=end;i++) {
                if((A[i]+i)>=(A.length-1)) return jump_times;               
                if((A[i]+i)>reach) reach = A[i]+i;
            }
            //update next closure
            start = end + 1;
            end   = reach;
        }
        return jump_times;
    }
}