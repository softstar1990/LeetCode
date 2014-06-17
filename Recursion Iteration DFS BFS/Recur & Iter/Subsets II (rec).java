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
       ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
       ArrayList<Integer> temp = new ArrayList<Integer>();
       Arrays.sort(num);
       result.add(temp);
       rec(result,temp,num,0);
       return result;
    }
    
    public void rec(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, int[] num, int pos){
        for(int i=pos;i<=num.length-1;i++){
            temp.add(num[i]);
            result.add(new ArrayList<Integer>(temp));
            rec(result,temp,num,i+1);
            temp.remove(temp.size()-1);
            while(i<num.length-1 && num[i]==num[i+1]) i++;   //here is the only difference
        }
    }
}
