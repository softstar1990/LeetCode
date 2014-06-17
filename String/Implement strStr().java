// Implement strStr().
// Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
public class Solution {
    public String strStr(String haystack, String needle) {
        int haystackLen = haystack.length();
        int needleLen = needle.length();

        if(needleLen == 0) return haystack;

        for (int i = 0; i < haystackLen - needleLen + 1 ; i++) {
        	String temp = new String();
        	temp = haystack.substring(i, i+needleLen);
        	if (temp.equals(needle)) return haystack.substring(i);
        }

        return null;
    }
}