class Films {
    private String nazev;
    private String pristupnost;
    private String reziser;
    private boolean podpora3D;

    public Films(String nazev, String pristupnost, String reziser, boolean podpora3D) {
        this.nazev = nazev;
        this.pristupnost = pristupnost;
        this.reziser = reziser;
        this.podpora3D = podpora3D;
    }

    public String getNazev() {
        return nazev;
    }

    public String getPristupnost() {
        return pristupnost;
    }

    public String getReziser() {
        return reziser;
    }

    public boolean isPodpora3D() {
        return podpora3D;
    }
}