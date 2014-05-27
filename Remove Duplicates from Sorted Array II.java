public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length < 3) return A.length;
        int prev = 1;
        int curr = 2;

        while(curr < A.length){
        	if(A[curr]==A[prev] && A[prev]==A[prev-1]){
        		curr++;
        	} else {
        		prev++;
        		A[prev] = A[curr];
        		curr++;
        	}
        }
        return prev+1;
    }
}