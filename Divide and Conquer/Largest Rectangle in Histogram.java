// i think this solution actually is correct. it use divide and conquer.
// however the time complexity is worse than the solution used stack.
// but this solution is easy to understand
public class Solution {
    public int largestRectangleArea(int[] height) {
        if(height.length == 0) return 0;
        return dq(height, 0, height.length-1);
    }
    
    public int dq(int[] height, int start, int end){
        if(start > end) return 0;
        if(start == end) return height[start];
        
        int i = start, index = start, min = Integer.MAX_VALUE;
        while(i <= end){
            if(height[i] < min){
                index = i;
                min = height[i];
            }
            i++;
        }
        
        int h = min * (end - start + 1);
        int hl = dq(height, start, index-1);
        int hr = dq(height, index+1, end);
        
        int result = Math.max(h, Math.max(hl, hr));
        return result;
    }
}