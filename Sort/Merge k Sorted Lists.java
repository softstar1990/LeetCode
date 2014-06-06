/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists.size()==0) return null;
        
        //remove null list in lists
        ArrayList<ListNode> lists2 = new ArrayList<ListNode>();
        for(ListNode list:lists){
            if(list != null) lists2.add(list);
        }
        
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        
        while(!lists2.isEmpty()){
            int min = Integer.MAX_VALUE;
            int index = 0;
            for(int i = 0; i < lists2.size(); i++){
                if(lists2.get(i) != null && lists2.get(i).val < min){
                    min = lists2.get(i).val;
                    index = i;
                }
            }
            head.next = new ListNode(min);
            head = head.next;
            
            if(lists2.get(index).next != null){
                ListNode temp = lists2.get(index).next;
                lists2.set(index, temp);
            }else{
                lists2.remove(index);
            }
        }
        return dummy.next;
    }
    
}
