import java.util.Scanner;

public class Main {
    /**
     * Fungsi utama dari program kalkulator Hexaesar.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mode = scanner.nextInt();
        
        // LANJUTKAN IMPLEMENTASI DARI MAIN PROGRAM DISINI
        switch (mode) {
            case 1: 
                // Enkripsi String Hex
                String plaintext = scanner.next();
                int key = scanner.nextInt();
                System.out.println(Hexaesar.encrypt(plaintext, key));
                break;
                
            case 2: 
                // Dekripsi String Hex
                String ciphertext = scanner.next();
                key = scanner.nextInt();
                System.out.println(Hexaesar.decrypt(ciphertext, key));
                break;
                
            case 3: 
                // Enkripsi Integer
                int plaintextInt = scanner.nextInt();
                key = scanner.nextInt();
                System.out.println(Hexaesar.encrypt(plaintextInt, key));
                break;
                
            case 4:
                // Dekripsi Integer
                int ciphertextInt = scanner.nextInt();
                key = scanner.nextInt();
                System.out.println(Hexaesar.decrypt(ciphertextInt, key));
                break;
                
            default:
                System.out.println("Invalid mode. Please enter a number between 1 and 4.");
                break;
        }

        scanner.close();
    }
}