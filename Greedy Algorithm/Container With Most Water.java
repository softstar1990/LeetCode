//Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
//n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
//Find two lines, which together with x-axis forms a container, such that the container contains the most water.
Note: You may not slant the container.
public class Solution {
    public int maxArea(int[] height) {
        int len = height.length, left = 0, right = len -1 ;  
        int maxArea = 0; 

        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, area);
            
            if (height[left] < height[right]) {  
                left++;  
            } else {  
                right--;  
            }
       }  
       return maxArea; 
    }
}
