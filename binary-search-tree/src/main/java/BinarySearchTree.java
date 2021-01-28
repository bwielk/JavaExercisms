import java.util.List;

class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root = null;
    private Node<T> currentNode = null;


    void insert(T value) {
        if(this.root==null){
            Node<T> r = new Node<>(value);
            this.root = r;
            this.currentNode = r;
        }else {
            //if current.getData >= value
            if(currentNode.getData().compareTo(value) >= 0){
                if(currentNode.getLeft()==null){
                    currentNode.setLeftNode(value);
                }else{
                    currentNode=currentNode.getLeft();
                    insert(value);
                }
            }else {
                if(currentNode.getRight()==null){
                    currentNode.setRightNode(value);
                }else{
                    currentNode=currentNode.getRight();
                    insert(value);
                }
            }
        }
        currentNode=this.root;
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
