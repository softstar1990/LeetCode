public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        HashSet<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
        if(candidates.length == 0)  return new ArrayList<ArrayList<Integer>>();
        
        int n = candidates.length;
        
        Arrays.sort(candidates);
        
        ArrayList<Integer> combine = new ArrayList<Integer>();
        generate(0,n,target,candidates,combine,result);
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for(ArrayList<Integer> row : result){
            list.add(row);
        }
        return list;
    }
    
    public void generate(int curr, int n, int target, int[] candidates, ArrayList<Integer> combine, HashSet<ArrayList<Integer>> result){
        if(curr<n){
            if(target < candidates[curr]){
                return;
            }else if(target == candidates[curr]){
                combine.add(candidates[curr]);
                if(!result.contains(combine)) result.add(combine);
                return;
            }else{
                ArrayList<Integer> exclude = new ArrayList<Integer>(combine);
                generate(curr+1,n,target,candidates,exclude,result);
                
                ArrayList<Integer> include = new ArrayList<Integer>(combine);
                include.add(candidates[curr]);
                generate(curr+1,n,target-candidates[curr],candidates,include,result);
            }
        }else{
            return;
        }
    }
}
