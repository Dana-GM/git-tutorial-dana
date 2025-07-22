import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EvidencePoistenych {
    private List<Poistenec> poistenci = new ArrayList<>();
    private final String subor = "poistenci.txt";

    public EvidencePoistenych() {
        nacitajZoSuboru();
    }

    public void pridajPoistenca(Poistenec poistenec) {
        poistenci.add(poistenec);
        ulozDoSuboru();
    }

    public List<Poistenec> getVsetciPoistenci() {
        return poistenci;
    }

    public List<Poistenec> vyhladajPoistenca(String meno, String priezvisko) {
        List<Poistenec> vysledok = new ArrayList<>();
        for (Poistenec p : poistenci) {
            if (p.getMeno().equalsIgnoreCase(meno) &&
                    p.getPriezvisko().equalsIgnoreCase(priezvisko)) {
                vysledok.add(p);
            }
        }
        return vysledok;
    }

    private void ulozDoSuboru() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(subor))) {
            for (Poistenec p : poistenci) {
                writer.println(p.toFileString());
            }
        } catch (IOException e) {
            System.out.println("Chyba pri ukladaní do súboru.");
        }
    }

    private void nacitajZoSuboru() {
        File file = new File(subor);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String riadok;
            while ((riadok = reader.readLine()) != null) {
                Poistenec p = Poistenec.fromFileString(riadok);
                if (p != null) {
                    poistenci.add(p);
                }
            }
        } catch (IOException e) {
            System.out.println("Chyba pri čítaní zo súboru.");
        }
    }
}