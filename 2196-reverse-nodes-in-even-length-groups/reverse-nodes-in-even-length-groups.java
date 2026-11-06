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
    ListNode selentialNode = new ListNode() ;
    ListNode dup = selentialNode ;
    public void evenNode( List<Integer> list ) {
        for( int i = list.size() - 1 ; i >= 0 ; i-- ) {
            ListNode newNode = new ListNode( list.get(i) ) ;
            dup.next = newNode ;
            dup = dup.next ;
        }
    }
    public void oddNode( List<Integer> list ) {
        for( int i = 0 ; i < list.size() ; i++ ) {
            ListNode newNode = new ListNode( list.get(i) ) ;
            dup.next = newNode ;
            dup = dup.next ;
        }
    }
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int n = 1 ;
        ListNode curr = head ;
        List<Integer> list = new ArrayList<>() ;
        while( curr != null ) {
            list.add( curr.val ) ;
            if( list.size() == n ) {
                if( n %  2 == 0 ) evenNode( list ) ;
                else oddNode(list) ;
                list.clear() ;
                n++ ;
            }
            curr = curr.next ;
        }
        if( list.size() %  2 == 0 ) evenNode( list ) ;
        else oddNode(list) ;
        return selentialNode.next ; 
    }
}