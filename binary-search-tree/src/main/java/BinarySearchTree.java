import java.util.List;

class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root = null;

    void insert(T value) {
        this.root = new Node<>(value);
    }

    List<T> getAsSortedList() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    List<T> getAsLevelOrderList() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    Node<T> getRoot() {
        return this.root;
    }

    static class Node<T> {

        private T data;
        private Node<T> leftNode;
        private Node<T> rightNode;

        public Node(T data) {
            this.data = data;
        }

        public void setLeftNode(Node<T> leftNode) {
            this.leftNode = leftNode;
        }

        public void setRightNode(Node<T> rightNode) {
            this.rightNode = rightNode;
        }

        public Node<T> getLeft() {
            return leftNode;
        }

        public Node<T> getRight() {
            return rightNode;
        }

        public T getData() {
            return data;
        }
    }
}
