package Model;

public class Gaufre {
    /**
     * Classe représentant le plateau de jeu de la Gaufre Empoisonnée.
     * La gaufre est représentée par une matrice où:
     * - true = case présente
     * - false = case mangée
     * La case empoisonnée est la case (0,0)
     **/

    private int ligne;
    private int colonne;

    private boolean[][] plateau;

    public Gaufre(int ligne, int colonne) {
        this.ligne = ligne;
        this.colonne = colonne;
        plateau = new boolean[ligne][colonne];
        for (int i = 0; i < ligne; i++) {
            for (int j = 0; j < colonne; j++) {
                plateau[i][j] = true;
            }
        }
    }

    public Gaufre(){
        this(8,6);
    }

    public void jouerCoup(int x, int y) {
        if (!estcoupValide(x, y)) {
            throw new IllegalArgumentException("Coup invalide");
        }

        // Mange toutes les cases en dessous et à droite de (x,y)
        // selon les consignes et les images
        for (int i = 0; i <= x; i++) {
            for (int j = y; j < colonne; j++) {
                plateau[i][j] = false;
            }
        }
    }

    public boolean estTerminee() {
        // La case empoisonnée en bas à gauche (ligne-1, 0)
        return !plateau[ligne-1][0];
    }

    public void afficherPlateau() {
        for (int i = 0; i < ligne; i++) {
            for (int j = 0; j < colonne; j++) {
                if (i == ligne-1 && j == 0) {
                    System.out.print(plateau[i][j] ? "[☠]" : "[ ]");
                } else {
                    System.out.print(plateau[i][j] ? "[■]" : "[ ]");
                }
            }
            System.out.println();
        }
    }

    private boolean estcoupValide(int x, int y) {
        // Le coup doit être dans les limites du plateau et sur une case non mangée
        return x >= 0 && x < ligne && y >= 0 && y < colonne && plateau[x][y];
    }

    private boolean estCaseEmpoisonnee(int x, int y) {
        // La case empoisonnée est en bas à gauche
        return x == ligne-1 && y == 0;
    }

    public boolean[][] getPlateau() {
        return plateau;
    }

    public int getLigne() {
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }


}