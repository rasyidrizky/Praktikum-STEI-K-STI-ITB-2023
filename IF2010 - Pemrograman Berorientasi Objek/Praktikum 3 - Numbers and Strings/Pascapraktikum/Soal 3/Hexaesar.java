/**
 * Hexaesar
 * 
 * Implementasikan algoritma Hexaesar sesuai dengan deskripsi pada soal.
 */
public class Hexaesar {
    /**
     * Fungsi untuk mengenkripsi plaintext berupa string hexadesimal dengan kunci tertentu.
     * 
     * Contoh:
     * plaintext = "12a"
     * key = 1
     * keluaran = "23b"
     */
    public static String encrypt(String plaintext, int key) {
        // IMPLEMENTASI DISINI
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            int value;
            
            if (c >= '0' && c <= '9') {
                value = c - '0';
            } else if (c >= 'a' && c <= 'f') {
                value = c - 'a' + 10;
            } else if (c >= 'A' && c <= 'F') {
                value = c - 'A' + 10;
            } else {
                result.append(c);
                continue;
            }
            
            value = (value + key) % 16;
            
            if (value < 10) {
                result.append((char) (value + '0'));
            } else {
                result.append((char) (value - 10 + 'a'));
            }
        }
        
        return result.toString();
    }

    /**
     * Fungsi untuk mendekripsi ciphertext berupa string hexadesimal dengan kunci tertentu.
     * 
     * Contoh:
     * ciphertext = "23b"
     * key = 1
     * keluaran = "12a"
     */
    public static String decrypt(String encrypted, int key) {
        // IMPLEMENTASI DISINI
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < encrypted.length(); i++) {
            char c = encrypted.charAt(i);
            int value;
            
            if (c >= '0' && c <= '9') {
                value = c - '0';
            } else if (c >= 'a' && c <= 'f') {
                value = c - 'a' + 10;
            } else if (c >= 'A' && c <= 'F') {
                value = c - 'A' + 10;
            } else {
                result.append(c);
                continue;
            }
            
            value = (value - key) % 16;
            if (value < 0) {
                value += 16;
            }
            
            if (value < 10) {
                result.append((char) (value + '0'));
            } else {
                result.append((char) (value - 10 + 'a'));
            }
        }
        
        return result.toString();
    }

    /**
     * Fungsi untuk mengenkripsi plaintext berupa bilangan bulat dengan kunci tertentu.
     * 
     * Contoh:
     * plaintext = 10
     * key = 1
     * keluaran = 11
     */
    public static int encrypt(int plaintext, int key) {
        // IMPLEMENTASI DISINI
        String hexValue = HexCalculator.toHex(plaintext);
        
        String encryptedHex = encrypt(hexValue, key);
        
        return HexCalculator.toDecimal(encryptedHex);
    }

    /**
     * Fungsi untuk mendekripsi ciphertext berupa bilangan bulat dengan kunci tertentu.
     * 
     * Contoh:
     * ciphertext = 11
     * key = 1
     * keluaran = 10
     */
    public static int decrypt(int encrypted, int key) {
        // IMPLEMENTASI DISINI
        String hexValue = HexCalculator.toHex(encrypted);
        
        String decryptedHex = decrypt(hexValue, key);
        
        return HexCalculator.toDecimal(decryptedHex);
    }
}
