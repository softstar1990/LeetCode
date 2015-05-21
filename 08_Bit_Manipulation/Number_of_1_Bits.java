/*
Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, 
so the function should return 3.
*/
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for(int i=1; i<33; i++){
            if(getBit(n, i) == true){
                count++;
            }
        }
        return count;
    }
     
    public boolean getBit(int n, int i){
        return (n & (1 << i)) != 0;
    }
}

//another solution
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
      int total_ones = 0;
      while (n != 0) {
        n = n & (n-1);
        total_ones++;
      }
      return total_ones;
    }
}
