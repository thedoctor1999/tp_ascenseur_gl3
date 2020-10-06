import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Ascenseur {
    int etage, nb_etages, destination;
    char dirrection;
    ArrayList<Integer> appels, destinations_en_attente;
    ArrayList<Porte> liste_des_portes;

    Ascenseur(int nb_etages){
        this.etage = 0;
        this.nb_etages = nb_etages;
        this.dirrection = '0';
        this.destination = 0;
        this.appels = new ArrayList<Integer>();
        this.liste_des_portes = new ArrayList<Porte>();
        for(int i=0; i<nb_etages; i++){
            this.liste_des_portes.add(new Porte(i));
        }
    }
    /*Ascenseur() throws NullPointerException{
        this.etage = 0;
        this.destination = '0';
        for(int i=0; i<this.nb_etages; i++){
            this.liste_des_portes.add(new Porte(i));
        }
    }*/

    void appeller(int etage, char dirrection, int destination) throws InterruptedException {
        this.appels.add(etage);
        System.out.println("ascenseur appellée");
        if (this.dirrection == dirrection || this.dirrection == '0') {
            aller_vers_la_destination();
        }
    }

    private void descendre() throws InterruptedException {
        while (this.etage > this.destination){
            this.etage++;
            sleep(1);
            for(int i=0; i < appels.size(); i++){
                if(this.etage == appels.get(i)){
                    System.out.println("arret au " + this.etage + " eme etage pour recuperer un usager.");
                    ouvrir_la_porte();
                }
            }
        }
        if (this.etage == this.destination) {
            System.out.println("Arrivé a destination " + this.etage);
            ouvrir_la_porte();
            if(this.appels.isEmpty()){
                this.dirrection = 0;
            }
        }
    }

    private void monter() throws InterruptedException {
        while (this.etage < this.destination){
            this.etage++;
        }
        if (this.etage == this.destination) {
            System.out.println("Arrivé a destination " + this.etage);
            ouvrir_la_porte();
        }
    }

    private void ouvrir_la_porte() throws InterruptedException {
        this.liste_des_portes.get(this.etage).ouvrir();

    }

    private void demander_la_destination() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Selectionnez l'etage auquel vous voullez aller : ");
        this.destination = sc.nextInt();
        this.aller_vers_la_destination();
    }
    private void aller_vers_la_destination() throws InterruptedException {
        if (this.destination == this.etage) {
            demander_la_destination();
        } else if (this.destination > this.etage) {
            this.dirrection = 'H';
            this.destination = etage;
            System.out.println("L'ascenseur est entrain de monter");
            this.monter();
        } else {
            this.dirrection = 'B';
            this.destination = etage;
            System.out.println("L'ascenseur est entrain de descendre");
            this.descendre();
        }
        System.out.println("here");
    }

    @Override
    public String toString() {
        return "Ascenseur{" +
                "etage=" + etage +
                ", nb_etages=" + nb_etages +
                ", destination=" + destination +
                ", dirrection=" + dirrection +
                ", appels=" + appels +
                ", liste_des_portes=" + liste_des_portes +
                '}';
    }
}
