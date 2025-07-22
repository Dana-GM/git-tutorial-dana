public class Poistenec {
    private String meno;
    private String priezvisko;
    private int vek;
    private String telefon;

    public Poistenec(String meno, String priezvisko, int vek, String telefon) {
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.vek = vek;
        this.telefon = telefon;
    }

    public String getMeno() {
        return meno;
    }

    public String getPriezvisko() {
        return priezvisko;
    }

    public int getVek() {
        return vek;
    }

    public String getTelefon() {
        return telefon;
    }

    @Override
    public String toString() {
        return meno + " " + priezvisko + "\t" + vek + "\t" + telefon;
    }

    public String toFileString() {
        return meno + ";" + priezvisko + ";" + vek + ";" + telefon;
    }

    public static Poistenec fromFileString(String line) {
        String[] parts = line.split(";");
        if (parts.length != 4) return null;
        try {
            return new Poistenec(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3]);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}