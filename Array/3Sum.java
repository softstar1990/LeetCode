//Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
//Find all unique triplets in the array which gives the sum of zero.
//Note:
//Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
//The solution set must not contain duplicate triplets.
//    For example, given array S = {-1 0 1 2 -1 -4},
//    A solution set is:
//    (-1, 0, 1)
//    (-1, -1, 2)
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num.length < 3) return result;
        
        Arrays.sort(num);
        
        for(int i = 0; i<num.length-2; i++){
            if(i==0 || num[i]>num[i-1]){
                int negate = -num[i];
                
                int start = i+1;
                int end = num.length - 1;
                
                while(start<end){
                    if(num[start]+num[end] == negate){
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[start]);
                        temp.add(num[end]);
                        result.add(temp);
                        
                        start++;
                        end--;
                        
                        //make sure no duplicates
                        while(start < end && num[end] == num[end+1]){
                            end--;
                        }
                        while(start < end && num[start] == num[start-1]){
                            start++;
                        }
                    }else if(num[start]+num[end] < negate){
                        start++;
                    }else{
                        end--;
                    }
                }
            }
        }
        return result;
    }
}
