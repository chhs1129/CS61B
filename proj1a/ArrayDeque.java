public class ArrayDeque<Type> {
    public Type[] items;
    private int nextFirst;
    private int nextLast;
    private int size;

    /***
     * Helper functions
     */
    //Check if current position to insert
    //is the last vacant spot in the array
    private boolean isLastOne() {
        return nextFirst == nextLast;
    }

    //double items[] size
    private void increaseSize() {
        int newSize = items.length * 2;
        int newNextLast = items.length;
        int newNextFirst = newSize - 1;
        Type[] newItems = (Type[]) new Object[newSize];
        for (int idx = 0; idx < size; idx++) {
            newItems[idx] = items[nextFirst];
            nextFirst += 1;
            if (nextFirst == size) {
                nextFirst = 0;
            }
        }
        nextFirst = newNextFirst;
        nextLast = newNextLast;
        items = newItems;
    }

    //move nextFirst to left by 1, check if hit the boundary
    private void moveNextFirstLeft() {
        nextFirst -= 1;
        if (nextFirst < 0) {
            nextFirst = items.length - 1;
        }
    }

    //move nextFirst to right by 1, check if hit the boundary
    private void moveNextFirstRight() {
        nextFirst += 1;
        if (nextFirst == items.length) {
            nextFirst = 0;
        }
    }

    //move nextLast to right by 1, check if hit the boundary
    private void moveNextLastRight() {
        nextLast += 1;
        if (nextLast == items.length) {
            nextLast = 0;
        }
    }

    //move nextFirst to left by 1, check if hit the boundary
    private void moveNextLastLeft() {
        nextLast -= 1;
        if (nextLast < 0) {
            nextLast = items.length - 1;
        }
    }

    //check if need to downsize
    private boolean lowUsage() {
        return items.length >= 16 && size < (items.length / 4);
    }

    //downsize to size of 8
    private void downSize() {
        int newSize = (items.length / 2);
        int newNextLast = size;
        int newNextFirst = newSize - 1;
        Type[] newItems = (Type[]) new Object[newSize];
        moveNextFirstRight();
        for (int idx = 0; idx < size; idx++) {
            newItems[idx] = items[nextFirst];
            moveNextFirstRight();
        }
        nextFirst = newNextFirst;
        nextLast = newNextLast;
        items = newItems;
    }

    

    /***
     * Constructor
     */
    public ArrayDeque() {
        items = (Type[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

    /***
     * Deep copy from another Array Deque
     * @param other
     */
    public ArrayDeque(ArrayDeque other) {
        items = (Type[]) new Object[other.size];
        nextFirst = other.nextFirst;
        nextLast = other.nextLast;
        size = other.size;

        System.arraycopy(other.items, 0, items, 0, other.size);
    }


    /***
     * Add an item to the front of the Array deque
     * @param item
     */
    public void addFirst(Type item) {
        if (isLastOne()) {
            items[nextFirst] = item;
            size += 1;
            increaseSize();
        } else {
            items[nextFirst] = item;
            moveNextFirstLeft();
            size += 1;
        }
    }

    /***
     * Add an item to the end of the Array deque
     * @param item
     */
    public void addLast(Type item) {
        if (isLastOne()) {
            items[nextLast] = item;
            moveNextFirstRight();
            size += 1;
            increaseSize();
        } else {
            items[nextLast] = item;
            moveNextLastRight();
            size += 1;
        }
    }

    /***
     * check if the Array deque is empty
     * @return True if empty, False otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /***
     * get the size of Array deque
     */
    public int size() {
        return size;
    }

    /***
     * print the Array deque
     */
    public void printDeque() {
        int curr = nextFirst + 1;
        if (curr == items.length) {
            curr = 0;
        }
        for (int idx = 0; idx < size; idx++) {
            System.out.print(items[curr]+" ");
            curr += 1;
            if (curr == items.length) {
                curr = 0;
            }
        }
        System.out.println();
    }

    /***
     * remove the front item of Array deque
     * @return
     */
    public Type removeFirst() {
        if(isEmpty())
            return null;
        if(lowUsage()){
            downSize();
        }
        moveNextFirstRight();
        Type res = items[nextFirst];
        items[nextFirst] = null;
        size -= 1;
        return res;
    }

    /***
     * remove the end item of the Array deque
     * @return
     */
    public Type removeLast() {
        if(isEmpty())
            return null;
        if(lowUsage()){
            downSize();
        }
        moveNextLastLeft();
        Type res = items[nextLast];
        items[nextLast] = null;
        size -= 1;
        return res;
    }

    /***
     * get the item at index - iterative
     * @param index
     * @return the item
     */
    public Type get(int index) {
        if(index >= size)
            return null;
        int curr = nextFirst + 1;
        if (curr == items.length) {
            curr = 0;
        }
        while(index > 0){
            curr += 1;
            if (curr == items.length) {
                curr = 0;
            }
            index -= 1;
        }
        return items[curr];
    }

}
