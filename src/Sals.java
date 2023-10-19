import java.util.ArrayList;
import java.util.List;

class Sals {
    private int cisloSalu;
    private int pocetRad;
    private int pocetKreselVRade;
    private List<Films> filmy;
    private boolean podpora3D;

    public Sals(int cisloSalu, int pocetRad, int pocetKreselVRade, boolean podpora3D) {
        this.cisloSalu = cisloSalu;
        this.pocetRad = pocetRad;
        this.pocetKreselVRade = pocetKreselVRade;
        this.filmy = new ArrayList<>();
        this.podpora3D = podpora3D;
    }

    public int getCisloSalu() {
        return cisloSalu;
    }

    public int getPocetRad() {
        return pocetRad;
    }

    public int getPocetKreselVRade() {
        return pocetKreselVRade;
    }

    public List<Films> getFilmy() {
        return filmy;
    }

    public boolean isPodpora3D() {
        return podpora3D;
    }

    public void pridatFilm(Films film) {
        filmy.add(film);
    }
}
