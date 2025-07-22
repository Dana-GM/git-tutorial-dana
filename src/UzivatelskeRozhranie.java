import java.util.List;
import java.util.Scanner;

public class UzivatelskeRozhranie {
    private Scanner sc = new Scanner(System.in);
    private EvidencePoistenych evidence = new EvidencePoistenych();

    public void spusti() {
        while (true) {
            vypisMenu();
            String volba = sc.nextLine();

            switch (volba) {
                case "1" -> pridajPoistenca();
                case "2" -> vypisPoistencov();
                case "3" -> vyhladajPoistenca();
                case "4" -> {
                    System.out.println("Ukončujem aplikáciu.");
                    return;
                }
                default -> System.out.println("Neplatná voľba.");
            }
            System.out.println("\nPokračujte stlačením ľubovoľnej klávesy...");
            sc.nextLine();
        }
    }

    private void vypisMenu() {
        System.out.println("===============================");
        System.out.println("Evidencia poistených");
        System.out.println("===============================");
        System.out.println("1 - Pridať nového poisteného");
        System.out.println("2 - Vypísať všetkých poistených");
        System.out.println("3 - Vyhľadať poisteného");
        System.out.println("4 - Koniec");
        System.out.print("Zvoľte možnosť: ");
    }

    private void pridajPoistenca() {
        String meno = nacitajText("Zadajte meno: ");
        String priezvisko = nacitajText("Zadajte priezvisko: ");
        int vek = nacitajCislo("Zadajte vek: ");
        String telefon = nacitajText("Zadajte telefónne číslo: ");

        Poistenec poistenec = new Poistenec(meno, priezvisko, vek, telefon);
        evidence.pridajPoistenca(poistenec);
        System.out.println("Dáta bola uložená.");
    }

    private void vypisPoistencov() {
        List<Poistenec> poistenci = evidence.getVsetciPoistenci();
        if (poistenci.isEmpty()) {
            System.out.println("Zatiaľ nie sú evidovaní žiadni poistenci.");
        } else {
            for (Poistenec p : poistenci) {
                System.out.println(p);
            }
        }
    }

    private void vyhladajPoistenca() {
        String meno = nacitajText("Zadajte meno: ");
        String priezvisko = nacitajText("Zadajte priezvisko: ");

        List<Poistenec> nalezeni = evidence.vyhladajPoistenca(meno, priezvisko);
        if (nalezeni.isEmpty()) {
            System.out.println("Poistený nebol nájdený.");
        } else {
            for (Poistenec p : nalezeni) {
                System.out.println(p);
            }
        }
    }

    private String nacitajText(String vyzva) {
        String vstup;
        do {
            System.out.print(vyzva);
            vstup = sc.nextLine().trim();
            if (vstup.isEmpty()) {
                System.out.println("Toto pole nesmie byť prázdne.");
            }
        } while (vstup.isEmpty());
        return vstup;
    }

    private int nacitajCislo(String vyzva) {
        while (true) {
            try {
                System.out.print(vyzva);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Zadajte platné číslo.");
            }
        }
    }
}