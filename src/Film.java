public class Film {
    private String titre;
    private int annee;
    private String genre;
    private String realisateur;

    public Film(String titre, int annee, String genre, String realisateur) {
        this.titre = titre;
        this.annee = annee;
        this.genre = genre;
        this.realisateur = realisateur;
    }

    // Getters pour accéder aux informations
    public String getTitre() {
        return titre;
    }

    public int getAnnee() {
        return annee;
    }

    public String getGenre() {
        return genre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    // Fonction pour afficher un résumé du film (indices)
    public String getIndices() {
        return "Année: " + annee + ", Genre: " + genre + ", Réalisateur: " + realisateur;
    }
}
