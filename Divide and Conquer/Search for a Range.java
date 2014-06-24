//Given a sorted array of integers, find the starting and ending position of a given target value.
//Your algorithm's runtime complexity must be in the order of O(log n).
//If the target is not found in the array, return [-1, -1].
//For example,
//Given [5, 7, 7, 8, 8, 10] and target value 8,
//return [3, 4].
public class Solution {
    public int[] searchRange(int[] A, int target) {  
        if (A==null) return null;
        int[] result={-1,-1};
        
        int low=binarySearch(A,target-0.5);
        
        if (low>=A.length||A[low]!=target){
            return result;
        }
        
        result[0]=low;
        result[1]=binarySearch(A,target+0.5)-1;
        
        return result;
           
    }
    public int binarySearch(int[] A, double t){
        int low = 0, high = A.length - 1;
        while(low <= high){
            int m = (low + high) / 2;
            if(A[m] == t) return m;
            if(A[m] > t) high = m - 1;
            else low = m + 1;
        }
        return low;
    }
}