package 링크드리스트;

public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    // 노드는 자기 자신과 다음 노드를 알고있음
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /* 리스트 가장 뒤에 값 추가 */
    public void append(T data) {
        // 새 노드 객체 생성
        Node<T> newNode = new Node<>(data);

        // 빈 리스트라면 머리와 꼬리에 새 노드를 할당
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else { // 아니라면 꼬리에만 새 노드를 할당
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /* 리스트 가장 앞에 값 추가 */
    public void prepend(T data) {
        // 새 노드 객체 생성
        Node<T> newNode = new Node<>(data);

        // 빈 리스트라면 머리와 꼬리에 새 노드를 할상
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else { // 아니라면
            newNode.next = head; // origin 의 머리가 새 노드의 다음이 되고,
            head = newNode; // 머리에 새 노드를 할당
        }
        size++;
    }

    /* 원하는 값 삭제 */
    public void delete(T data) {
        if (isEmpty()) {
            return;
        }

        // 단 한개의 노드만 존재했을 경우
        if (head.data.equals(data)) {
            head = head.next; // 머리는 다음 노드가 되고
            size--;
            if (size == 0) { // 더 이상 존재하는 노드가 없을 경우
                tail = null; // 꼬리에 null 을 할당
            }
            return;
        }

        // 그렇지 않은경우
        Node<T> current = head;
        // 1. 일치하는 값이 있을 때까지 모든 노드를 조회
        while (current.next != null) {
            // 2. 일치하는 값이 있다면
            if (current.next.data.equals(data)) {
                // 다음 다음 노드를 현재 삭제하는 노드의 다음에 할당
                current.next = current.next.next;
                size--;
                if (current.next == null) { // 다음 노드가 없는 경우
                    tail = current; // 꼬리에 현재 노드를 할당
                }
                return;
            }

            current = current.next;
        }
    }

    /* 리스트 가장 앞에 있는 값 삭제 */
    public void deleteFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        size--;
        if (size == 0) {
            tail = null;
        }
    }

    /* 리스트 가장 뒤에 있는 값 삭제 */
    public void deleteLast() {
        if (isEmpty()) {
            return;
        }
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node<T> current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = null;
            tail = current;
        }
        size--;
    }

    /* 리스트 출력 */
    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> myList = new MyLinkedList<>();
        myList.append(1);
        myList.append(2);
        myList.append(3);
        myList.display(); // 출력: 1 2 3

        myList.prepend(0);
        myList.display(); // 출력: 0 1 2 3

        myList.delete(2);
        myList.display(); // 출력: 0 1 3

        myList.deleteFirst();
        myList.display(); // 출력: 1 3

        myList.deleteLast();
        myList.display(); // 출력: 1
    }
}
