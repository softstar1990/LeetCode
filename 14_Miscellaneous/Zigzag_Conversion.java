/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:
string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR". 
*/
public class Solution {
    public String convert(String s, int nRows) {
        if (nRows == 1)
            return s;
        StringBuilder builder = new StringBuilder();
        int step = 2 * nRows - 2;
        for (int i = 0; i < nRows; i++) {
            if (i == 0 || i == nRows - 1) {     //first and last row
                for (int j = i; j < s.length(); j += step) {
                    builder.append(s.charAt(j));
                }
            } else {    //other rows
                int j = i;
                boolean flag = true;
                int step1 = 2 * (nRows - 1 - i);
                int step2 = step - step1;
                while (j < s.length()) {
                    builder.append(s.charAt(j));
                    if (flag)
                        j = j + step1;
                    else
                        j = j + step2;
                    flag = !flag;
                }
            }
        }
        return builder.toString();
    }
}
