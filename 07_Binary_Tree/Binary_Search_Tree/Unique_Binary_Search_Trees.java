//Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
//For example,
//Given n = 3, there are a total of 5 unique BST's.
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
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

//another solution without recursion, seems faster, use an array to store the result
public class Solution {
    public int numTrees(int n) {       
        int[] result = new int[n+1];
        result[0] = 1;
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                result[i] += result[j-1] * result[i-j];
            }
        }
        
        return result[n];
    }
}
