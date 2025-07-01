/**
 * TungTungTungSahur.java
 * Mendefinisikan kelas TungTungTungSahur dengan mengeksekusi command
 * 
 * @author 18223114 Rasyid Rizky Susilo Nurdwiputro
 */

import java.util.ArrayList;
import java.util.List;

public class TungTungTungSahur {
    private List<ICommandAction> recipeSteps = new ArrayList<>();
    private List<ICommandAction> completedSteps = new ArrayList<>();
    
    /**
     * Menambahkan langkah baru ke dalam daftar langkah-langkah memasak
     * 
     * @param action Langkah memasak (Command) yang akan ditambahkan
     */
    public void addStep(ICommandAction action) {
        recipeSteps.add(action);
    }
    
    /**
     * Melaksanakan langkah memasak berikutnya dari daftar
     * Setelah dieksekusi, langkah tersebut dipindahkan dari recipeSteps ke
     * completedSteps untuk memungkinkan proses pembatalan
     * 
     * Keluarkan "No cooking steps remaining" apabila tidak ada elemen
     * pada recipeSteps
     */
    public void cook() {
        if (recipeSteps.size() == 0) {
            System.out.println("No cooking steps remaining");
        }
        else {
            ICommandAction last = recipeSteps.get(0);
            last.execute();
            recipeSteps.remove(0);
            completedSteps.add(last);
        }
    }
    
    /**
     * Membatalkan langkah memasak terakhir yang telah dilaksanakan
     * Langkah tersebut dipindahkan kembali dari completedSteps ke awal
     * recipeSteps untuk dapat dijalankan kembali jika diinginkan
     * 
     * Keluarkan "No cooking steps to cancel" apabila tidak ada elemen
     * pada completedSteps
     */
    public void cancel() {
        if (completedSteps.size() == 0) {
            System.out.println("No cooking steps to cancel");
        }
        else {
            ICommandAction last = completedSteps.get(completedSteps.size()-1);
            last.undo();
            completedSteps.remove(completedSteps.size()-1);
            recipeSteps.add(0, last);
        }
    }
    
    /**
     * Melaksanakan semua langkah memasak secara berurutan
     * Metode ini mengeksekusi semua langkah yang tersisa dalam daftar recipeSteps
     */
    public void cookAll() {
        while (!recipeSteps.isEmpty()) {
            cook();
        }
    }
    
    /**
     * Membatalkan semua langkah memasak yang telah dilaksanakan
     * Metode ini membatalkan semua langkah dalam daftar completedSteps, dalam
     * urutan terbalik (LIFO - Last In First Out)
     */
    public void cancelAll() {
        while (!completedSteps.isEmpty()) {
            cancel();
        }
    }
}