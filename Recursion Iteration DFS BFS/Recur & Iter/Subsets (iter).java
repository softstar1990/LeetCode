//Given a set of distinct integers, S, return all possible subsets.
//Note:
//Elements in a subset must be in non-descending order.
//The solution set must not contain duplicate subsets.
//For example,
//If S = [1,2,3], a solution is:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        if (S == null) return null;
     
        Arrays.sort(S);
     
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        //add empty set
        result.add(new ArrayList<Integer>());
         
        for (int i = 0; i < S.length; i++) {
            ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
     
            //get sets that are already in result
            for (ArrayList<Integer> a : result) {
                temp.add(new ArrayList<Integer>(a));
            }
     
            //add S[i] to existing sets
            for (ArrayList<Integer> a : temp) {
                a.add(S[i]);
            }
     
            result.addAll(temp);
        }
     

        return result;
    }
}