//Follow up for "Search in Rotated Sorted Array":
//What if duplicates are allowed?
//Would this affect the run-time complexity? How and why?
//Write a function to determine if a given target is in the array.
public class Solution {
    public boolean search(int[] A, int target) {
        // binary search
        int start = 0;
        int end = A.length - 1;

        while(start <= end){
            int mid = (start + end) / 2;
            if(target == A[mid]) return true;           
            
            if(A[start] < A[mid]){  // left is sorted
                if(A[start] <= target && target < A[mid]){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if(A[start] > A[mid]) {  // right is sorted
               if(A[mid] < target && target <= A[end]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else { //A[start] == A[mid]
                start = start + 1; 
            }
        }
        return false;
    }
}
