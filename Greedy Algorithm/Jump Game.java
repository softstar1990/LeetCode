public class Solution {
    public boolean canJump(int[] A) {
        if(A.length == 0) return false;
        
        int reach = 1;
        for(int i = 0; i < reach && reach < A.length; i++){
            reach = Math.max(reach, i+1+A[i]);
        }
        return reach >= A.length; 
    }
}