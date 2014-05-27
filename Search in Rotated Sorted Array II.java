public class Solution {
    public boolean search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = A.length;
        
        // binary search
        int start = 0;
        int end = len - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(target == A[mid])
                return true;
            
            
            if(A[start] < A[mid]){  // lower is sorted
                if(A[start] <= target && target < A[mid])
                    end = mid - 1;
                else{
                    start = mid + 1;
                }
            } else if(A[start] > A[mid]) {  // upper is sorted
               if(A[mid] < target && target <= A[end]){
                    start = mid + 1;
                } else{
                    end = mid - 1;
                }
            } else { //A[start] == A[mid] == A[end]
                start = start + 1; 
            }
        }
        return false;
    }
}
