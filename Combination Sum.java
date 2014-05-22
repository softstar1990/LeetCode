public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(candidates.length == 0)  return result;
        
        int n = candidates.length;
        
        Arrays.sort(candidates);
        
        ArrayList<Integer> combine = new ArrayList<Integer>();
        generate(0,n,target,candidates,combine,result);
        
        return result;
    }
    
    public void generate(int curr, int n, int target, int[] candidates, ArrayList<Integer> combine, ArrayList<ArrayList<Integer>> result){
        if(curr<n){
            if(target < candidates[curr]){
                return;
            }else if(target == candidates[curr]){
                combine.add(candidates[curr]);
                result.add(combine);
                return;
            }else{
                ArrayList<Integer> exclude = new ArrayList<Integer>(combine);
                generate(curr+1,n,target,candidates,exclude,result);
                
                ArrayList<Integer> include = new ArrayList<Integer>(combine);
                include.add(candidates[curr]);
                generate(curr,n,target-candidates[curr],candidates,include,result);
            }
        }else{
            return;
        }
    }
}
