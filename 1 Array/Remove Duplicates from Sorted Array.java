//Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
//Do not allocate extra space for another array, you must do this in place with constant memory.
//For example,
//Given input array A = [1,1,2],
//Your function should return length = 2, and A is now [1,2].
public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length < 2) return A.length;

        int i = 0, j = 0;

        while(j < A.length){
        	if(A[i]==A[j]){
        		j++;
        	} else {
        		i++;
        		A[i] = A[j];
        		j++;
        	}
        }

        return i+1;
    }
}