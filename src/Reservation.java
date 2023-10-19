import java.util.ArrayList;
import java.util.List;

class KinoRezervace {
    private List<Films> filmy;
    private List<Sals> saly;

    public KinoRezervace() {
        filmy = new ArrayList<>();
        saly = new ArrayList<>();
    }

    public void pridatFilm(Films film) {
        filmy.add(film);
    }

    public void pridatSala(Sals sala) {
        saly.add(sala);
    }

    public List<Films> getDostupneFilmy() {
        return filmy;
    }

    public List<Sals> getDostupneSaly() {
        return saly;
    }

    public boolean rezervovatFilm(Films film, Sals sala, String kreslo) {
        if (!filmy.contains(film)) {
            throw new NevhodnyVyberFilmuException("Film není k dispozici.");
        }

        if (!saly.contains(sala) || !sala.getFilmy().contains(film)) {
            throw new NevhodnyVyberSaluException("Sál není k dispozici pro tento film.");
        }

        if (!jePlatneKreslo(sala, kreslo)) {
            throw new NevhodnyVyberKreslaException("Křeslo není k dispozici.");
        }

        // Zde by bylo vhodné označit křeslo jako rezervované

        return true;
    }

    private boolean jePlatneKreslo(Sals sala, String kreslo) {
        char rada = kreslo.charAt(0);
        int cisloKresla = Integer.parseInt(kreslo.substring(2));

        return rada >= 'A' && rada <= (char) ('A' + sala.getPocetRad() - 1) &&
                cisloKresla >= 1 && cisloKresla <= sala.getPocetKreselVRade();
    }
}

class NevhodnyVyberFilmuException extends RuntimeException {
    public NevhodnyVyberFilmuException(String message) {
        super(message);
    }
}

class NevhodnyVyberSaluException extends RuntimeException {
    public NevhodnyVyberSaluException(String message) {
        super(message);
    }
}

class NevhodnyVyberKreslaException extends RuntimeException {
    public NevhodnyVyberKreslaException(String message) {
        super(message);
    }
}