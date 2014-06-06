public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        if(n==0) return;
        if(m==0){
            for(int i = 0;i<n;i++){
                A[i]=B[i];
            }    
            return;
        }
        
        int a = m-1, b = n-1, k = m+n-1;
        for(int iter = k; iter>=0; iter--){
            if(a < 0){
                A[iter] = B[b];
                b--;
            }else if(b < 0){
                A[iter] = A[a];
                a--;
            }else{
                if(A[a]>=B[b]){
                    A[iter] = A[a];
                    a--;
                }else{
                    A[iter] = B[b];
                    b--;
                }
            }
        }
    }
}