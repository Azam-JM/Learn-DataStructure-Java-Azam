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
    // Method to reverse a singly-linked list
    public ListNode reverseList(ListNode head) {
        // Initialize pointers to keep track of the current node and its previous node
        ListNode current = head;
        ListNode prev = null;

        // Traverse the list and reverse the pointers
        while(current != null){
            // Save the next node before changing the pointer
            ListNode next = current.next;
            // Reverse the pointer to point to the previous node
            current.next = prev;

            // Move to the next node in the original list
            prev = current;
            current = next;
        }

        // Return the new head of the reversed list
        return prev;
    }
}

// Recursive approach
class Solution {
    public ListNode reverseList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;

        head.next = null;

        return newHead;
        
    }
}
