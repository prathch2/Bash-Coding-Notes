package cmsc256;

import java.util.Arrays;

public class ArrayBasedStack<T> implements StackInterface<T>{
    private T[] data;
    private int topOfStack;
    private static final int INITIAL_CAPACITY = 5;

    public ArrayBasedStack(int capacity){
        if(capacity <= 0) {
            throw new IllegalArgumentException("Array initial size error.");
        }

        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[capacity];
        data = tempStack;
        topOfStack = -1;
    }

    public ArrayBasedStack () {
        this(INITIAL_CAPACITY);
    }

    private void expandArray() {
        T[] temp = Arrays.copyOf(data, data.length*2);
        data = temp;
    }

    private boolean isArrayFull() {
        if(topOfStack >= data.length - 1) {
            return true;
        }
        return false;
    }

    @Override
    public void push(T newEntry) {
        if(isArrayFull()) {
            expandArray();
        }
        data[++topOfStack] = newEntry;
    }

    @Override
    public T pop() {
        if(topOfStack == -1) {
            throw new EmptyStackException();
        }
        return data[topOfStack--];
    }

    @Override
    public T peek() {
        if(isEmpty()) {
            throw new EmptyStackException("this stack is empty");
        } else {
            return data[topOfStack];
        }
    }

    @Override
    public boolean isEmpty() {
        if(topOfStack < 0) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[INITIAL_CAPACITY];
        data = tempStack;
        topOfStack = -1;
    }
}
