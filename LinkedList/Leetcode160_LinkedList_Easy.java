// Solution using the method provided in the problem statement
class Solution1 {
    // Method to find the intersection node of two linked lists
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Initialize pointers to the heads of both linked lists
        ListNode curA = headA;
        ListNode curB = headB;
        
        // Traverse both linked lists until they intersect or reach the end
        while(curA != curB){
            // Move each pointer forward by one node
            // If the pointer reaches the end of its respective list, move it to the head of the other list
            curA = (curA != null) ? curA.next : headB;
            curB = (curB != null) ? curB.next : headA;
        }
        
        // Return the intersection node (or null if there is no intersection)
        return curA;
    }
}

// Alternative solution using length calculation and moving head pointers
class Solution2 {
    // Method to calculate the length of a linked list
    public int getNodeLength(ListNode list){
        int length = 0;
        while(list != null){
            length += 1;
            list = list.next;
        }
        return length;
    }

    // Method to move the head pointer of a linked list by k nodes
    public ListNode moveHeadByK(ListNode list, int k){
        while(k > 0){
            list = list.next;
            k -= 1;
        }
        return list;
    }

    // Method to find the intersection node of two linked lists
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Get the lengths of both linked lists
        int node1 = getNodeLength(headA);
        int node2 = getNodeLength(headB);

        // Initialize pointers to the heads of both linked lists
        ListNode curA = headA;
        ListNode curB = headB;

        // If the length of the first list is greater than the second list,
        // move the head pointer of the first list forward by the difference in lengths
        if(node1 > node2){
            curA = moveHeadByK(headA, node1 - node2);
        } 
        // If the length of the second list is greater than the first list,
        // move the head pointer of the second list forward by the difference in lengths
        else if(node1 < node2) {
            curB = moveHeadByK(headB, node2 - node1);
        }

        // Traverse both linked lists until they intersect or reach the end
        while(curA != curB){
            curA = curA.next;
            curB = curB.next;
            // If either pointer reaches the end without finding an intersection, return null
            if(curA == null || curB == null){
                return null;
            }
        }

        // Return the intersection node (or null if there is no intersection)
        return curA;    
    }
}
