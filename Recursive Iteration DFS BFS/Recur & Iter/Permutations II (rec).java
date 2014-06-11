public class Solution {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		boolean[] visited = new boolean[num.length];
 
		rec(result, list, num, visited);
 
		return result;
	}
 
 
	private void rec(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] num, boolean[] visited) { 
		if (list.size() == num.length) {
			result.add(new ArrayList<Integer>(list));
			return;
		}
 
		for (int i=0; i<num.length; i++) {
			// if number1 equals number2, defaultly, we get the number1, abort number2, so  
 			// number2 can't be used if the number1 haven't be used.
			if (visited[i]==true || (i!=0 && num[i] == num[i-1] && visited[i-1] == false)) {
				continue;
			}
 
			visited[i] = true;
			list.add(num[i]);
			rec(result, list, num, visited);
			list.remove(list.size() - 1);
			visited[i] = false;
		} 
	}
}