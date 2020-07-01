public interface Deque<Type> {
    void addFirst(Type item);
    void addLast(Type item);
    default boolean isEmpty() {
        return size() == 0;
    }
    int size();
    void printDeque();
    Type removeFirst();
    Type removeLast();
    Type get(int index);
}
