public class Solution {
    public void sortColors(int[] A) {
        // another solution using two pointers
        if(A.length==0)return;
        int red = 0, blue = A.length-1, i = 0;    

        while(i <= blue){
            if(A[i] == 0){
                swap(A,i++,red++);
            }else if (A[i] == 2){
                swap(A,i,blue--);  //notice cannot add i at this time since A[blue] may be 0
            }else{
                i++;
            }
        }
    }
    
    public void swap(int[] num, int a, int b){
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }
}