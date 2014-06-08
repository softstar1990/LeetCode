public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle.size() == 0) return 0;
        if(triangle.size() == 1) return triangle.get(0).get(0);
        
        int[] result = new int[triangle.size()];
        result[0] = triangle.get(0).get(0);
        
        for(int i = 1; i < triangle.size(); i++){
            int[] temp = new int[triangle.size()];
            temp[0] = result[0] + triangle.get(i).get(0);
            temp[i] = result[i-1] + triangle.get(i).get(i);
            
            for(int j = 1; j < i; j++){
                temp[j] = Math.min(result[j-1], result[j]) + triangle.get(i).get(j);
            }
            
            for(int j = 0; j <= i; j++){
                result[j] = temp[j];
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < result.length; i++){
            if(result[i] < min) min = result[i]; 
        }
        return min;
    }
}

