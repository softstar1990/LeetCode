public class Solution {
    public int search(int[] A, int target) {
 		if(A.length == 0) return -1;

 		int start = 0, end = A.length - 1;

 		while(start <= end){
 			int mid = (start + end);
 			if(A[mid] == target) return mid;

 			if(A[mid] >= A[start]){	//left part is sorted
 				if(A[start] <= target && target < A[mid]){
 					end = mid-1;
 				}else{
 					start = mid+1;
 				}
 			}else{
 				if(A[mid] < target && target <= A[end]){
 					start = mid+1;
 				}else{
 					end = mid-1;
 				}
 			}
 		}

 		return -1;       
    }
}