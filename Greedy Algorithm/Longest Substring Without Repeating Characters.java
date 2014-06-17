// Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
public class Solution {
    public int lengthOfLongestSubstring(String s) {
    	boolean[] flag = new boolean[256];
     
    	int result = 0;
    	int j = 0;
    	char[] arr = s.toCharArray();
     
    	for (int i = 0; i < arr.length; i++) {
    		char c = arr[i];
    		if (flag[c]) {
    			result = Math.max(result, i - j);
    			for (int k = j; k < i; k++) {
    				if (arr[k] == c) {
    					j = k + 1;
    					break;
    				}
    				flag[arr[k]] = false;
    			}	
    		} else {
    			flag[c] = true;
    		}
    	}
     
    	result=Math.max(arr.length-j,result);
     
    	return result;
    }
}
