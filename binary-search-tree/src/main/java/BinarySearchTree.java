import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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
        return collectSortedNodeValues(this.root);
    }

    List<T> collectSortedNodeValues(Node<T> node){
        List<T> nodeValues = new LinkedList<>();
        if(node == null){
            return nodeValues;
        }
        nodeValues.addAll(collectSortedNodeValues(node.getLeft()));
        nodeValues.add(node.getData());
        nodeValues.addAll(collectSortedNodeValues(node.getRight()));
        return nodeValues;
    }

    List<T> getAsLevelOrderList() {
        List<Node<T>> allNodesAsList = new ArrayList<>();
        if(this.root != null){
            allNodesAsList.add(this.root);
            for(int i=0; i<allNodesAsList.size(); i++){
                Node<T> currentNode = allNodesAsList.get(i);
                if(currentNode.getLeft() != null){
                    allNodesAsList.add(currentNode.getLeft());
                }
                if(currentNode.getRight() != null){
                    allNodesAsList.add(currentNode.getRight());
                }
            }
        }
        return allNodesAsList.stream().map(Node::getData).collect(Collectors.toList());
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
