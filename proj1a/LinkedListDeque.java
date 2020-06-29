public class LinkedListDeque<Type> {
    public class Node {
        private Type item;
        private Node next;
        private Node prev;

        public Node(Type it, Node prevNode, Node nextNode) {
            item = it;
            next = nextNode;
            prev = prevNode;
        }
    }

    private Node dummyNode;
    private int size = 0;

    /***
     * Creates an empty LinkedList deque
     */
    public LinkedListDeque() {
        dummyNode = new Node(null, null, null);
        dummyNode.next = dummyNode;
        dummyNode.prev = dummyNode;
        size = 0;
    }

    /***
     * Deep copy from another LinkedList deque
     * @param other LinkedList deque
     */
    public LinkedListDeque(LinkedListDeque other) {
        Node temp = other.dummyNode;
        while (temp.next != other.dummyNode) {
            temp = temp.next;
            addLast(temp.item);
            size += 1;
        }
    }

    /***
     * Add an item to the front of the LinkedList deque
     * @param item
     */
    public void addFirst(Type item) {
        Node newNode = new Node(item, dummyNode, dummyNode.next);
        dummyNode.next.prev = newNode;
        dummyNode.next = newNode;
        size += 1;
    }

    /***
     * Add an item to the end of the LinkedList deque
     * @param item
     */
    public void addLast(Type item) {
        Node newNode = new Node(item, dummyNode.prev, dummyNode);
        dummyNode.prev.next = newNode;
        dummyNode.prev = newNode;
        size += 1;
    }

    /***
     * check if the LinkedList deque is empty
     * @return True if empty, False otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /***
     * get the size of LinkedList deque
     */
    public int size() {
        return size;
    }

    /***
     * print the LinkedList deque
     */
    public void printDeque() {
        if (size > 0) {
            Node temp = dummyNode.next;
            int tempSize = size;
            while (tempSize > 0) {
                System.out.print(temp.item);
                System.out.print(" ");
                temp = temp.next;
                tempSize--;
            }
            System.out.println();
        }
    }

    /***
     * remove the front item of LinkedList deque
     * @return
     */
    public Type removeFirst() {
        if (size == 0) {
            return null;
        }
        Node temp = dummyNode.next;
        dummyNode.next = dummyNode.next.next;
        dummyNode.next.prev = dummyNode;
        size -= 1;
        return temp.item;
    }

    /***
     * remove the end item of the LinkedList deque
     * @return
     */
    public Type removeLast() {
        if (size == 0) {
            return null;
        }
        Node temp = dummyNode.prev;
        dummyNode.prev = dummyNode.prev.prev;
        dummyNode.prev.next = dummyNode;
        size -= 1;
        return temp.item;
    }

    /***
     * get the item at index - iterative
     * @param index
     * @return the item
     */
    public Type get(int index) {
        if (index > size)
            return null;
        Node temp = dummyNode.next;
        while (index != 0) {
            temp = temp.next;
            index--;
        }
        return temp.item;
    }

    /***
     * get method - recursive
     * @param index
     * @return the itemx
     */
    public Type getRecursive(int index) {
        if (index < size)
            return getRecursiveHelper(index, dummyNode.next);
        else
            return null;
    }

    private Type getRecursiveHelper(int index, Node curr) {
        if (index==0)
            return curr.item;
        return getRecursiveHelper(index--, curr.next);
    }
}
