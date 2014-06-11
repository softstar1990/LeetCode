public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numList = new ArrayList<Integer>();
        numList.add(1);
        int sum = 1;  
        for(int i = 2; i <= n; i++){
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
