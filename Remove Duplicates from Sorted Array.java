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