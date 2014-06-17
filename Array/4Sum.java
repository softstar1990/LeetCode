// Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
    	Arrays.sort(num);
     
    	HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
     
    	for (int i = 0; i < num.length; i++) {//first number
    		for (int j = i + 1; j < num.length; j++) {//second number
                //for 1st 2nd number, we use brute force
                //then we use 2 pointers for 3rd and 4th numbers
    			int k = j + 1;
    			int l = num.length - 1;
     
    			while (k < l) {
    				int sum = num[i] + num[j] + num[k] + num[l];
     
    				if (sum > target) {
    					l--;
    				} else if (sum < target) {
    					k++;
    				} else if (sum == target) {
    					ArrayList<Integer> temp = new ArrayList<Integer>();
    					temp.add(num[i]);
    					temp.add(num[j]);
    					temp.add(num[k]);
    					temp.add(num[l]);
     
    					if (!hashSet.contains(temp)) {//unique quadruplets
    						hashSet.add(temp);
    						result.add(temp);
    					}
     
    					k++;
    					l--;
    				}
    			}
    		}
    	}
     
    	return result;
    }
}
