import java.util.ArrayList;
import java.util.Scanner;

public class BukanOlympia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> files = new ArrayList<>();
        ArrayList<String> inputs = new ArrayList<>();
        ArrayList<String> outputs = new ArrayList<>();

        String bahasa = sc.nextLine();
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String filename = sc.next();
            files.add(filename);
        }

        Bahasa lang;
        try {
            lang = BahasaFactory.getBahasaRunner(bahasa, files);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        try {
            lang.compile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        int tests = sc.nextInt();

        for (int i = 0; i < tests; i++) {
            String input = sc.next();
            String output = sc.next();

            inputs.add(input);
            outputs.add(output);
        }

        for (int i = 0; i < tests; i++) {
            try {
                lang.grade(inputs.get(i), outputs.get(i));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        sc.close();
    }
}
