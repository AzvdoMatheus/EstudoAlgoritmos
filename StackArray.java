import java.util.EmptyStackException;

public class StackArray {

    private int data[];
    private int count;

    public StackArray(int size){
        if(size > 0){
            data = new int[size];
        }
        count = 0;
    }

    /*
     * @param element insere elemento no topo da pilha
     */
    public void push(int element){
        if(count == data.length){
            throw new IllegalArgumentException();
        }
        data[count] = element;
        count++;
    }

    /*
     * remove e retorna o topo da pilha
     */
    public int pop(){
        if(count == 0){
            throw new EmptyStackException();
        }
        int aux = data[count-1];
        data[count-1] = null;
        count--;
        return aux;
    }

    /*
     * retorna o elemento do topo da pilha, mas nao o remove
     */
    public int top(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return data[count-1];
    }

    /*
     * retorna tamanho da pilha
     */
    public int size(){
        return count;
    }

    /*
     * retorna true se a lista estivar vazia(count == 0)
     */
    public boolean isEmpty(){
        return count == 0;
    }

    /*
     * esvazia a pilha e cria uma nova com 10 posicoes
     */
    public void clear(){
        data = new int[10];
        count = 0;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < count; i++) {
            s.append(data[i]);
            if (i != (count - 1)) {
                s.append(",");
            }
        }
        return s.toString();
    }
}




