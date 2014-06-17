// The set [1,2,3,…,n] contains a total of n! unique permutations.
// By listing and labeling all of the permutations in order,
// We get the following sequence (ie, for n = 3):
//     1. "123"
//     2. "132"
//     3. "213"
//     4. "231"
//     5. "312"
//     6. "321"
// Given n and k, return the kth permutation sequence.
public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numList = new ArrayList<Integer>();
        int sum = 1;  
        for(int i = 1; i <= n; i++){
            sum *= i;  
            numList.add(i);
        }

        sum /= n;
        k--;
        StringBuffer sb = new StringBuffer();

        for(int i = 1; i <= n; i++){
            int currNum = k / sum;
            sb.append(numList.get(currNum));
            numList.remove(currNum);
            if (i == n) {
                break;
            }
            k %= sum;
            sum /= (n-i);  
        }
        return sb.toString();
    }
}
