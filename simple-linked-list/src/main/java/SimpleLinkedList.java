
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
            newElement.setNextElement(this.recentElement);
            this.recentElement = newElement;
        }
        this.length++;
    }

    public T pop() {
        if(this.length == 0 && this.recentElement == null){
            throw new NoSuchElementException();
        }
        SimpleLinkedListElement<T> elementToReturn = this.recentElement;
        this.recentElement = elementToReturn.getNextElement();
        this.length--;
        return elementToReturn.getValue();
    }

    public void reverse() {
    }

    public Object[] asArray(Class<T> characterClass) {
        return null;
    }

    class SimpleLinkedListElement<T> {

        private T value;
        private SimpleLinkedListElement<T> nextElement;
        private boolean hasNext = false;

        public SimpleLinkedListElement(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public SimpleLinkedListElement<T> getNextElement() {
            return nextElement;
        }

        public void setNextElement(SimpleLinkedListElement<T> nextElement) {
            this.nextElement = nextElement;
            if(nextElement != null){
                this.hasNext=true;
            }else{
                this.hasNext = true;
            }
        }
    }

}