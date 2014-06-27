//Given a collection of numbers, return all possible permutations.
//For example,
//[1,2,3] have the following permutations:
//[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
public class Solution {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> item = new ArrayList<Integer>();
 
		rec(result, item, num);
		return result;
	}
 
 
	private void rec(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> item, int[] num) { 
		if (item.size() == num.length) {
			result.add(new ArrayList<Integer>(item));
			return;
		}	
		for (int i = 0; i < num.length; i++) {
			if (item.contains(num[i])) continue;
			
			item.add(num[i]);
			rec(result, item, num);		
			item.remove(item.size() - 1);
		}
	}
}
