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
            if(this.previousElement != null){
                this.previousElement = this.previousElement.getPreviousElement();
            }
        }
        this.size--;
        return elementToReturn.getValue();
    }

    public T shift(){
        DoublyLinkedListElement<T> firstElement = null;
        DoublyLinkedListElement<T> previousElement = this.currentTail.getPreviousElement();
        if(this.size-1==0){
            firstElement = this.currentTail;
            this.currentTail = null;
            return firstElement.getValue();
        }else{
            for(int i=this.size-1; i>=0; i--){
                if(previousElement.getPreviousElement() != null){
                    previousElement = previousElement.getPreviousElement();
                }else{
                    firstElement = previousElement;
                }
            }
            DoublyLinkedListElement<T> secondElementToBecomeFirst = firstElement.getNextElement();
            secondElementToBecomeFirst.setPreviousElement(null);
            if(secondElementToBecomeFirst == this.previousElement){
                this.previousElement = null;
            }
            this.size--;
        }
        return firstElement.getValue();
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
