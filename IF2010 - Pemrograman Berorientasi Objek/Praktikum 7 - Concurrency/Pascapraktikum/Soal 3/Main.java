public class Main {
    public static void main(String[] args) {
        GuildAccount account = new GuildAccount(10000);

        Adventurer dar = new Adventurer("Dar");
        Adventurer bil = new Adventurer("Bil");
        Adventurer lia = new Adventurer("Lia");

        // Dar menyetor 2000 gold dan menarik 1500 gold
        Thread thread1 = new Thread(() -> {
            try {
                account.deposit(dar, 2000);
                account.withdraw(dar, 1500, "Armor");
            } catch (FailedTransactionException e) {
                // ignore
            }
        });
        
        // Bil menarik 3000 gold untuk senjata
        Thread thread2 = new Thread(() -> {
            try {
                account.withdraw(bil, 3000, "Sword");
            } catch (FailedTransactionException e) {
                // ignore
            }

        });
        
        // Lia menyetor 500 gold dan menarik 2000 gold
        Thread thread3 = new Thread(() -> {
            try {
                account.deposit(lia, 500);
                account.withdraw(lia, 2000, "Shield");
            } catch (FailedTransactionException e) {
                // ignore
            }
        });
        
        thread1.start();
        thread2.start();
        thread3.start();
        
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Final balance: " + account.getBalance());
        System.out.println("Log:");
        System.out.println(account.getLog());
    }
}
