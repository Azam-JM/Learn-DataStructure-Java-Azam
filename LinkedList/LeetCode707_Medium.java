// Definition of a doubly linked list node
class Node {
    Node prev; // Pointer to the previous node
    int data; // Data stored in the node
    Node next; // Pointer to the next node

    // Constructor to initialize a node with data
    public Node(int val){
        this.prev = null;
        this.data = val;
        this.next = null;
    }

    // Constructor to initialize a node with data, previous, and next pointers
    public Node(int val, Node prev, Node next){
        this.data = val;
        this.prev = prev;
        this.next = next;
    }
}

// Definition of a doubly linked list
class MyLinkedList {
    Node head; // Pointer to the head node of the linked list
    int length; // Length of the linked list

    // Constructor to initialize an empty linked list
    public MyLinkedList() {
        head = null;
        length = 0;
    }
    
    // Method to get the value at a specified index in the linked list
    public int get(int index) {
        if(index < 0 || index >= this.length){
            return -1; // Index out of bounds, return -1
        }
        Node current = this.head;

        // Traverse the list to the specified index
        for(int i=0; i<index; i++){
            current = current.next;
        }

        // Return the value at the specified index
        return current.data;
    }
    
    // Method to add a new node with the given value at the beginning of the linked list
    public void addAtHead(int val) {
        Node newNode = new Node(val);

        // Make the new node the new head of the linked list
        newNode.next = this.head;
        this.head = newNode;
        this.length += 1; // Increment the length of the linked list
    }
    
    // Method to add a new node with the given value at the end of the linked list
    public void addAtTail(int val) {
        if(this.length == 0){
            addAtHead(val); // If the list is empty, add the node at the head
            return;
        }

        Node current = this.head;
        // Traverse the list to the last node
        while(current.next != null){
            current = current.next;
        }

        // Create a new node and make it the next node of the current last node
        Node newNode = new Node(val, current, null);
        current.next = newNode;

        // Increment the length of the linked list
        this.length += 1;
    }
    
    // Method to add a new node with the given value at the specified index in the linked list
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > this.length){
            return; // Index out of bounds, do nothing
        }

        if(index == 0){
            addAtHead(val); // If the index is 0, add the node at the head
            return;
        }

        Node current = this.head;
        // Traverse the list to the node before the specified index
        for(int i=0; i< index - 1; i++){
            current = current.next;
        }

        // Create a new node and insert it between the current node and the next node
        Node nextNode = current.next;
        Node newNode = new Node(val, current, nextNode);
        current.next = newNode;
        if(nextNode != null){
            newNode.next = nextNode;
        }

        // Increment the length of the linked list
        this.length += 1;
    }
        

    // Method to delete the head node of the linked list
    public void deleteAtHead(){
        Node secondNode = this.head.next;
        if(secondNode != null){
            secondNode.prev = null;
        }
        this.head = secondNode;
        this.length -= 1; // Decrement the length of the linked list
    }

    // Method to delete the tail node of the linked list
    public void deleteAtTail(int index){
        Node current = this.head;
        // Traverse the list to the second last node
        for(int i=0; i< index-1; i++){
            current = current.next;
        }
        // Remove the reference to the last node
        current.next = null;
    }
    
    // Method to delete the node at the specified index in the linked list
    public void deleteAtIndex(int index) {
        if(index == 0){
            deleteAtHead(); // If the index is 0, delete the head node
            return;
        }

        if(index == this.length -1){
            deleteAtTail(index); // If the index is the last node, delete the tail node
            return;
        }

        Node current = this.head;
        // Traverse the list to the node before the specified index
        for(int i=0; i< index-1; i++){
            current = current.next;
        }    

        // Remove the reference to the node at the specified index
        current.next = current.next.next;
        current.next.prev = current;
        // Decrement the length of the linked list
        this.length -= 1;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
