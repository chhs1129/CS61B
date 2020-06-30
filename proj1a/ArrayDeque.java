public class ArrayDeque<Type> {
    Type[] arr;
    int position;

    /***
     * Constructor
     */
    public ArrayDeque() {
        arr = (Type[]) new Object[8];
    }

    /***
     * Deep copy from another Array Deque
     * @param other
     */
    public ArrayDeque(ArrayDeque other) {
        Type[] temp = (Type[]) new Object[other.arr.length];
        System.arraycopy(arr, 0, temp, 0, other.size());
        position = other.size();
    }


    /***
     * Add an item to the front of the LinkedList deque
     * @param item
     */
    public void addFirst(Type item) {
        Type[] temp = (Type[]) new Object[arr.length + 1];
        temp[0] = item;
        System.arraycopy(arr, 0, temp, 1, position);
        arr = temp;
        position += 1;
    }

    /***
     * Add an item to the end of the LinkedList deque
     * @param item
     */
    public void addLast(Type item) {
        if (position >= arr.length) {
            Type[] temp = (Type[]) new Object[arr.length * 2];
            System.arraycopy(arr, 0, temp, 0,position);
            arr = temp;
        }

        arr[position] = item;
        position += 1;
    }

    /***
     * check if the LinkedList deque is empty
     * @return True if empty, False otherwise
     */
    public boolean isEmpty() {
        return arr.length == 0;
    }

    /***
     * get the size of LinkedList deque
     */
    public int size() {
        return position;
    }

    /***
     * print the LinkedList deque
     */
    public void printDeque() {
        for(int i = 0; i < position; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    /***
     * remove the front item of LinkedList deque
     * @return
     */
    public Type removeFirst() {
        if (position == 0)
            return null;
        Type tempItem = arr[0];
        Type[] temp = (Type[]) new Object[arr.length - 1];
        System.arraycopy(arr, 1, temp, 0, position);
        position -= 1;
        arr = temp;
        return tempItem;
    }

    /***
     * remove the end item of the LinkedList deque
     * @return
     */
    public Type removeLast() {
        if(position == 0)
            return null;
        Type tempVal = arr[position-1];
        arr[position-1] = null;
        position -= 1;
        //check usage factor
        if((double)position / arr.length < 0.25) {
            Type[] temp = (Type[]) new Object[position];
            System.arraycopy(arr, 0, temp, 0, position);
            arr = temp;
        }
        return tempVal;
    }

    /***
     * get the item at index - iterative
     * @param index
     * @return the item
     */
    public Type get(int index) {
        if(index >= 0 && index < position)
            return arr[index];
        return null;
    }

}
