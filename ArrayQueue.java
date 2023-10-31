public class ArrayQueue {

    private int data[];
    private int count;
    int head;

    public ArrayQueue(int tam) {
        data = new int[tam];
        count = 0;
        head = 0;
    }

    public void enqueue(int element) {
        if(count == data.length) {
            throw new IndexOutOfBoundsException();
        }
        data[count] = element;
        count++;
    }

    public int dequeue() {
        if(count == 0) {
            throw new IndexOutOfBoundsException();
        }
        
        int aux = data[head];
        head = (head + 1) % data.length; // Avançar a cabeça para o próximo índice circularmente
        count--;
        
        return aux;
    }
    


}