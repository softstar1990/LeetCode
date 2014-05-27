public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
    	Arrays.sort(num);
     
    	HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
     
    	for (int i = 0; i < num.length; i++) {第一个数
    		for (int j = i + 1; j < num.length; j++) {第二个数
    			int k = j + 1;第三个数
    			int l = num.length - 1;第四个数
     
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
     
    					if (!hashSet.contains(temp)) {保证没有重复
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
