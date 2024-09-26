import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JeuDevinetteFilmsGUI extends JFrame {
    private List<Film> films = new ArrayList<>();
    private Random random = new Random();
    private Film filmADeviner;
    private int essaisRestants = 3;
    private int bonnesReponses = 0;

    // Composants de l'interface graphique
    private JLabel labelIndices;
    private JLabel labelEssais;
    private JTextField champReponse;
    private JButton boutonValider;
    private JLabel labelResultat;

    public JeuDevinetteFilmsGUI() {
        // Initialiser la fenêtre
        setTitle("Jeu de Devinette de Films");
        setSize(800, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1)); // Layout en grille avec 5 lignes

        // Ajouter des films
        films.add(new Film("Inception", 2010, "Science-fiction", "Christopher Nolan"));
        films.add(new Film("Le Seigneur des Anneaux", 2001, "Fantastique", "Peter Jackson"));
        films.add(new Film("Interstellar", 2014, "Science-fiction", "Christopher Nolan"));
        films.add(new Film("Gladiator", 2000, "Historique", "Ridley Scott"));
        films.add(new Film("Pulp Fiction", 1994, "Crime", "Quentin Tarantino"));
        films.add(new Film("The Dark Knight", 2008, "Action", "Christopher Nolan"));
        films.add(new Film("Fight Club", 1999, "Drame", "David Fincher"));
        films.add(new Film("Forrest Gump", 1994, "Drame", "Robert Zemeckis"));
        films.add(new Film("Titanic", 1997, "Romance", "James Cameron"));
        films.add(new Film("Avatar", 2009, "Science-fiction", "James Cameron"));
        films.add(new Film("The Matrix", 1999, "Science-fiction", "Lana Wachowski, Lilly Wachowski"));
        films.add(new Film("Shutter Island", 2010, "Thriller", "Martin Scorsese"));
        films.add(new Film("The Godfather", 1972, "Crime", "Francis Ford Coppola"));
        films.add(new Film("The Shawshank Redemption", 1994, "Drame", "Frank Darabont"));
        films.add(new Film("Star Wars: A New Hope", 1977, "Science-fiction", "George Lucas"));
        films.add(new Film("Jurassic Park", 1993, "Aventure", "Steven Spielberg"));
        films.add(new Film("The Lion King", 1994, "Animation", "Roger Allers, Rob Minkoff"));
        films.add(new Film("Harry Potter à l'école des sorciers", 2001, "Fantastique", "Chris Columbus"));
        films.add(new Film("Mad Max: Fury Road", 2015, "Action", "George Miller"));
        films.add(new Film("The Avengers", 2012, "Super-héros", "Joss Whedon"));
        films.add(new Film("The Silence of the Lambs", 1991, "Thriller", "Jonathan Demme"));
        films.add(new Film("Goodfellas", 1990, "Crime", "Martin Scorsese"));
        films.add(new Film("The Usual Suspects", 1995, "Thriller", "Bryan Singer"));
        films.add(new Film("Back to the Future", 1985, "Science-fiction", "Robert Zemeckis"));
        films.add(new Film("The Sixth Sense", 1999, "Thriller", "M. Night Shyamalan"));
        films.add(new Film("Saving Private Ryan", 1998, "Guerre", "Steven Spielberg"));
        films.add(new Film("Braveheart", 1995, "Historique", "Mel Gibson"));
        films.add(new Film("Schindler's List", 1993, "Historique", "Steven Spielberg"));
        films.add(new Film("Pirates of the Caribbean: The Curse of the Black Pearl", 2003, "Aventure", "Gore Verbinski"));
        films.add(new Film("The Departed", 2006, "Crime", "Martin Scorsese"));
        films.add(new Film("Whiplash", 2014, "Drame", "Damien Chazelle"));
        films.add(new Film("La La Land", 2016, "Romance", "Damien Chazelle"));
        films.add(new Film("Django Unchained", 2012, "Western", "Quentin Tarantino"));
        films.add(new Film("No Country for Old Men", 2007, "Crime", "Joel Coen, Ethan Coen"));
        films.add(new Film("Blade Runner 2049", 2017, "Science-fiction", "Denis Villeneuve"));
        films.add(new Film("The Grand Budapest Hotel", 2014, "Comédie", "Wes Anderson"));
        films.add(new Film("Spider-Man: Into the Spider-Verse", 2018, "Animation", "Peter Ramsey, Rodney Rothman"));
        films.add(new Film("Black Panther", 2018, "Super-héros", "Ryan Coogler"));
        films.add(new Film("The Social Network", 2010, "Biographie", "David Fincher"));
        films.add(new Film("A Beautiful Mind", 2001, "Biographie", "Ron Howard"));
        films.add(new Film("12 Years a Slave", 2013, "Drame", "Steve McQueen"));
        films.add(new Film("Gravity", 2013, "Science-fiction", "Alfonso Cuarón"));
        films.add(new Film("Logan", 2017, "Super-héros", "James Mangold"));
        films.add(new Film("Parasite", 2019, "Thriller", "Bong Joon-ho"));
        films.add(new Film("Joker", 2019, "Thriller", "Todd Phillips"));
        films.add(new Film("Bohemian Rhapsody", 2018, "Biographie", "Bryan Singer"));
        films.add(new Film("Her", 2013, "Science-fiction", "Spike Jonze"));
        films.add(new Film("The Revenant", 2015, "Aventure", "Alejandro González Iñárritu"));
        films.add(new Film("Once Upon a Time in Hollywood", 2019, "Comédie", "Quentin Tarantino"));
        films.add(new Film("The Irishman", 2019, "Crime", "Martin Scorsese"));
        films.add(new Film("1917", 2019, "Guerre", "Sam Mendes"));
        films.add(new Film("Ford v Ferrari", 2019, "Drame", "James Mangold"));
        films.add(new Film("Soul", 2020, "Animation", "Pete Docter"));
        films.add(new Film("Tenet", 2020, "Science-fiction", "Christopher Nolan"));


        // Choisir film aléatoirement
        filmADeviner = choisirFilm();

        // Créer et ajouter les composants graphiques
        labelIndices = new JLabel("Indice : " + filmADeviner.getIndices());
        labelEssais = new JLabel("Essais restants : " + essaisRestants);
        champReponse = new JTextField();
        boutonValider = new JButton("Valider");
        labelResultat = new JLabel("");

        // Ajouter les composants à la fenêtre
        add(labelIndices);
        add(labelEssais);
        add(champReponse);
        add(boutonValider);
        add(labelResultat);

        // Ajouter l'action du bouton
        boutonValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validerReponse();
            }
        });
    }

    // Méthode pour choisir un film aléatoirement
    private Film choisirFilm() {
        return films.get(random.nextInt(films.size()));
    }

       // Méthode pour valider la réponse de l'utilisateur
       private void validerReponse() {
        String reponse = champReponse.getText();

        if (reponse.equalsIgnoreCase(filmADeviner.getTitre())) {
            bonnesReponses++; // Incrémenter les bonnes réponses
            if (bonnesReponses == 10) {
                // Si on a 10 bonnes réponses, le jeu se termine
                labelResultat.setText("Félicitations ! Vous avez trouvé 10 films !");
                boutonValider.setEnabled(false);
            } else {
                labelResultat.setText("Bravo ! Vous avez deviné le film.");
                passerAQuestionSuivante(); // Passer à la question suivante
            }
        } else {
            essaisRestants--;
            if (essaisRestants > 0) {
                labelResultat.setText("Mauvaise réponse. Essayez encore.");
                labelEssais.setText("Essais restants : " + essaisRestants);
            } else {
                // Afficher le message et passer à la question suivante après un petit délai
                labelResultat.setText("Dommage ! Le film était : " + filmADeviner.getTitre());

                // Utiliser un Timer pour créer un petit délai avant de passer à la question suivante
                Timer timer = new Timer(4000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        passerAQuestionSuivante();
                    }
                });
                timer.setRepeats(false); // Le Timer ne se répète pas
                timer.start(); // Démarrer le timer
            }
        }
    }

    // Méthode pour passer à la question suivante
    private void passerAQuestionSuivante() {
        essaisRestants = 3; // Réinitialiser le nombre d'essais
        filmADeviner = choisirFilm(); // Choisir un nouveau film
        labelIndices.setText("Indice : " + filmADeviner.getIndices()); // Mettre à jour les indices
        labelEssais.setText("Essais restants : " + essaisRestants); // Réinitialiser le label des essais
        champReponse.setText(""); // Effacer le champ de réponse
        labelResultat.setText(""); // Effacer le message de résultat
    }

    public static void main(String[] args) {
        // Créer une instance de l'application graphique
        JeuDevinetteFilmsGUI jeuGUI = new JeuDevinetteFilmsGUI();
        jeuGUI.setVisible(true);
    }
}