public class Solution {  
    public int canCompleteCircuit(int[] gas, int[] cost) {  
        // Note: The Solution object is instantiated only once and is reused by each test case.  
        int sum = 0, total = 0, len = gas.length, index = -1;  
        for(int i=0; i<len; i++){  
            sum += gas[i]-cost[i];  
            total += gas[i]-cost[i];  
            if(sum < 0){  
                index = i;  
                sum = 0;  
            }  
        }  
        return total>=0 ? index+1 : -1;  
    }  
}  
