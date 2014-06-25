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
       ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
       ArrayList<Integer> item = new ArrayList<Integer>();
       Arrays.sort(S);
       result.add(item);
       rec(result,item,S,0);
       return result;
    }
    
    public void rec(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> item, int[] S, int pos){
        for(int i=pos; i<=S.length-1;i++){
            item.add(S[i]);
            result.add(new ArrayList<Integer>(item));
            rec(result,item,S,i+1);
            item.remove(item.size()-1);
        }
    }
}