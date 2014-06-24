//Given two sorted integer arrays A and B, merge B into A as one sorted array.
//Note:
//You may assume that A has enough space (size that is greater or equal to m + n) to hold 
//additional elements from B. The number of elements initialized in A and B are m and n respectively.
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        if(n==0) return;
        if(m==0){
            for(int i = 0;i<n;i++){
                A[i]=B[i];
            }    
            return;
        }
        
        int a = m-1, b = n-1;
        for(int iter = m+n-1; iter>=0; iter--){
            if(a < 0){
                A[iter] = B[b--];
            }else if(b < 0){
                A[iter] = A[a--];
            }else{
                if(A[a]>=B[b]){
                    A[iter] = A[a--];
                }else{
                    A[iter] = B[b--];
                }
            }
        }
    }
}