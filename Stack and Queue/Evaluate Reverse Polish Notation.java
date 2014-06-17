// Evaluate the value of an arithmetic expression in Reverse Polish Notation.
// Valid operators are +, -, *, /. Each operand may be an integer or another expression.
// Some examples:
//   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
public class Solution {
    public static int evalRPN(String[] tokens) {
        if(tokens.length == 0) return 0;
        if(tokens.length == 1) return Integer.parseInt(tokens[0]);

        Stack<Integer> numbers = new Stack<Integer>();
        int result = 0;
        int tmp;
        
        for(int n = 0; n < tokens.length; n++){
            if(!isOperator(tokens[n])){
                numbers.push(Integer.parseInt(tokens[n]));
            } else {
                if(numbers.size()<2)//This won't help, even if the test input is wrong
                    return Integer.MIN_VALUE;

                if(tokens[n].equals("+")){
                    tmp = numbers.pop();
                    result = numbers.pop() + tmp;
                } else if(tokens[n].equals("-")) {
                    tmp = numbers.pop();
                    result = numbers.pop() - tmp;
                } else if(tokens[n].equals("*")) {
                    tmp = numbers.pop();
                    result = numbers.pop() * tmp;
                } else if(tokens[n].equals("/")) {
                    tmp = numbers.pop();
                    result = numbers.pop() / tmp;
                } else {//This won't help, even if the test input is wrong
                    return Integer.MIN_VALUE;
                }

                numbers.push(result);
            }

        }
        return numbers.pop();
    }

    private static boolean isOperator(String s){
        s.trim();//remove any trailing whitespaces.
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}
