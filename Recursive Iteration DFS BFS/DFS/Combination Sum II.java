public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
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
            if(i>start && candidates[i]==candidates[i-1]){ 
                continue;
            }
            item.add(candidates[i]);
            dfs(candidates,i+1,target-candidates[i],item,result);
            item.remove(item.size()-1);
        }
    }
}