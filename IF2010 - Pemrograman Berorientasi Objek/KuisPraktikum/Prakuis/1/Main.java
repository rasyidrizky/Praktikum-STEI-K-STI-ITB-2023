public class Main {
    public static void main(String[] args) {
        SwordSaint player = new SwordSaint("napkat");
        Witch dawg = new Witch("Orpheus", 100, "Lost Soul");
        Subaru subaru = new Subaru();
        Penyihir apel = new Penyihir("Apel", 100);
        Swordman hikari = new Swordman("Hikari", "Sword of Kyu");

        player.perkenalan();
        player.tebas();

        dawg.perkenalan();
        dawg.gunakanSihir(60);
        dawg.mengisiMana(1000);

        subaru.perkenalan();
        subaru.mati();
        subaru.mati("Jatos");

        apel.perkenalan();
        apel.gunakanSihir(60);
        apel.mengisiMana(1000);

        hikari.perkenalan();
        hikari.tebas();
    }
}