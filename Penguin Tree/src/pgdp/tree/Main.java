package pgdp.tree;

public class Main {
    public static void main(String[] args) {
        Node<Integer> i5 = new Node<>(5);
        Node<Integer> i6 = new Node<>(6);
        Node<Integer> i7 = new Node<>(7);
        Node<Integer> i8 = new Node<>(8);
        Node<Integer> i9 = new Node<>(9);
        Node<Integer> i10 = new Node<>(10);
        Node<Integer> i11 = new Node<>(11);
        Node<Integer> i12 = new Node<>(12);
        Node<Integer> i13 = new Node<>(13);
        Node<Integer> i14 = new Node<>(14);
        Node<Integer> i15 = new Node<>(15);
        Node<Integer> i16 = new Node<>(16);

//        i5.insert(i6);
//        i5.insert(i7);
//
//        i6.insert(i11);
//        i6.insert(i12);
//        i6.insert(i13);
//        i6.insert(i14);
//
//        i7.insert(i8);
//        i7.insert(i9);
//        i7.insert(i10);
//        i12.insert(i15);
//        i12.insert(i16);
//        i6.insert(i16);
        var tree = new Tree<Integer>(5);

        tree.insert(3, 5);
    }
}
