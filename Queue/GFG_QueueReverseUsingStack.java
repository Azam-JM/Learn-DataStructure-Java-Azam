class GfG{
    // Function to reverse the queue.
    public Queue<Integer> rev(Queue<Integer> q){
        // Initialize a stack and a new queue
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> reversedQueue = new ArrayDeque<>();
        
        // Push all elements of the input queue into the stack
        for(int val: q){
            stack.push(val);
        }
        
        // Pop elements from the stack and add them to the new queue
        while(!stack.empty()){
            reversedQueue.add(stack.peek());
            stack.pop();
        }
        
        return reversedQueue;
    }
}
