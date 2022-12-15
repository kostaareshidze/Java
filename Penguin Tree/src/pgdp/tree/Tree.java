package pgdp.tree;

import java.util.*;

public class Tree<T> {

    private final Node<T> root;


    public Tree(T data) {
        root = new Node<T>(data);
    }


    private Node<T> isIn(Node<T> current, T value) {
        if (current.getData().equals(value))
            return current;
        for (var child : current.getChildren()) {
            Node<T> other = isIn(child, value);
            if(other != null && other.getData().equals(value))
                return other;
        }
        return null;
    }

    public void insert(T value, T parent)
    {
        Node<T> v = isIn(root, value);
        Node<T> p = isIn(root, parent);
        if(p == null || v != null)
            return;
        v = new Node<>(value);
        p.insert(v);
    }

    public void remove(T value)
    {
        if(root.getData().equals(value))
            return;
        Node<T> v = isIn(root,value);
        if(v == null)
            return;
        v.remove();
    }

    public T LCA(T a, T b) {
        Node<T> first = isIn(root,a);
        Node<T> second = isIn(root,b);
        if(first == null || second == null)
            return null;
        List<Node<T>>  firstSet = new ArrayList<>();
        List<Node<T>>  secondSet = new ArrayList<>();
        getParents(first,firstSet);
        getParents(second,secondSet);
        for (Node<T> tNode : firstSet) {
            for (Node<T> node : secondSet) {
                if (tNode.getData().equals(node.getData())) {
                    return tNode.getData();
                }
            }
        }
        return null;
    }
    private void getParents(Node<T> node,List<Node<T>> parents)
    {
        Node<T> current = node;
        while (current != null)
        {
            parents.add(current);
            current = current.getParent();
        }
    }

    public int distanceBetweenNodes(T a, T b)
    {
        T parent = LCA(a,b);
        List<Node<T>> firstParents = new ArrayList<>();
        List<Node<T>> secondParents = new ArrayList<>();
        getParents(isIn(root,a),firstParents);
        getParents(isIn(root,b),secondParents);
        int distance = 0;
        for (var i : firstParents)
        {
            if(i.getData().equals(parent))
                break;
            distance++;
        }
        for(var i : secondParents)
        {
            if(i.getData().equals(parent))
                break;
            distance++;
        }
        return distance;
    }

    public Node<T> getRoot() {
        return this.root;
    }

    public boolean containsKey(T key) {
        return isIn(root,key) != null;
    }

    public void traversal() {
        root.traversal(root);
    }

}
