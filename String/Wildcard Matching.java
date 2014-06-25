//Implement wildcard pattern matching with support for '?' and '*'.
//'?' Matches any single character.
//'*' Matches any sequence of characters (including the empty sequence).
//The matching should cover the entire input string (not partial).
//The function prototype should be:
//bool isMatch(const char *s, const char *p)
//Some examples:
//isMatch("aa","a") → false
//isMatch("aa","aa") → true
//isMatch("aaa","aa") → false
//isMatch("aa", "*") → true
//isMatch("aa", "a*") → true
//isMatch("ab", "?*") → true
//isMatch("aab", "c*a*b") → false
public class Solution {
	public boolean isMatch(String s, String p) {
		int i = 0;	//i is point to s
		int j = 0;	//j is point to p
		int star = -1;
		int mark = -1;
		while (i < s.length()) {
			// if what i point to match what j point to
			if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
				++i;
				++j;
			}
			// j point to a *
			else if (j < p.length() && p.charAt(j) == '*') {
				star = j;	// star point to last *
				j++;	// move j to next char in p
				mark = i; // mark is the last char in s that need to check whether should be in *
				// notice that we do not update i here, since * may match an empty part, 
				// that is: what i point to match the char after * 
			} 
			// char not match and j not point to *, but star!=1 means we have a * before
			else if (star != -1) {
				j = star + 1;	// j still point to the char after last * in p, sometime j may go back a lot
				mark++;	// 
				i = mark;	
			} 
			// none of above, return false
			else {
				return false;
			}
		}
		// if p is end by some *
		while (j < p.length() && p.charAt(j) == '*') {
			++j;
		}
		// s should consume everything in partten p
		return j == p.length();
	}
}