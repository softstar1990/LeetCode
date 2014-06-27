//Given numRows, generate the first numRows of Pascal's triangle.
//For example, given numRows = 5,
//Return
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//]
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
