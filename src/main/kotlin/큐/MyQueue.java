package 큐;

import java.util.LinkedList;

public class MyQueue {
    private LinkedList<Integer> queue;

    public MyQueue() {
        this.queue = new LinkedList<>();
    }

    public void offer(Integer n) {
        queue.addLast(n);
    }

    public int poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }

        return queue.removeFirst();
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }

        return queue.getFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        /* enqueue */
        queue.offer(55);

        /* peek */
        System.out.println(queue.peek());

        /* isEmpty */
        System.out.println(queue.isEmpty());

        /* dequeue */
        queue.poll();

        /* isEmpty */
        System.out.println(queue.isEmpty());
    }
}
