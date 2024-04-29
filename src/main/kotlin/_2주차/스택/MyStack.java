package _2주차.스택;

import java.util.LinkedList;

public class MyStack {
    private LinkedList<Integer> stack;

    public MyStack() {
        this.stack = new LinkedList<>();
    }

    public void push(int n) {
        stack.addFirst(n);
    }

    public int pop() {
        if(isEmpty()) {
            throw new IllegalStateException("Stack is Empty!");
        }

        return stack.removeFirst();
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is Empty!");
        }

        return stack.getFirst();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();

        /* enqueue */
        stack.push(5);

        /* peek */
        System.out.println(stack.peek());

        /* isEmpty */
        System.out.println(stack.isEmpty());

        /* dequeue */
        stack.pop();

        /* isEmpty */
        System.out.println(stack.isEmpty());
    }
}
