import java.util.*;

public class Main {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);

        int req = sc.nextInt();

        for (int i = 0; i < req; i++) {
            String command = sc.next();

            if (command.equals("tambah")) {
                String nama = sc.next();
                System.out.println("sudah menambahkan " + nama);
                stack.push(nama);
            }
            else if (command.equals("beli")) {
                if (stack.empty()) {
                    System.out.println("maaf stock habis");
                }
                else {
                    System.out.println("telah membeli " + stack.peek());
                    stack.pop();
                }
            }
            else if (command.equals("lihat")) {
                if (stack.empty()) {
                    System.out.println("maaf stock habis");
                }
                else {
                    System.out.println("print paling atas adalah " + stack.peek());
                }
            }
            else if (command.equals("habis?")) {
                if (stack.empty()) {
                    System.out.println("ya, habis");
                }
                else {
                    System.out.println("masih ada kok");
                }
            }
        }


        sc.close();
        
    }
}