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
        //only one node exists scenario
        if(this.size-1==0){
            firstElement = this.currentTail;
            this.currentTail = null;
            return firstElement.getValue();
        }else{
            //traverse through the nodes until the very first one
            for(int i=this.size-1; i>=0; i--){
                //if a node has another node set as the previous one, then keep going
                if(previousElement.getPreviousElement() != null){
                    previousElement = previousElement.getPreviousElement();
                }else{
                    //if a node doesn't have the previous node set, then it's clear it's the first node
                    firstElement = previousElement;
                }
            }
            DoublyLinkedListElement<T> secondElementToBecomeFirst = firstElement.getNextElement();
            secondElementToBecomeFirst.setPreviousElement(null);
            this.size--;
            //if there's only one node left after the method's been called, also set the control
            // variable previous element to null
            // so there's nothing to reference to anymore and it's coherent with the tail object
            if(this.size == 1){
                this.previousElement = null;
            }
        }
        return firstElement.getValue();
    }

    public void unshift(T t){
        DoublyLinkedListElement<T> newElement = new DoublyLinkedListElement<>(t);
        //insert the first node if the whole list is empty
        if(this.currentTail == null && this.size==0){
            this.currentTail = newElement;
        }else{
            DoublyLinkedListElement<T> previousElement = this.currentTail.getPreviousElement();
            for(int i=this.size; i>0; i--){
                //only one node scenario
                if(previousElement == null && this.previousElement == null){
                    newElement.setNextElement(this.currentTail);
                    this.previousElement = newElement;
                    this.currentTail.setPreviousElement(newElement);
                //more than one node already exist
                }else{
                    previousElement.setPreviousElement(newElement);
                    newElement.setNextElement(previousElement);
                }
            }
        }
        this.size++;
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
