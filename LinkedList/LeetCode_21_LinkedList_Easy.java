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

// Iterative approach
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newList = new ListNode(-1);
        ListNode newHead = newList;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                newHead.next = list1;
                list1 = list1.next;
            } else {
                newHead.next = list2;
                list2 = list2.next;
            }
            newHead = newHead.next;
        }

        if(list1 != null){
            newHead.next = list1;
        }
        if(list2 != null){
            newHead.next = list2;
        }

        return newList.next;
    }
}

// Recursive approach
class Solution {
    // Method to merge two sorted linked lists
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // If list1 is null, return list2 (base case)
        if(list1 == null){
            return list2;
        }
        // If list2 is null, return list1 (base case)
        if(list2 == null){
            return list1;
        }
        // If the value of list1's node is less than or equal to the value of list2's node,
        // recursively call mergeTwoLists with list1's next node and list2,
        // and set list1's next node to the result
        if(list1.val <= list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            // If the value of list2's node is less than the value of list1's node,
            // recursively call mergeTwoLists with list1 and list2's next node,
            // and set list2's next node to the result
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
