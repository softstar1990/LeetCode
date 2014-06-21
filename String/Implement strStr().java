//Implement strStr().
//Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
public class Solution {
    public String strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();

        for( int i = 0; i + len2 - 1 < len1; i++){
            if(haystack.substring(i, i+len2).equals(needle)) return haystack.substring(i);
        }
        
        return null;
    }
}