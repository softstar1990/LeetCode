public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(n == 0 || k == 0) return result;
        
        ArrayList<Integer> combine = new ArrayList<Integer>();
        
        generate(0,n,k,combine,result);
        
        return result;
    }
    
    public void generate(int low, int n, int k, ArrayList<Integer> combine, ArrayList<ArrayList<Integer>> result){
        if(k > n-low) return;
        if(k==0){
            //combine.add(low+1);
            result.add(combine);
            return;
        }else{
            ArrayList<Integer> exclude = new ArrayList<Integer>(combine);
            generate(low+1, n, k, exclude, result);
            
            ArrayList<Integer> include = new ArrayList<Integer>(combine);
            include.add(low+1);
            generate(low+1, n, k-1, include, result);
        }
    }
}
