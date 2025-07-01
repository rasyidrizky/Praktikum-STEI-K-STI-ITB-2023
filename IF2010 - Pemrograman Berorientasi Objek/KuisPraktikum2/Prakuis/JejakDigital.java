import java.util.*;

public class JejakDigital<A> {
    private static class ItemJejakDigital<T> {
        private final int id;
        private final T activity;

        public ItemJejakDigital(int id, T activity) {
            this.id = id;
            this.activity = activity;
        }

        public int id() { // Getter untuk ID
            return id;
        }

        public T activity() { // Getter untuk activity
            return activity;
        }
    }

    private final int maxSize;
    private LinkedList<ItemJejakDigital<A>> listActivities; // List untuk menyimpan Item
    private int nextId = 0; // counter untuk ID aktivitas berikutnya

    /**
     * Konstruktor untuk JejakDigital
     * @param maxSize jumlah maksimal jejak digital yang bisa disimpan di suatu feed (list)
     * TC input maxSize dipastikan selalu angka positif, jadi tidak perlu handle untuk yang nonpositif.
     */
    public JejakDigital(int maxSize) {
        this.maxSize = maxSize;
        this.listActivities = new LinkedList<>();
    }

   /**
     * Nambahin jejak (aktivitas) baru ke feed.
     * Jejak baru ini bakal dapet ID unik yang terus nambah,
     * dan jadi yang paling baru (ditaruh di paling depan list).
     * Kalo nambahin ini bikin feed kepenuhan (lebih dari maxSize),
     * jejak digital yang paling lama (di paling belakang list) bakal dihapus.
     * @param dataJejakDigital aktivitas yang mau ditambahin ke feed
     */
    public void addActivity(A dataJejakDigital) {
        if (listActivities.size() == maxSize) {
            listActivities.removeFirst();
        }
        listActivities.addLast(new ItemJejakDigital<A>(nextId, dataJejakDigital));
        nextId++;
    }

    /**
     * Ngasih list string yang udah diformat jadi "[ID] - Aktivitas" (pake []-nya yah),
     * diurutin dari jejak PALING BARU ke PALING LAMA.
     * Cocok buat ditampilin langsung ke user. (usernya adalah grader olympia)
     *
     * @return List of String yang udah rapi dan siap tampil.
     */
    public List<String> recentToOldestJejakDigital() {
        List<String> activites = new ArrayList<>();
        List<ItemJejakDigital<A>> reversed = new ArrayList<>(listActivities);
        Collections.reverse(reversed); // reverse the order

        for (ItemJejakDigital<A> item : reversed) {
            activites.add("[" + item.id() + "] - " + item.activity());
        }

        return activites;
    }

    /**
     * Ngasih list string yang udah diformat jadi "[ID] - Aktivitas" (pake []-nya yah),
     * diurutin dari jejak PALING LAMA ke PALING BARU.
     * Cocok buat ditampilin langsung ke user. (usernya adalah grader olympia)
     *
     * @return List of String yang udah rapi dan siap tampil.
     */
    public List<String> oldestToRecentJejakDigital() {
        List<String> activites = new ArrayList<>();
        for (ItemJejakDigital<A> i : listActivities) {
            activites.add("[" + i.id() + "] - " + i.activity());
        }
        return activites;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getCurrentSize() {
        return listActivities.size();
    }

    public List<A> getActivities() {
        List<A> activities = new ArrayList<>();
        for (ItemJejakDigital<A> item : listActivities) {
            activities.add(item.activity());
        }
        return activities;
    }
}