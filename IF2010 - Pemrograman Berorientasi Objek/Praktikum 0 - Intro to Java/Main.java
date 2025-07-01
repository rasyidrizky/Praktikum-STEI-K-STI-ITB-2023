import java.util.Scanner;

/**
 * Main.java
 * 
 * @author 18223114 Rasyid Rizky Susilo Nurdwiputro
 */

public class Main {
    /**
     * Mengecek apabila kartu memiliki nilai 10, J, Q, K, A
     * 
     * @param cards
     * @return true apabila kartu memiliki 10 sampai As, false sebaliknya
     */
    public static boolean isRoyal(String[] cards) {
        boolean king = false;
        boolean ten = false;
        boolean jack = false;
        boolean queen = false;
        boolean as = false;

        int tempe = 0;
        int keriting = 0;
        int hati = 0;
        int sekop = 0;

        for (int i = 0; i < 5; i++) {
            if (cards[i].charAt(1) == 'K') {
                king = true;
            }
            if (cards[i].charAt(1) == 'T') {
                ten = true;
            }
            if (cards[i].charAt(1) == 'J') {
                jack = true;
            }
            if (cards[i].charAt(1) == 'Q') {
                queen = true;
            }
            if (cards[i].charAt(1) == 'A') {
                as = true;
            }

            if (cards[i].charAt(0) == 'T') {
                tempe++;
            }
            if (cards[i].charAt(0) == 'K') {
                keriting++;
            }
            if (cards[i].charAt(0) == 'H') {
                hati++;
            }
            if (cards[i].charAt(0) == 'S') {
                sekop++;
            }
        }

        if ((king && ten && jack && queen && as) && (tempe == 5 || keriting == 5 || hati == 5 || sekop == 5)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Mengecek apabila kartu dapat membentuk Full House
     * 
     * @param cards
     * @return true apabila kartu dapat membentuk Full House, false sebaliknya
     */
    public static boolean isFullHouse(String[] cards) {
        boolean adaTiga = false;
        boolean adaDua = false;

        int kartu[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < 5; i++) {
            if (cards[i].charAt(1) == 'A') {
                kartu[0]++;
            }
            if (cards[i].charAt(1) == '2') {
                kartu[1]++;
            }
            if (cards[i].charAt(1) == '3') {
                kartu[2]++;
            }
            if (cards[i].charAt(1) == '4') {
                kartu[3]++;
            }
            if (cards[i].charAt(1) == '5') {
                kartu[4]++;
            }
            if (cards[i].charAt(1) == '6') {
                kartu[5]++;
            }
            if (cards[i].charAt(1) == '7') {
                kartu[6]++;
            }
            if (cards[i].charAt(1) == '8') {
                kartu[7]++;
            }
            if (cards[i].charAt(1) == '9') {
                kartu[8]++;
            }
            if (cards[i].charAt(1) == 'T') {
                kartu[9]++;
            }
            if (cards[i].charAt(1) == 'J') {
                kartu[10]++;
            }
            if (cards[i].charAt(1) == 'Q') {
                kartu[11]++;
            }
            if (cards[i].charAt(1) == 'K') {
                kartu[12]++;
            }
        }

        for (int j = 0; j < 13; j++) {
            if (kartu[j] == 3) {
                adaTiga = true;
            } else if (kartu[j] == 2) {
                adaDua = true;
            }
        }

        if (adaTiga && adaDua) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Mengecek apabila kartu dapat membentuk Flush
     * 
     * @param cards
     * @return true apabila kartu dapat membentuk Flush, false sebaliknya
     */
    public static boolean isFlush(String[] cards) {
        int tempe = 0;
        int keriting = 0;
        int hati = 0;
        int sekop = 0;


        for (int i = 0; i < 5; i++) {
            if (cards[i].charAt(0) == 'T') {
                tempe++;
            }
            if (cards[i].charAt(0) == 'K') {
                keriting++;
            }
            if (cards[i].charAt(0) == 'H') {
                hati++;
            }
            if (cards[i].charAt(0) == 'S') {
                sekop++;
            }
        }

        if (tempe == 5 || keriting == 5 || hati == 5 || sekop == 5) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Mengembalikan rangking dari set yang dimiliki dengan rangking berikut:
     * - Royal Flush: 3
     * - Full House: 2
     * - Flush: 1
     * - High Card: 0
     * 
     * @param cards
     * @return rangking
     */
    public static int getSetRanking(String[] cards) {
        int rank = 0;

        if (isRoyal(cards)) {
            rank = 3;
        } else if (isFullHouse(cards)) {
            rank = 2;
        } else if (isFlush(cards)) {
            rank = 1;
        }

        return rank;
    }

    public static void main(String[] args) {
        String[] cardsTuanBil = new String[5];
        String[] cardsTuanMask = new String[5];
        Scanner sc = new Scanner(System.in);
        int bil, mask;

        for (int i = 0; i < 5; i++) {
            cardsTuanBil[i] = sc.next();
        }

        for (int j = 0; j < 5; j++) {
            cardsTuanMask[j] = sc.next();
        }

        bil = getSetRanking(cardsTuanBil);
        mask = getSetRanking(cardsTuanMask);

        if (bil > mask) {
            System.out.println("Tuan Bil");
            System.out.println(bil);
        } else if (mask > bil) {
            System.out.println("Tuan Mask");
            System.out.println(mask);
        } else {
            System.out.println("Seri");
            System.out.println(bil);
        }

    }
}