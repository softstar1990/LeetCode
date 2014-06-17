// Given a set of distinct integers, S, return all possible subsets.
// Note:
//   • Elements in a subset must be in non-descending order.
//   • The solution set must not contain duplicate subsets.
// For example,
// If S = [1,2,3], a solution is:
// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
       ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
       ArrayList<Integer> temp = new ArrayList<Integer>();
       Arrays.sort(S);
       result.add(temp);
       rec(result,temp,S,0);
       return result;
    }
    
    public void rec(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, int[] S, int pos){
        for(int i=pos; i<=S.length-1;i++){
            temp.add(S[i]);
            result.add(new ArrayList<Integer>(temp));
            rec(result,temp,S,i+1);
            temp.remove(temp.size()-1);
        }
    }
}