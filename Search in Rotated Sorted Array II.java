public class Solution {
    public boolean search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = A.length;
        
        // binary search
        int l = 0;
        int r = len - 1;
        while(l <= r){
            int m = (l + r) / 2;
            if(target == A[m])
                return true;
            
            // lower is sorted
            if(A[l] < A[m]){
                if(A[l] <= target && target < A[m])
                    r = m - 1;
                else{
                    l = m + 1;
                }
            } else if(A[l] > A[m]) {
                // upper is sorted
                if(A[m] < target && target <= A[r]){
                    l = m + 1;
                } else{
                    r = m - 1;
                }
            } else {
                l = l + 1;
            }
        }
        return false;
    }
}
