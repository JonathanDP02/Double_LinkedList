package dll07;

import java.util.Scanner;

public class DLLmain07 {
    
    public static mahasiswa07 inputMahasiswa(Scanner scan) {
    System.out.print("Masukkan NIM: ");
    String nim = scan.nextLine();
    System.out.print("Masukkan Nama: ");
    String nama = scan.nextLine();
    System.out.print("Masukkan Kelas: ");
    String kelas = scan.nextLine();
    System.out.print("Masukkan IPK: ");
    double ipk = scan.nextDouble();
    scan.nextLine(); // konsumsi newline
    return new mahasiswa07(nim, nama, kelas, ipk);
}

    public static void main(String[] args) {
        doubleLinkedList07 list = new doubleLinkedList07();
        Scanner scan = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\nMenu Double Linked LIst Mahasiswa");
            System.out.println("1. Tambah di awal");
            System.out.println("2. Tambah di akhir");
            System.out.println("3. Hapus di awal");
            System.out.println("4. Hapus di akhir");
            System.out.println("5. Tampilkan data");
            System.out.println("6. Cari Mahasiswa berdasarkan NIM");
            System.out.println("7. Sisipkan NIM di tengah-tengah");
            System.out.println("8. Tambah pada indeks tertentu");
            System.out.println("9. Hapus node setelah NIM tertentu");
            System.out.println("10. Hapus node pada indeks tertentu");
            System.out.println("11. Tampilkan data pertama (head)");
            System.out.println("12. Tampilkan data terakhir (tail)");
            System.out.println("13. Tampilkan data pada indeks tertentu");
            System.out.println("14. Tampilkan jumlah data");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scan.nextInt();
            scan.nextLine();

            switch (pilihan) {
                case 1:{
                    mahasiswa07 mhs = inputMahasiswa(scan);
                    list.addFirst(mhs);
                }
                    break;

                case 2:{
                    mahasiswa07 mhs = inputMahasiswa(scan);
                    list.addLast(mhs);
                }
                    break;

                case 3:
                    list.removeFirst();
                    break;
                case 4: 
                    list.removeLast();
                    break;
                case 5:
                    list.print();
                    break;
                case 6: {
                    System.out.print("Masukkan NIM yang dicari: ");
                    String nim = scan.nextLine();
                    node07 found = list.search(nim);
                    if (found != null){
                        System.out.println("Data ditemukan:");
                        found.data.tampil();
                    }else{
                        System.out.println("Data tidak ditemukan.");
                    }
                }

                    break;
                case 7: {
                    System.out.print("Masukkan NIM yang akan disisipkan ditengah-tengah : ");
                    String keyNim = scan.nextLine();
                    mahasiswa07 mhs = inputMahasiswa(scan);
                    list.insertAfter(keyNim, mhs);
                }
                    break;

                case 8:{
                    System.out.print("Masukkan indeks: ");
                    int index = scan.nextInt();
                    scan.nextLine();

                    mahasiswa07 mhs = inputMahasiswa(scan);
                    list.add(index, mhs);
                }
                    break;

                case 9:{
                    System.out.print("Masukkan NIM yang menjadi acuan: ");
                    String nim = scan.nextLine();
                    list.removeAfter(nim);
                }
                    break;

                case 10:{
                    System.out.print("Masukkan indeks yang ingin dihapus: ");
                    int index = scan.nextInt();
                    scan.nextLine();
                    list.remove(index);
                }
                    break;

                case 11:
                    list.getFirst();
                    break;

                case 12:
                    list.getLast();
                    break;

                case 13:{
                    System.out.print("Masukkan indeks: ");
                    int index = scan.nextInt();
                    scan.nextLine();
                    list.getIndex(index);
                }
                    break;

                case 14:
                    System.out.println("Jumlah data: " + list.getSize());
                    break;

                case 0:
                    System.out.println("Keluar dari program.");
                    break;
            
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        }while (pilihan != 0);
        scan.close();
            
        
    }
}
