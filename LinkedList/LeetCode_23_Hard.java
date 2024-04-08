// Iterative approach
class Solution {
    public ListNode merge2Lists(ListNode list1, ListNode list2){
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        
        ListNode list3 = new ListNode(-1);
        ListNode cur = list3;

        // Check if any list has reached null
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                // Add list1 to list3
                cur.next = list1;
                list1 = list1.next;
            } else {
                // Add list2 to list3
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        if(list1 != null){
            cur.next = list1;
        }
        if(list2 != null){
            cur.next = list2;
        }

        ListNode result = list3;
        return list3.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode finalList = null;
        if(lists == null || lists.length == 0){
            return finalList;
        }

        for(int i=0; i<lists.length; i++){
            finalList = merge2Lists(finalList, lists[i]);
        }

        return finalList;
    }
}
