
import java.util.Arrays;
import java.util.NoSuchElementException;

class SimpleLinkedList<T> {

    private SimpleLinkedListElement<T> recentElement;
    private int length = 0;


    public SimpleLinkedList(T[] values){
        Arrays.asList(values).forEach(this::push);
    }

    public SimpleLinkedList(){
    }

    public int size(){
        return this.length;
    }

    public void push(T s) {
        SimpleLinkedListElement<T> newElement = new SimpleLinkedListElement<>(s);
        if(this.recentElement == null){
            this.recentElement = newElement;
        }else{
            newElement.setTail(this.recentElement);
            this.recentElement = newElement;
        }
        this.length++;
    }

    public T pop() {
        if(this.length == 0 && this.recentElement == null){
            throw new NoSuchElementException();
        }
        SimpleLinkedListElement<T> elementToReturn = this.recentElement;
        this.recentElement = elementToReturn.getTail();
        this.length--;
        return elementToReturn.getValue();
    }

    public void reverse() {
        Object[] arr = asArray((Class<T>) Object.class);
        this.recentElement = null;
        for(int i=0; i<arr.length; i++){
            push((T) arr[i]);
        }
    }

    public Object[] asArray(Class<T> characterClass) {
        Object[] arrayToReturn = new Object[this.length];
        for(int i=0; i<this.length; i++){
            arrayToReturn[i] = this.recentElement.getValue();
            this.recentElement = this.recentElement.getTail();
        }
        return arrayToReturn;
    }

    class SimpleLinkedListElement<T> {

        private T value;
        private SimpleLinkedListElement<T> tail;
        private boolean hasTail = false;

        public SimpleLinkedListElement(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public SimpleLinkedListElement<T> getTail() {
            return tail;
        }

        public void setTail(SimpleLinkedListElement<T> nextElement) {
            this.tail = nextElement;
            if(nextElement != null){
                this.hasTail = true;
            }else{
                this.hasTail = true;
            }
        }
    }

}