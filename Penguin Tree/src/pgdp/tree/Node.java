package pgdp.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Node<T> {

    private List<Node<T>> children;
    private Node<T> parent;
    private T data;

    public Node(T data) {
        this.data = data;
        children = new ArrayList<>();
    }

    public void insert(Node<T> value) {
        children.add(value);
        value.parent = this;
    }

    public boolean isLeaf() {
        int counter = 0;
        for (Node<T> child : children) {
            if (child != null)
                counter++;
        }
        return counter == 0;
    }

    private int newSize(Node<T> root, int value) {
        value++;
        for (var child: root.children) {
            value = newSize(child, value);
        }
        return value;
    }

    public int size() {
        return newSize(this, 0);
    }

    private void deleteNode(Node<T> current) {
        Node<T> newParent = current.parent;
        newParent.children.remove(current);
        for (int i = 0; i < current.children.size(); i++) {
            current.children.get(i).parent = newParent;
            newParent.children.add(current.children.get(i));
        }
    }

    public void remove() {
        deleteNode(this);
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public Node<T> getParent() {
        return parent;
    }

    public T getData() {
        return data;
    }

    public void traversal(Node<T> root) {
        System.out.print(root.data + " ");
        for (int i = 0; i < root.children.size(); i++) {
            traversal(root.children.get(i));
        }
    }
}

