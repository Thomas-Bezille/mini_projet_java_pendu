import com.dyma.game.GuessGame;

import java.util.Random;
import java.util.Scanner;

/**
 * Class of the entry point of the game
 */
public class Main {

    /**
     * Entry point of the Guess Game. Contains the main algorithm of the game.
     */
    public static void main(String[] args) {

        final var random = new Random();
        final var words = "chaton minou felin matou ronron museau griffe moustache patte pelage chat chien chiot caniche labrador berger retriever dalmatien chihuahua teckel bulldog rottweiler perruche canari moineau aigle faucon colibri toucan cacatoes paon autruche poisson requin truite saumon thon anguille carpe perche brochet sardine plage sable coquillage parasol serviette maillot oceane galet bikini soleil bronzer montagne sommet alpiniste escalade randonnee refuge pic neige rocher ski telesiege foret arbre mousse champignon clairiere chene branche ecureuil buisson riviere courant cascade rivage ruisseau torrent etang pecheur barque canoë kayak soleil etoile briller lumiere chaleur rayon crepuscule zénith eclat lune croissant pleine nouvelle eclipse cratere nocturne pale astronaute etoile galaxie constellation astre comete pulsar supernova neutron telescope firmament nuage cumulus cirrus orage gris brume flocon pluie averse goutte bruine torrentiel deluge mouille parapluie humidite inondation vent souffle bourrasque brise tempete rafale eolienne cyclone ouragan courant neige flocon tempete bonhomme avalanche poudreuse cristaux glissade glacon glace fondre fleur rose tulipe lys marguerite jonquille oeillet pivoine lavande iris violette arbre chene sapin bouleau hêtre acacia palmier olivier cypres platane sequoia fruit pomme poire peche banane orange raisin fraise cerise ananas kiwi legume tomate carotte laitue courgette aubergine radis navet poivron brocoli concombre chocolat tablette praline ganache truffe cacao bonbon noir lait blanc dessert fondue mousse gateau eclair tartelette moelleux fondant charlotte biscuit macaron cookie sablé galette palet breton speculoos shortbread glace sorbet creme cornets gelato vanille chocolat caramel the vert noir blanc oolong infusion tisane boisson cafe espresso cappuccino latte mocha arabica robusta noisette creme pizza margherita pepperoni fromage vegetarienne quattro stagioni napolitaine prosciutto regina capricciosa hamburger cheeseburger double bacon deluxe vegan barbecue classique frites pate spaghetti penne tagliatelle fusilli macaroni lasagne ravioli rigatoni sandwich jambon fromage poulet thon saumon crudite club panini baguette salade cesar niçoise verte composee grecque asiatique quinoa roquette livre roman essai recueil dictionnaire anthologie bande dessinée encyclopedie thriller polar biographie film action comedie drame documentaire horreur animation aventure musical romance musique classique jazz rock pop blues techno folk reggae country dance salsa tango valse ballet samba flamenco moderne sportif terrain match equipe entraineur ballon maillot joueur competition football but gardien defenseur attaquant milieu corner penalty basket panier rebond dribble dunk faute pivot tennis raquette balle filet ace service smash volée revers hockey patin palet crosse gardien penalite natation brasse crawl plongeon apnee nageur nage libre crawl course marathon sprint relais cross vélo pedale selle guidon derailleurs vitesse pneu course cycliste peloton gym fitness musculation pilates yoga aerobic zumba etirement vacances plage montagne campagne detente hotel resort camping aventure excursion train locomotive wagon rail voie rapide tgv fret gare avion cockpit fuselage atterrissage decolage hublot cabine pilote passager destination voiture moteur coffre volant siege vitesse phare roue moto scooter harley yamaha suzuki kawasaki triumph ducati casque bus navette car scolaire transport voyageur arret ticket ligne bateau voilier yacht ferry barque cargo croisiere pont navigation ordinateur clavier souris ecran disque dur processeur logiciel memoire connexion telephones smartphone appel message ecran tactile chargeur application wifi tablette ecran portable internet tactile clavier android ios apple samsung jeu video console manette niveau mission graphisme online multijoueur avatar jouet peluche figurine jeu puzzle lego dinosaure voiture avion bateau camion marionnette ballon foot rugby volley basket handball tennis rugby gonflable fil vent ciel dessin crayon feutre papier tableau esquisse croquis griffonner peinture pinceau toile aquarelle gouache huile acrylique vernis sculpture marbre pierre bronze statue modele moulage burin ciseau argile photo appareil camera objectif image portrait paysage video film clip enregistrement montage projection ecran evenement fete anniversaire celebration festivite surprise invitation cadeau bougie gateau mariage ceremonie couple alliance bouquet demoiselle couvertures panier snack boisson parc herbe concert scene musique chanteur groupe public orchestre micro festival culture musique art scene evenement marche produit artisanat legumes fruits poisson viande fleurs epices fromage boulangerie boutique magasin produit vetements chaussures accessoire mode librairie musee art galerie exposition visite guidee billet bibliotheque livre emprunt lecteur rayon etagere auteur couverture jardin parc verdure arbuste pelouse plante banc chemin fleur zoo animaux cage enclos tigre lion elephant singe girafe aquarium poisson tortue requin dauphin meduse ecole classe eleve professeur cours livre cahier stylo universite etudiant faculte campus cours conference these laboratoire hopital medecin chirurgie infirmier patient salle clinique consultation soin diagnostic traitement pharmacie medicament ordonnance pilule prescription maison salon cuisine chambre salle appartement studio balcon ascenseur chateau tour donjon pont levis douves palais mosaique vitraux eglise priere cloche autel chapelle cathedrale mosquee minaret mihrab imam tapis moslem priere coran livre cuisine recette plat ingredient preparation cuisson assaisonnement epice blog article publication commentaire redaction podcast emission audio theme sujet interview invite ecoute telechargement magazine periodique rubrique kiosque numero abonnement journal quotidien hebdomadaire editorial reportage information sport economie politique finance culture société publicite rubrique abonnement pli livraison".split(" ");
        var wordToGuess = words[random.nextInt(words.length)];
        var game = new GuessGame(wordToGuess, 10);

        System.out.println("Le jeu débute !");

        while (true) {
            System.out.println(game);
            final var letter = scanLetter("Entrez une lettre :");

            game.guessLetter(letter);

            if (game.isLost()) {
                System.out.println(game);
                System.out.println("Perdu !");
            }

            if (game.isWin()) {
                System.out.println(game);
                System.out.println("Gagné !");
            }

            if (game.isWin() || game.isLost()) {
                var replayAnswer = scanLetter("Voulez-vous rejouer ? (O/N)");
                if (replayAnswer == 'o' || replayAnswer == 'O' || replayAnswer == 'y' || replayAnswer == 'Y') {
                    wordToGuess = words[random.nextInt(words.length)];
                    game = new GuessGame(wordToGuess, 10);
                } else {
                    break;
                }
            }
        }
    }

    private static char scanLetter(String question) {
        final var scanner = new Scanner(System.in);
        Character letter = null;
        do {
            System.out.println(question);
            var input = scanner.nextLine();

            if (input.length() == 1) {
                letter = input.charAt(0);
            }

        } while (letter == null);

        return letter;
    }
}