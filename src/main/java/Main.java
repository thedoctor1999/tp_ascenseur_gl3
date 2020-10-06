public class Main {
    public static void main(String[] args) throws InterruptedException {
        Ascenseur ascenseur[] = {new Ascenseur(20)};
        Usager usager = new Usager(3, 0);

        usager.appeller_l_ascenseur(ascenseur);

    }
}
