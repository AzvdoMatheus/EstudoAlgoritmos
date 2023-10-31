public class ListaArranjo {

    private int count;
    private Integer[] data;
    private final static int initialSize = 5;

    public ListaArranjo() {
        this.count = 0;
        this.data = new Integer[initialSize];
    }

    //O(1)
    public int getSize() {
        return count;
    }

    //O(1)
    public int getElement(int index) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index);
        } else{
            return data[index];
        }
    }

    //0(1)
    public boolean isEmpty() {
        return (count == 0);
    }

    //O(N)
    public void addElement(int e) {
        if (count == data.length){
            setCapacity(data.length * 2);
        }
        data[count] = e;
        count++;
    }

    //O(1)
    public void clearList(){
        for (int i = 0; i < count; i++) {
            data[i] = null;
        }
        data = new Integer[initialSize];
        count = 0;
    }

    //O(1)
    public int set(int index , Integer element){
        if(index < 0 || index >= count){
            throw new IndexOutOfBoundsException(index);
        }else{
            Integer aux = data[index];
            data[index] = element;
            return aux;
        } 
    }

    //O(N)
    public boolean remove(Integer element){
        for(int i = 0; i < count; i++) {
            if (element.equals(data[i])){ 
                for(int j = i; j < count-1; j++) {
                    data[j] = data[j+1];
                }
                data[count-1] = null; 
                count--; 
                return true;
            }
        }
        return false;
    }	

    //O(1)
    public void removeByIndex(int index){
        data[index] = null;
        count--;
    }

    //O(N)
    boolean contains(Integer element){
        for(int i = 0; i < count; i++){
            if(element.equals(data[i])){
                return true;
            }
        }
        return false;
    }

    public int indexOf(Integer element){
        for(int i = 0; i < count; i++){
            if(element.equals(data[i])){
                return i;
            }
        }
        return 0;
    }

    //O(N)
    private void setCapacity(int newCapacity){
        if(newCapacity != data.length) {
            int min = 0;
            Integer[] newData = new Integer[newCapacity];
            if(data.length < newCapacity) {
                min = data.length;
            }else{
                min = newCapacity;
                count = newCapacity;
            }
            for (int i = 0; i < min; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    //O(N)
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
