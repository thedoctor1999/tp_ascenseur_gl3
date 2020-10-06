import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Porte {
    int etage;
    boolean ouverte;
    Porte(int etage){
        this.etage = etage;
        this.ouverte = false;
    }

    void ouvrir() throws InterruptedException {
        this.ouverte = true;
        System.out.println("porte du "+this.etage+" eme etage est ouverte.");
        Scanner scanner = new Scanner(System.in);
        sleep(3);
        this.fermer();
    }

    private void fermer() {
        this.ouverte = false;
        System.out.println("porte du "+this.etage+" eme etage est fermee.");
    }
}
