// Given a collection of integers that might contain duplicates, S, return all possible subsets.
// Note:
//     • Elements in a subset must be in non-descending order.
//     • The solution set must not contain duplicate subsets.
// For example,
// If S = [1,2,2], a solution is:
// [
//   [2],
//   [1],
//   [1,2,2],
//   [2,2],
//   [1,2],
//   []
// ]
public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        if (num == null) return null;
     
        Arrays.sort(num);
     
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();
        //add empty set
        result.add(new ArrayList<Integer>());
          
        for (int i = 0; i < num.length; i++) {
            //get existing sets
            if (i == 0 || num[i] != num[i - 1]) {
                prev = new ArrayList<ArrayList<Integer>>();
                for (int j = 0; j < result.size(); j++) {
                    prev.add(new ArrayList<Integer>(result.get(j)));
                }
            }
     
            //add current number to each element of the set
            for (ArrayList<Integer> temp : prev) {
                temp.add(num[i]);
            }
     
            //add all set created in this iteration
            for (ArrayList<Integer> temp : prev) {
                result.add(new ArrayList<Integer>(temp));
            }
        }
        return result;
    }
}
