//Given a collection of numbers, return all possible permutations.
//For example,
//[1,2,3] have the following permutations:
//[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        
        //for each new number, put it into every posible position in every previous result
        for(int i = 0; i < num.length; i++){
            ArrayList<ArrayList<Integer>> curr = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> arr:result){
                for(int j = 0; j<arr.size()+1; j++){
                    arr.add(j,num[i]);
                    ArrayList<Integer> temp = new ArrayList<Integer>(arr);
                    curr.add(temp);
                    arr.remove(j);
                }
                
            }
            result = curr;
        }
        return result;
    }
}

