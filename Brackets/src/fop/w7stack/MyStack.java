package fop.w7stack;

public class MyStack {
    private char[] array;
    private int SIZE = 100;
    int i;

    public MyStack() {
        array = new char[SIZE];
        i = -1;
    }

    public boolean isEmpty() {
        return i == -1;
    }

    public boolean add(char c) {
        if (i == SIZE-1)
            return false;
        else {
            i++;
            array[i] = c;
        }
        return true;
    }

    public char pop() {
        char c = array[i];
        i--;
        return c;
    }

    public char top() {
        return array[i];
    }

}
