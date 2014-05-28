public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if(num.length == 0) return 0;
        if(num.length == 1) return num[0];
        if(num.length == 2) return num[0]+num[1];
        
        int min = Integer.MAX_VALUE;
        int result = 0;
        
        Arrays.sort(num);
        
        for(int i = 0; i<num.length - 2; i++){
            int start = i + 1;
            int end = num.length - 1;
            
            while(start < end){
                int sum = num[i] + num[start] + num[end];
                int diff = Math.abs(sum - target);
                
                if(diff<min){
                    min = diff;
                    result = sum;
                }
                
                if(sum<target){
                    start++;
                }else{
                    end--;
                }
            }
        }
        return result;
    }
}
