package Prapraktikum;
/**
 * DelayedOutput.java 
 * DelayedOutput adalah sebuah kelas yang mengeluarkan string setelah delay dalam milidetik
 * @author 18223114 Rasyid Rizky Susilo Nurdwiputro
 */
public class DelayedOutput {
  public static void printDelayed(int delayMillisec, String output) {
      // TODO print output setelah di delay selama delayMillisec
      // PENTING: gunakan threading agar tidak blocking
      Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(delayMillisec);
                    System.out.println(output);
                } 
                
                catch (InterruptedException e) {
                }
            }
      });
      thread.start();
  }
}