package Model;

public class Partie {
    public Gaufre gaufre;
    public boolean joueurActuel; // faux : joueur 1 || true : joueur 2

    public Partie(Gaufre g){
        gaufre = g;
        joueurActuel = false;
    }

    public void afficherEtat(){
        System.out.println("joueur " + (joueurActuel ? "2" : "1")+" a vous de jouer");
        gaufre.afficherPlateau();
    }

    public void jouerCoup(int x, int y){
        if(gaufre.estTerminee()){
            System.out.println("Partie terminee");
            return;
        }

        try{
            gaufre.jouerCoup(x,y);
        }catch (IllegalArgumentException e){
            System.out.println("Coup invalide. Réessayez.");
            return;
        }

        if (gaufre.estTerminee()) {
            System.out.println("Joueur " + (joueurActuel ? "2" : "1") + " a perdu !");
        } else {
            joueurActuel = !joueurActuel;
        }
    }
}