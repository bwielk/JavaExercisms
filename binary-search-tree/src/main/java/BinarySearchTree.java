import java.util.List;

class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root = null;

    void insert(T value) {
        if(root==null){
            this.root = new Node<>(value);
        }else if(this.root.getData().compareTo(value) >= 0){
            this.root.setLeftNode(value);
        }else if(this.root.getData().compareTo(value) < 0){
            this.root.setRightNode(value);
        }
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

        public void setLeftNode(T leftNode) {
            this.leftNode = new Node<T>(leftNode);
        }

        public void setRightNode(T rightNode) {
            this.rightNode = new Node<T>(rightNode);
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
