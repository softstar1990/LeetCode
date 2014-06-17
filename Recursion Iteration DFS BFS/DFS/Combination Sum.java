// Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
// The same repeated number may be chosen from C unlimited number of times.
// Note:
//     • All numbers (including target) will be positive integers.
//     • Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
//     • The solution set must not contain duplicate combinations.
// For example, given candidate set 2,3,6,7 and target 7, 
// A solution set is: 
// [7] 
// [2, 2, 3] 
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(candidates == null || candidates.length==0) return result;

        Arrays.sort(candidates);

        dfs(candidates,0,target,new ArrayList<Integer>(),result);
        return result;
    }

    private void dfs(int[] candidates, int start, int target, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> result){
        if(target<0){
            return;
        }else if(target == 0){
            result.add(new ArrayList<Integer>(item));
            return;
        }

        for(int i=start;i<candidates.length;i++){
            if(i>0 && candidates[i]==candidates[i-1]){
                continue;
            }
            item.add(candidates[i]);
            dfs(candidates,i,target-candidates[i],item,result);
            item.remove(item.size()-1);
        }
    }
}