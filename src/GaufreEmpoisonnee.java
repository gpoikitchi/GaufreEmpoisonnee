import java.util.Scanner;
import Model.Gaufre;
import Model.Partie;

public class GaufreEmpoisonnee {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gaufre gaufre = new Gaufre(); // gaufre 8x6 par défaut
        Partie partie = new Partie(gaufre);

        while (!gaufre.estTerminee()) {
            partie.afficherEtat();

            System.out.print("Entrez la ligne (x) du coup : ");
            int x = scanner.nextInt();
            System.out.print("Entrez la colonne (y) du coup : ");
            int y = scanner.nextInt();

            partie.jouerCoup(x, y);
        }

        System.out.println("Fin de la partie !");
        scanner.close();
    }
}
