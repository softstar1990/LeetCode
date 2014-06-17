// There are N children standing in a line. Each child is assigned a rating value.
// You are giving candies to these children subjected to the following requirements:
//     • Each child must have at least one candy.
//     • Children with a higher rating get more candies than their neighbors.
// What is the minimum candies you must give?
public class Solution {
    public int candy(int[] ratings) {
        if(ratings==null || ratings.length==0) return 0;

        int[] nums = new int[ratings.length];
        nums[0]=1;
        
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                nums[i] = nums[i-1]+1;
            }else{
                nums[i] = 1;
            }
        }
        
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                nums[i] = Math.max(nums[i+1]+1, nums[i]);
            }
        }
        
        int result = 0;
        for(int i = 0; i < ratings.length; i++){
            result += nums[i];
        }
        return result;
    }
}