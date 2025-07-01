import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int a1, a2, a3, a4, a5;
        int multiplier;
        int booster;

        a1 = sc.nextInt();
        a2 = sc.nextInt();
        a3 = sc.nextInt();
        a4 = sc.nextInt();
        a5 = sc.nextInt();

        multiplier = sc.nextInt();
        booster = sc.nextInt();

        if (booster == 1) {
            System.out.println((a1+a2+a3+a4+a5) * (multiplier * 2));
        } else if (booster == 2) {
            System.out.println((a1+a2+a3+a4+a5) * (multiplier * 3));
        } else {
            System.out.println((a1+a2+a3+a4+a5) * (multiplier));
        }
    }
}