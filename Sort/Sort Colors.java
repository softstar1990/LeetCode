public class Solution {
    public void sortColors(int[] A) {
        int i=-1, j=-1, k=-1;

        for(int p = 0; p < A.length; p++){
            if(A[p] == 0){
                A[++k]=2;
                A[++j]=1;
                A[++i]=0;
            } else if (A[p] == 1) {
                A[++k]=2;
                A[++j]=1;
            } else if (A[p] == 2) {
                A[++k]=2;
            }
        }      
    }
}
