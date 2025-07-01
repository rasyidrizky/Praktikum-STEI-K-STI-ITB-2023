/**
 * DagingCommand.java
 * Mendefinisikan kelas DagingCommand dengan memanfaatkan objek Daging
 * 
 * @author 18223114 Rasyid Rizky Susilo Nurdwiputro
 */

public class DagingCommand implements ICommandAction {
    private Daging daging;
    
    /**
     * Konstruktor untuk membuat command baru dengan objek Daging tertentu
     * 
     * @param daging Objek Daging yang akan dikontrol oleh command ini
     */
    public DagingCommand(Daging daging) {
        this.daging = daging;
    }

    /**
     * Mengeksekusi perintah dengan memanggil metode cutMeat() dan marinate()
     * secara berturut-turut pada objek Daging
     */
    @Override
    public void execute() {
        daging.cutMeat();
        daging.marinate();
    }

    /**
     * Membatalkan perintah dengan memanggil metode cancelMarination() pada
     * objek Daging
     */
    @Override
    public void undo() {
        daging.cancelMarination();
    }
}