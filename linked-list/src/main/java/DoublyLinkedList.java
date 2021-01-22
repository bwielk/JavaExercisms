class DoublyLinkedList<T> {

    private DoublyLinkedListElement<T> previousElement;
    private DoublyLinkedListElement<T> currentTail; //recent element
    private int size=0;


    public DoublyLinkedList() {
    }

    public void push (T element){
        DoublyLinkedListElement<T> el;
        if(currentTail == null){
            el = new DoublyLinkedListElement<>(element);
            this.currentTail = el;
        }else{
            el = new DoublyLinkedListElement<>(element);
            this.currentTail.setNextElement(el);
            el.setPreviousElement(this.currentTail);
            this.previousElement = this.currentTail;
            this.currentTail = el;
        }
        this.size++;
    }

    public T pop(){
        DoublyLinkedListElement<T> elementToReturn;
        if(this.size < 1){
            throw new IllegalStateException();
        }else{
            elementToReturn = this.currentTail;
            this.currentTail = this.previousElement;
            this.previousElement = this.previousElement.getPreviousElement();
        }
        return elementToReturn.getValue();
    }

    public T shift(){
        return null;
    }

    public void unshift(T t){
    }

    class DoublyLinkedListElement<T>{

        private DoublyLinkedListElement<T> previousElement = null;
        private DoublyLinkedListElement<T> nextElement = null;
        private T value;

        public DoublyLinkedListElement(T value){
            this.value = value;
        }

        public void setNextElement(DoublyLinkedListElement<T> nextElement) {
            this.nextElement = nextElement;
        }

        public void setPreviousElement(DoublyLinkedListElement<T> previousElement) {
            this.previousElement = previousElement;
        }

        public DoublyLinkedListElement<T> getNextElement() {
            return nextElement;
        }

        public DoublyLinkedListElement<T> getPreviousElement() {
            return previousElement;
        }

        public T getValue() {
            return value;
        }
    }

}
