public class Solution {
    public int numTrees(int n) {       
       if(n==0) return 1;
       
       int uniq = 0;
       for(int i = 1; i <= n; i++){
           uniq += numTrees(i-1) * numTrees(n-i);
       }
       
       return uniq;
    }
}
