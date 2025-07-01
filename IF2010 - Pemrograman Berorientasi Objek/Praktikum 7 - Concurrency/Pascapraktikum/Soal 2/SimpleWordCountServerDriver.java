/* Untuk mengaktifkan assertion, jalankan driver dengan flag -ea
   Contoh:
   $ javac SimpleWordCountServer.java SimpleWordCountServerDriver.java
   $ java -ea SimpleWordCountServerDriver
 */
public class SimpleWordCountServerDriver {
   public static void main(String[] args) throws InterruptedException {
      int nWorkers = 3;
      String[] req = { "skibidi sigma", "ayo nonton anime", "saya cinta OOP",
            "semangat ya praktikan tercinta" };
      int nRequest = req.length;
      SimpleWordCountServer server = new SimpleWordCountServer(nWorkers);

      Integer[] expectedWordCounts = { 2, 3, 3, 4 };
      Integer[] actualWordCounts = server.processRequests(req);

      for (int i = 0; i < expectedWordCounts.length; i++) {
         assert (expectedWordCounts[i].equals(actualWordCounts[i])) == true;
      }
      System.out.println("Yayy programnya gak error! :D");
   }
}
