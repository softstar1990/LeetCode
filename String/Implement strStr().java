public class Solution {
    public String strStr(String haystack, String needle) {
        int haystackLen = haystack.length();
        int needleLen = needle.length();

        if(needleLen == 0){
        	return haystack;
        }

        if (haystackLen == needleLen) {
        	if (haystack.equals(needle)) {
        		return haystack;
        	}else{
        		return null;
        	}
        }

        for (int i = 0; i < haystackLen - needleLen + 1 ; i++) {
        	String temp = new String();
        	temp = haystack.substring(i, i+needleLen);
        	if (temp.equals(needle)) return haystack.substring(i);
        }

        return null;
    }
}