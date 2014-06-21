//Implement atoi to convert a string to an integer.
//Hint: Carefully consider all possible input cases. If you want a challenge, 
//please do not see below and ask yourself what are the possible input cases.
//Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
//You are responsible to gather all the input requirements up front.
public class Solution {
    public int atoi(String str) {
    	if (str == null || str.length() < 1) return 0;
     
    	// trim white spaces
        // Returns a copy of the string, with leading and trailing whitespace omitted.
    	str = str.trim();
     
    	char flag = '+';     
    	// check negative or positive
    	int i = 0;
    	if (str.charAt(0) == '-') {
    		flag = '-';
    		i++;
    	} else if (str.charAt(0) == '+') {
    		i++;
    	}

    	// use double to store result
    	double result = 0;     
    	// calculate value
    	while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
    		result = result * 10 + (str.charAt(i) - '0');
    		i++;
    	}     
    	if (flag == '-') result = -result;
     
    	// handle max and min
    	if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;    
    	if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
     
    	return (int) result;
    }
}