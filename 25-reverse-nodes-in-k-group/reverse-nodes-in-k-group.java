/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    ListNode selentialNode = new ListNode();
    ListNode dup = selentialNode;

    public void swapNode(List<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            ListNode newNode = new ListNode(list.get(i));
            dup.next = newNode;
            dup = dup.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            if (list.size() == k) {
                swapNode(list);
                list.clear() ;
            }
            curr = curr.next ;
        }
        for( int i = 0 ; i < list.size() ; i++ ) {
            ListNode newNode = new ListNode(list.get(i));
            dup.next = newNode;
            dup = dup.next;
        }
        return selentialNode.next ;
    }
}