// Given an absolute path for a file (Unix-style), simplify it.
// For example,
// path = "/home/", => "/home"
// path = "/a/./b/../../c/", => "/c"
// click to show corner cases.
// Corner Cases:
// • Did you consider the case where path = "/../"?
// In this case, you should return "/".
// • Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
// In this case, you should ignore redundant slashes and return "/home/foo".
public class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (String s : paths) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (s.length() > 0 && !s.equals(".")) {
                stack.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/" + s);
        }
        if (sb.length() == 0) sb.append("/");
        
        return sb.toString();
    }
}