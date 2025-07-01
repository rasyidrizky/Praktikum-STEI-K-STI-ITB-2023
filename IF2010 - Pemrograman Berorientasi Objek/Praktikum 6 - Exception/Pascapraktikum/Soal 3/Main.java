import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            String input = scanner.nextLine();
            Password pw = new Password(input);
            boolean result = pw.validate();
            System.out.println(result);
            System.out.println("Password validated.");
        } catch (InvalidLengthException | InvalidPasswordException e) {
            System.out.println(e.getClass().getSimpleName() + "! " + e.getMessage());
            System.out.println("Password string error!");
        } catch (Exception e) {
            System.out.println(e.getClass().getName());
            System.out.println("Password string error!");
        } finally {
            scanner.close();
            System.out.println("Operation finished.");
        }
    }
}