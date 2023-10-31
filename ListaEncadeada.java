public class ListaEncadeada{
    
    private Node head;
    private Node tail;
    private int count;

    private class Node{
        Integer element;
        Node next;

        public Node(Integer element, Node next){
            this.element = element;
            this.next = next;
        }

        public Node(Integer element){
            this(element, null);
        }
    }

    public ListaEncadeada(){
        this.head = null;
        this.tail = null;
        count = 0;
    }

    //O(N)
    Node getElement(Integer element){
        Node currNode = head;
        while(currNode!= null){
            if(currNode.element.equals(element)){
                return currNode;
            }else{
                currNode = currNode.next;
            }
        }
        return null;
    }

    //O(1)
    void addElement(Integer element){
        Node newNode = new Node(element);

        if(head == null){
            head = newNode;
        }else{
            tail.next = newNode; 
        }
        tail = newNode;
        count++;
    }

    //O(N)
    void removeTail(){
        if(head == null){
            return;
        }else{
            if(head.next == null){
                head = null;
            }
        }
        Node currNode = head;
        while(currNode.next != tail){
            currNode = currNode.next;
            tail = currNode;
            count--;
            tail.next = null;
        }
    }

    //O(N)
    public int getIndex(int index){
            if(index < 0 || index >= count){
                throw new IndexOutOfBoundsException(index);
            }
            if(index == count - 1)//Se for igual ao ultimo elemento
                return tail.element;

            Node currNode = head;
            for(int i = 0; i < index; i++){
                currNode = currNode.next;
            }
            return currNode.element;
        }

    //0(N)
    public boolean removeElement(int e){
        if(count == 0){//Lista vazia
            return false;
        }

        if(e == head.element){//Se elemento == head
            head.next = head;
            count--;
            if(count == 1){//Lista tem apenas 1 elemento
                tail = null;
            }
            return true;
        }

        Node currNode = head.next;//Aponta para o proximo elemento do head
        Node prevNode = head;//Aponta para o head
        for(int i = 1; i < count; i++){
            if(e == currNode.element){
                if(currNode == tail){
                    tail = prevNode;
                    tail.next = null;
                }else{
                    prevNode.next = currNode.next;
                }
                count--;
                return true;
            }
            prevNode = prevNode.next;
            currNode = currNode.next;
        }
        return false;
    }

    //O(N)
    public int setByIndex(int index, int element){
        if(index < 0 || index >= count){
            throw new IndexOutOfBoundsException(index);
        }
        int auxElement = 0;
        if(index == count - 1){
            auxElement = tail.element;
            tail.element = element;
            return auxElement;
        }

        Node currNode = head;
        for(int i = 0; i < index; i++){
            currNode = currNode.next;
        }
        auxElement = currNode.element;
        currNode.element = element;
        return auxElement;
    }

    //O(N)
    public void addElementIndex(int index, int element){
        if(index < 0 || index >= count){
            throw new IndexOutOfBoundsException(index);
        }
        
        Node n = new Node(element);
        if(index == 0){//Lista vazia
            tail = n;
        }else{
            n.next = head;
        }
        head = n;
        if(index == count){
            tail.next = n;
            tail = n;
        }else{
            Node prevNode = head;
            for(int i = 0; i < index-1; i++){
                prevNode = prevNode.next;
            }
            n.next = prevNode.next;
            prevNode.next = n;
        }
        count++;
    }    
}

