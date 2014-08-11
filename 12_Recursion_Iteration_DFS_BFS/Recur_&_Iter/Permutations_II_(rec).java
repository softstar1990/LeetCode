//Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//For example,
//[1,1,2] have the following unique permutations:
//[1,1,2], [1,2,1], and [2,1,1].
public class Solution {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> item = new ArrayList<Integer>();
		boolean[] visited = new boolean[num.length];
 
		rec(result, item, num, visited); 
		return result;
	}
 
 	private void rec(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> item, int[] num, boolean[] visited) { 
		if (item.size() == num.length) {
			result.add(new ArrayList<Integer>(item));
			return;
		}
 
		for (int i=0; i<num.length; i++) {
			// if number1 equals number2, defaultly, we get the number1, abort number2, so  
 			// number2 can't be used if the number1 haven't be used.
			if (visited[i]==true || (i!=0 && num[i] == num[i-1] && visited[i-1] == false)) {
				continue;
			}
			visited[i] = true;
			item.add(num[i]);
			rec(result, item, num, visited);
			item.remove(item.size() - 1);
			visited[i] = false;
		} 
	}
}