/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.
*/
public class Solution {
    public int majorityElement(int[] num) {
        int n = num.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int elem : num) {
            if (map.containsKey(elem)) {
                map.put(elem, map.get(elem)+1);
            }
            else {
                map.put(elem, 1);
            }
        }
        for (int item : map.keySet()) {
            if (map.get(item) > n/2) {
                return item;
            }
        }
        return -1;
    }
}

//another dirty solution...
public class Solution {
    public int majorityElement(int[] num) {
    	if (num.length == 1) {
    		return num[0];
    	}
     
    	Arrays.sort(num);
    	return num[num.length / 2];
    }
}
