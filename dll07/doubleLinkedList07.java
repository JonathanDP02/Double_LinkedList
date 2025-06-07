package dll07;

public class doubleLinkedList07 {
    node07 head;
    node07 tail;
    int size;

    public doubleLinkedList07(){
        head = null;
        tail = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void addFirst(mahasiswa07 data){
        node07 newNode = new node07(data);
        if (isEmpty()){
            head = tail = newNode;
        }else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addLast(mahasiswa07 data){
        node07 newNode = new node07(data);
        if(isEmpty()){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void insertAfter(String keyNim, mahasiswa07 data){
        node07 current = head;

        while (current != null && !current.data.nim.equals(keyNim)){
            current = current.next;
        }

        if(current == null){
            System.out.println("Node dengan NIM " + keyNim + "tidak ditemukan.");
            return;
        }

        node07 newNode = new node07(data);

        if (current == tail){
            current.next = newNode;
            newNode.prev = current;
            tail = newNode;
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }

        System.out.println("Node berhasil disisipkan setelah NIM " + keyNim);
    }

    public void print() {
    if (isEmpty()) {
        System.out.println("List kosong.");
        return;
    }
    node07 current = head;
    while (current != null) {
        current.data.tampil();
        current = current.next;
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("List kosong. Tidak ada data yang dapat dihapus.");
            return;
        }
    
        mahasiswa07 removedData = head.data;

        if (head == tail) { // hanya satu node
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        System.out.println("Data sudah berhasil dihapus.");
        System.out.print("Data yang terhapus adalah: ");
        removedData.tampil();
    }


    public void removeLast() {
        if (isEmpty()) {
            System.out.println("List kosong. Tidak ada data yang dapat dihapus.");
            return;
        }

        mahasiswa07 removedData = tail.data;

        if (head == tail) { // hanya satu node
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        System.out.println("Data sudah berhasil dihapus.");
        System.out.print("Data yang terhapus adalah: ");
        removedData.tampil();
    }


    public node07 search(String nim) {
        node07 current = head;
        while (current != null) {
            if (current.data.nim.equalsIgnoreCase(nim)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void add(int index, mahasiswa07 data){
        if (index < 0 || index > size){
            System.out.println("index tidak valid");
            return;
        }

        if (index == 0){
            addFirst(data);
        }else if (index == size){
            addLast(data);
        }else{
            node07 current = head;
            for (int i = 0; i < index -1; i++){
                current = current.next;
            }
            node07 newNode = new node07(data);
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
            size++;
        }
    }

    public void removeAfter(String keyNim){
        node07 current = head;
        while(current != null && !current.data.nim.equals(keyNim)){
            current = current.next;
        }

        if(current == null || current.next == null){
            System.out.println("Node setelah key tidak ditemukan");
            return;
        }

        mahasiswa07 removeData = current.next.data;
        if(current.next == tail){
            tail = current;
            current.next = null;
        }else{
            current.next = current.next.next;
            current.next.prev = current;
        }

        size--;
        System.out.println("Node setelah NIM " + keyNim + " berhasil dihapus.");
        System.out.print("Data yang terhapus adalah: ");
        removeData.tampil();
    }

    public void remove(int index){
        if (index < 0 || index >= size){
            System.out.println("Index tidak valid");
            return;
        }

        if (index == 0){
            removeFirst();
        }else if(index == size -1){
            removeLast();
        }else{
            node07 current = head;
            for (int i = 0; i < index; i++){
                current = current.next;
            }
            mahasiswa07 removeData = current.data;
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
            System.out.println("Data sudah berhasil dihapus pada index " + index);
            System.out.print("Data yang terhapus adalah: ");
            removeData.tampil();
        }
    }

    public void getFirst(){
        if (!isEmpty()){
            System.out.println("Data pertama: ");
            head.data.tampil();
        }else{
            System.out.println("List kosong");
        }
    }

    public void getLast(){
        if (!isEmpty()){
            System.out.println("Data terakhir: ");
            tail.data.tampil();
        }else{
            System.out.println("List kosong");
        }
    }

    public void getIndex(int index){
        if (index < 0 || index >= size){
            System.out.println("Index tidak valid");
            return;
        }

        node07 current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        System.out.println("Data pada index " + index + " : ");
        current.data.tampil();
    }

    public int getSize(){
        return size;
    }

}
