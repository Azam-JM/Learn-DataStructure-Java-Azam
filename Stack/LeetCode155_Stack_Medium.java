class MinStack {
    Stack<Integer> st1; // Main stack to store all elements
    Stack<Integer> st2; // Auxiliary stack to store minimum elements

    public MinStack() {
        // Initialize both stacks
        this.st1 = new Stack<Integer>();
        this.st2 = new Stack<Integer>();
    }
    
    public void push(int val) {
        // Push the element onto the main stack
        st1.push(val);
        
        // If the auxiliary stack is not empty, push the minimum of the current value and the previous minimum onto it
        if(!st2.empty()){
            st2.push(Math.min(st2.peek(), val));
        } else {
            // If the auxiliary stack is empty (i.e., the first element is being pushed), push the value onto it
            st2.push(val);
        }
    }
    
    public void pop() {
        // Pop the top element from both stacks
        st1.pop();
        st2.pop();
    }
    
    public int top() {
        // Return the top element of the main stack
        return st1.peek();
    }
    
    public int getMin() {
        // Return the top element of the auxiliary stack, which represents the current minimum element
        return st2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
