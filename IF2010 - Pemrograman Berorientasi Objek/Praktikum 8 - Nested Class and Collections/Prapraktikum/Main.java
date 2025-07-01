import java.util.*;

public class Main {
    public static void main(String[] args) {
        int nOps;
        
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> t = new TreeSet<Integer>();
        
        nOps = sc.nextInt();

        for (int i = 0; i < nOps; i++) {
            String command = sc.next();

            if (command.equals("add")) {
                int num = sc.nextInt();
                t.add(num);
            }

            else if (command.equals("remove")) {
                int num = sc.nextInt();
                if (t.contains(num)) {
                    t.remove(num);
                }
                else {
                    System.out.println("Element " + num + " is not in The TreeSet");
                }
            }

            else if (command.equals("first")) {
                if (t.isEmpty()) {
                    System.out.println("EMPTY");
                }
                else {
                    System.out.println(t.first());
                }
            }

            else if (command.equals("last")) {
                if (t.isEmpty()) {
                    System.out.println("EMPTY");
                }
                else {
                    System.out.println(t.last());
                }
            }
        }

        sc.close();
    }
}
