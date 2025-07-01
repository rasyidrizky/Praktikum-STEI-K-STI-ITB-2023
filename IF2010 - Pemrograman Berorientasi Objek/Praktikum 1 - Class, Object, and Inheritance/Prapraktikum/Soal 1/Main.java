import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CimolBojot[] cb = new CimolBojot[3];

        for (int i = 0; i < 3; i++) {
            String nama = sc.next();
            int harga = sc.nextInt();
            int stok = sc.nextInt();
            cb[i] = new CimolBojot(nama, harga, stok);
        }

        int kas = sc.nextInt();
        Toko tk = new Toko(kas);

        for (CimolBojot cimol : cb) {
            tk.addCimolBojot(cimol);
        }

        String req = sc.next();
        int qreq = sc.nextInt();

        System.out.println(tk.sellCimolBojot(req, qreq));
        System.out.println("Kas kasir sekarang: " + tk.getKas());

        sc.close();
    }
}
