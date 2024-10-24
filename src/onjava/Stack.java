package onjava;

import java.util.Deque;
import java.util.ArrayDeque;

public class Stack<T> {
    private final Deque<T> storage = new ArrayDeque<>();
    public void push(T v) { storage.push(v);}
    public T pop() { return (T)storage.pop(); }
    public T peek() { return (T)storage.peek(); }
    public boolean isEmpty() { return (storage.isEmpty()); }
    @Override
    public String toString(){
        return storage.toString();
    }
}
