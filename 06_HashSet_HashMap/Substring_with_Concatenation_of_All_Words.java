/*
You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter). 
*/
public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashMap<String, Integer> toFind = new HashMap<String, Integer>();
        HashMap<String, Integer> found = new HashMap<String, Integer>();
        int m = L.length, n = L[0].length();
        //set up the dictionary
        for (int i = 0; i < m; i ++){
            if (!toFind.containsKey(L[i])){
                toFind.put(L[i], 1);
            }
            else{
                toFind.put(L[i], toFind.get(L[i]) + 1);
            }
        }
        //search in the string
        for (int i = 0; i <= S.length() - n * m; i ++){
            found.clear();
            int j;
            for (j = 0; j < m; j ++){
                int k = i + j * n;
                String stub = S.substring(k, k + n);
                if (!toFind.containsKey(stub)) break;   //the substring is not in the dictionary
                if(!found.containsKey(stub)){
                    found.put(stub, 1);
                }
                else{
                    found.put(stub, found.get(stub) + 1);
                }
                if (found.get(stub) > toFind.get(stub)) break;  //the substring appears to many times
            }
            if (j == m) result.add(i);
        }
        return result;
    }
}
