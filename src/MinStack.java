import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class MinStack {

    Deque<Integer> minStack;
    Deque<Integer> xStack;//辅助栈

    public MinStack() {
        minStack = new LinkedList<>();
        xStack =  new LinkedList<>();
        xStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        minStack.push(val);
        xStack.push(Math.min(xStack.peek(), val));
    }

    public void pop() {
        minStack.pop();
        xStack.pop();
    }

    public int top() {
        return minStack.peek();// assert not empty
    }

    public int getMin() {
        return xStack.peek();
    }
}