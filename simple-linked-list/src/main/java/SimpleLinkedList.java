import com.sun.istack.internal.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

class SimpleLinkedList<T> {

    private T[] list;

    public SimpleLinkedList(T[] values){
        this.list = values;
    }

    public SimpleLinkedList(){
        this.list = (T[]) new Object[0];
    }

    public int size(){
        return list.length;
    }

    public void push(T s) {
        int currentSize = size();
        int newSize = currentSize +1;
        T[] newlist = (T[]) new Object[newSize];
        for(int i=0; i<currentSize; i++){
            newlist[i] = this.list[i];
        }
        newlist[newSize-1] = s;
        this.list = newlist;
    }

    public T pop() {
        if(this.list.length > 0){
            int currentSize = size();
            int newSize = currentSize -1;
            T[] newlist = (T[]) new Object[newSize];
            for(int i=0; i<newSize; i++){
                newlist[i] = this.list[i];
            }
            T objectToReturn = this.list[currentSize-1];
            this.list = newlist;
            return objectToReturn;
        }else{
            throw new NoSuchElementException();
        }
    }

    public void reverse() {
        Collections.reverse(Arrays.asList(this.list));
    }

    public Object[] asArray(Class<T> characterClass) {
        return this.list;
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