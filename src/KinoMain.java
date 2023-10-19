import java.util.Scanner;

public class KinoMain {
    public static void main(String[] args) {
        KinoRezervace kino = new KinoRezervace();

        // Vytvoření filmů
        Films film1 = new Films("Mamma Mia", "PG-11", "Téra", true);
        Films film2 = new Films("Barbie", "PG", "Terezka", false);
        Films film3 = new Films("Avengers", "O", "Terina", true);

        kino.pridatFilm(film1);
        kino.pridatFilm(film2);
        kino.pridatFilm(film3);

        // Vytvoření sálů
        Sals sala1 = new Sals(1, 10, 15, true);
        Sals sala2 = new Sals(2, 8, 12, false);

        sala1.pridatFilm(film1);
        sala1.pridatFilm(film2);
        sala2.pridatFilm(film2);
        sala2.pridatFilm(film3);

        kino.pridatSala(sala1);
        kino.pridatSala(sala2);

        // Uživatel zobrazí dostupné filmy
        System.out.println("Dostupné filmy:");
        for (Films film : kino.getDostupneFilmy()) {
            System.out.println(film.getNazev());
        }

        // Uživatel vybere film
        Scanner scanner = new Scanner(System.in);
        System.out.print("Vyberte film podle názvu: ");
        String vybranyFilm = scanner.nextLine();

        Films vybranyFilmObj = null;
        for (Films film : kino.getDostupneFilmy()) {
            if (film.getNazev().equals(vybranyFilm)) {
                vybranyFilmObj = film;
                break;
            }
        }

        if (vybranyFilmObj == null) {
            System.out.println("Vybraný film není k dispozici.");
            return;
        }

        // Zobrazit sály, ze kterých si uživatel může vybrat
        System.out.println("Dostupné sály pro film " + vybranyFilmObj.getNazev() + ":");
        for (Sals sala : kino.getDostupneSaly()) {
            if (sala.getFilmy().contains(vybranyFilmObj)) {
                System.out.println("Sál " + sala.getCisloSalu());
            }
        }

        // Uživatel vybere sál
        System.out.print("Vyberte sál podle čísla: ");
        int vybranySaly = scanner.nextInt();

        Sals vybranySalyObj = null;
        for (Sals sala : kino.getDostupneSaly()) {
            if (sala.getCisloSalu() == vybranySaly) {
                vybranySalyObj = sala;
                break;
            }
        }

        if (vybranySalyObj == null) {
            System.out.println("Vybraný sál není k dispozici.");
            return;
        }

        // Vykreslit rozložení křesel
        System.out.println("Rozložení křesel pro sál " + vybranySalyObj.getCisloSalu() + ":");
        for (int rada = 1; rada <= vybranySalyObj.getPocetRad(); rada++) {
            for (int kreslo = 1; kreslo <= vybranySalyObj.getPocetKreselVRade(); kreslo++) {
                System.out.print((char) (64 + rada) + "-" + kreslo + " ");
            }
            System.out.println();
        }

        // Uživatel vybere křeslo
        System.out.print("Vyberte křeslo (např. A-1): ");
        String vybraneKreslo = scanner.next();

        try {
            boolean rezervaceUspesna = kino.rezervovatFilm(vybranyFilmObj, vybranySalyObj, vybraneKreslo);
            if (rezervaceUspesna) {
                System.out.println("Rezervace dokončena pro film " + vybranyFilmObj.getNazev() +
                        " v sále " + vybranySalyObj.getCisloSalu() +
                        " na křeslo " + vybraneKreslo + ".");
            }
        } catch (NevhodnyVyberFilmuException | NevhodnyVyberSaluException | NevhodnyVyberKreslaException e) {
            System.out.println("Chyba při rezervaci: " + e.getMessage());
        }
    }
}