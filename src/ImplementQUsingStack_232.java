import java.util.Stack;

public class ImplementQUsingStack_232 {
    class MyQueue
    {
        Stack<Integer> stack;
        Stack<Integer> temp;
        /** Initialize your data structure here. */
        public MyQueue() {
            stack = new Stack<>();
            temp = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            while (!stack.empty())
            {
                temp.push(stack.pop());
            }
            temp.push(x);
            while (!temp.empty())
            {
                stack.push(temp.pop());
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return stack.pop();
        }

        /** Get the front element. */
        public int peek() {
            return stack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack.empty();
        }
    }
}
