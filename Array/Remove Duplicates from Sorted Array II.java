//Follow up for "Remove Duplicates":
//What if duplicates are allowed at most twice?
//For example,
//Given sorted array A = [1,1,1,2,2,3],
//Your function should return length = 5, and A is now [1,1,2,2,3].
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