import java.util.Scanner;

public class MainBalala {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Kartu[] stack = new Kartu[5];

        for (int i = 0; i < 5; i++) {
            String suit = sc.next();
            String rank = sc.next();
            int multi = sc.nextInt();
            sc.nextLine();
            stack[i] = new Kartu(suit, rank, multi);
        }

        int joker = sc.nextInt();
        int target = sc.nextInt();

        sc.close();

        Blind blind = new Blind(stack[0], stack[1], stack[2], stack[3], stack[4], joker, target);

        String[] urutan = {"pertama", "kedua", "ketiga", "keempat", "kelima"};
        for (int i = 0; i < 5; i++) {
            System.out.println("Kartu " + urutan[i] + " punya suit " + stack[i].getSuit() + " dengan rank " + stack[i].getRank() + " dan multiplier " + stack[i].getMultiplier());
        }
        
        int totalScore = blind.calculateTotalScore();
        System.out.println("Skor akhir : " + totalScore);
        
        if (blind.isWin()) {
            System.out.println("MENANG!");
        } else {
            System.out.println("KALAH!");
        }
    }
}
