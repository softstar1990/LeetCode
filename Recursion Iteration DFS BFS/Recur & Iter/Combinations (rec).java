// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
// For example,
// If n = 4 and k = 2, a solution is:
// [
//   [2,4],
//   [3,4],
//   [2,3],
//   [1,2],
//   [1,3],
//   [1,4],
// ]
public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(n == 0 || k == 0) return result;
        
        ArrayList<Integer> item = new ArrayList<Integer>();   
        rec(0,n,k,item,result);
        return result;
    }
    
    public void rec(int low, int n, int k, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> result){
        if(k > n-low) return;
        if(k==0){
            result.add(item);
            return;
        }else{
            ArrayList<Integer> exclude = new ArrayList<Integer>(item);
            rec(low+1, n, k, exclude, result);
            
            ArrayList<Integer> include = new ArrayList<Integer>(item);
            include.add(low+1);
            rec(low+1, n, k-1, include, result);
        }
    }
}
