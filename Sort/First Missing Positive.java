public class Solution {
    public int firstMissingPositive(int[] A) {
        if(A==null || A.length==0) return 1;

        for(int i=0;i<A.length;i++){
            if(A[i]<=A.length && A[i]>0 && A[A[i]-1]!=A[i]){
                int temp = A[A[i]-1];
                A[A[i]-1] = A[i];
                A[i] = temp;
                i--;
            }
        }
        
        for(int i=0;i<A.length;i++){
            if(A[i]!=i+1) return i+1;
        }
        
        return A.length+1;
    }
}