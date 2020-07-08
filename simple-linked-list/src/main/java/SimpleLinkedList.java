import com.sun.istack.internal.NotNull;

class SimpleLinkedList<T> {

    private T[] list;

    public SimpleLinkedList(T[] values){
        this.list = values;
    }

    public SimpleLinkedList(){

    }

    public int size(){
        return list.length;
    }

    public void push(T s) {
    }

    public boolean pop() {
        return true;
    }

    public void reverse() {
    }

    public Object[] asArray(Class<T> characterClass) {
        return new Object[]{};
    }

    class SimpleLinkedListElement<T> {

        private T value;
        private SimpleLinkedListElement nextElement;
        private boolean hasNext = false;

        public void setValue(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public SimpleLinkedListElement getNextElement() {
            return nextElement;
        }

        public void setNextElement(@NotNull SimpleLinkedListElement nextElement) {
            this.nextElement = nextElement;
            this.hasNext = true;
        }
    }

}