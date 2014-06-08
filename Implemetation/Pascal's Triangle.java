public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> pascal = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i< numRows;i++){
            ArrayList<Integer> row = new ArrayList<Integer>();
            if(i == 0){
                row.add(1);
                pascal.add(row);
            }else{
                for(int j = 0; j <= i; j++){
                    if(j==0 || j==i){
                        row.add(1);
                    }else{
                        int temp = pascal.get(i-1).get(j-1) + pascal.get(i-1).get(j);
                        row.add(temp);
                    }
                }
                pascal.add(row);
            }
        }
        return pascal;
    }
}
