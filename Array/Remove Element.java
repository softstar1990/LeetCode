//Given an array and a value, remove all instances of that value in place and return the new length.
//The order of elements can be changed. It doesn't matter what you leave beyond the new length.
public class Solution {
    public int removeElement(int[] A, int elem) {
        int i=0, j=0;
        while(j<A.length){
            if(A[j]!=elem){
                A[i]=A[j];
                i++; 
            }
            j++;
        }
        return i;
    }
}