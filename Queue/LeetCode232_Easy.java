class MyQueue {
    // Declare two stacks to represent the queue
    Stack<Integer> s1; // Stack for push operation
    Stack<Integer> s2; // Stack for pop and peek operations

    // Constructor to initialize the stacks
    public MyQueue() {
        s1 = new Stack<Integer>(); // Initialize the first stack
        s2 = new Stack<Integer>(); // Initialize the second stack
    }

    // Method to transfer elements from s1 to s2
    public void transferElementsS1toS2() {
        while (!s1.empty()) { // Iterate until s1 is empty
            s2.push(s1.peek()); // Push the top element of s1 to s2
            s1.pop(); // Pop the top element from s1
        }
    }

    // Method to add an element to the queue
    public void push(int x) {
        s1.push(x); // Push the element onto s1
    }

    // Method to remove and return the front element from the queue
    public int pop() {
        if (s2.empty()) { // If s2 is empty, transfer elements from s1 to s2
            transferElementsS1toS2();
        }
        int front = s2.peek(); // Get the front element from s2
        s2.pop(); // Pop the front element from s2
        return front; // Return the front element
    }

    // Method to return the front element of the queue without removing it
    public int peek() {
        if (s2.empty()) { // If s2 is empty, transfer elements from s1 to s2
            transferElementsS1toS2();
        }
        return s2.peek(); // Return the front element of s2
    }

    // Method to check if the queue is empty
    public boolean empty() {
        // Return true if both s1 and s2 are empty, otherwise return false
        return (s2.empty() && s1.empty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */