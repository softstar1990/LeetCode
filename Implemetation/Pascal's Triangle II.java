// Given an index k, return the kth row of the Pascal's triangle.
// For example, given k = 3,
// Return [1,3,3,1].
// Note:
// Could you optimize your algorithm to use only O(k) extra space?
public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(1);
        if(rowIndex == 0) return result;
        result.add(1);
        if(rowIndex == 1) return result;
        
        for(int k = 2; k<=rowIndex; k++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            for(int i = 1; i<k; i++){
                int c = result.get(i-1) + result.get(i);
                temp.add(c);
            }
            temp.add(1);
            result = temp;
        }
        return result;
    }
}
