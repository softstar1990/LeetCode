public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(n == 0 || k == 0) return result;
        
        ArrayList<Integer> combine = new ArrayList<Integer>();
        
        rec(0,n,k,combine,result);
        
        return result;
    }
    
    public void rec(int low, int n, int k, ArrayList<Integer> combine, ArrayList<ArrayList<Integer>> result){
        if(k > n-low) return;
        if(k==0){
            result.add(combine);
            return;
        }else{
            ArrayList<Integer> exclude = new ArrayList<Integer>(combine);
            rec(low+1, n, k, exclude, result);
            
            ArrayList<Integer> include = new ArrayList<Integer>(combine);
            include.add(low+1);
            rec(low+1, n, k-1, include, result);
        }
    }
}
