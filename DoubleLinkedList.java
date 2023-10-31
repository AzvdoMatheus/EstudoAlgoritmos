

public class DoubleLinkedList{

    private Node header;
    private Node trailer;
    private int count;

    public class Node{
        public int element;
        public Node prev;
        public Node next;

        public Node(int element){
            this.element = element;
            prev = null;
            next = null;
        }
    }

    public DoubleLinkedList(){
        header = new Node(0);
        trailer = new Node(0);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    //O(1)
    public void addTail(int element){//adiciona no trailer o elemento
        Node newNode = new Node(element);
        newNode.prev = trailer.prev;
        newNode.next = trailer;
        trailer.prev.next = newNode;
        trailer.prev = newNode;
        count++;
    }

    //O(N)
    public boolean remove(int element){
        Node currNode = header.next;
        for(int i = 0; i < count; i++){
            if(currNode.element == element){
                currNode.prev.next = currNode.next;
                currNode.next.prev = currNode.prev;
                count--;
                return true;
            }
            currNode = currNode.next;
        }
        return false;
    }

    //O(N)
    Node getByIndex(int index){
        Node currNode = null;

        if(index < 0 || index > count){
            throw new IndexOutOfBoundsException(index);
        }
        if(index < (count/2)){
            currNode = header.next;
            for(int i = 0; i < index; i++){
                currNode = currNode.next;
            }
        }else{
            currNode = trailer.prev;
            for(int i = count-1; i > index; i--){
                 currNode = currNode.prev;
            }
        }
        return currNode;
    }

    //O(N)
    public int getElement(int index){
        Node currNode = getByIndex(index);
        return currNode.element;
    }

    //O(N)
    public int setByIndex(int index, int element){
        Node currNode = getByIndex(index);
        int elem = currNode.element;
        currNode.element = element;
        return elem;
        //Node currNode = getByIndex(index).element = element;
    }

    //O(N)
    public void addByIndex(int index, int element){
        if(index < 0 || index > count){
            throw new IndexOutOfBoundsException(index);
        }
        if(index == count){
            addTail(element);
        }else{
            Node newNode = new Node(element);
            Node currNode = getByIndex(index);
            newNode.prev = currNode.prev;
            newNode.next = currNode;
            newNode.prev.next = newNode;
            newNode.next.prev = newNode; 
            count++; 
        }
    }

    //O(N)
    public int removeByIndex(int index){
        Node currNode = getByIndex(index);
        currNode.prev.next = currNode.next;
        currNode.next.prev = currNode.prev;
        count--;
        return currNode.element;
    }

    //O(N)
    public void reverseList(){
        Node currNode = header.next;
        Node trailerNode = trailer.next;
        
        while(currNode != trailerNode && currNode.prev != trailerNode){
            int aux = currNode.element;
            currNode.element = trailerNode.element;
            trailerNode.element = aux;
            currNode = currNode.next;
            trailerNode = trailerNode.prev;
        }
    }
}