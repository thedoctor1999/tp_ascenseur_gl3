public class Usager {
    int etage, destination;
    char dirrection;

    Usager(int etage, int destination){
        this.etage = etage;
        this.destination = destination;
        if(this.destination > this.etage){
            dirrection = 'H';
        }
        else if(this.destination < this.etage){
            dirrection = 'B';
        }

    }
    void appeller_l_ascenseur(Ascenseur[] ascenseur) throws InterruptedException {
        ascenseur[0].appeller(this.etage, this.dirrection, this.destination);
    }
}
