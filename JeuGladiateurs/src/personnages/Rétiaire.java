package personnages;

import java.util.Random;
public class Rétiaire extends Personnage{

    // **************************************************************************
    // **************************************************************************
    // **************************************************************************
    // <editor-fold desc="Attributs">
    // TODO : Mettre vos attributs ici
        
   
    
    // </editor-fold>

    // **************************************************************************
    // **************************************************************************
    // **************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Constructeurs et initialisation">
    public Rétiaire(String nom, int attaqueMax, int defense, int pvs, int ini) {
        // TODO : Constructeur AVEC paramètres
        this.nom = nom;
        this.pointDeVie = pvs;
        this.valeurMaxAttaque = attaqueMax;
        this.valeurDefense = defense;
        this.initiative = ini;
    }

    public Rétiaire() {
        // TODO : Constructeur SANS paramètres qui initialise à ZÉRO ou à ""
        this.nom = "";
        this.pointDeVie = 0;
        this.valeurMaxAttaque = 0;
        this.valeurDefense = 0;
        this.initiative = 0;
    }
    // </editor-fold>

    // **************************************************************************
    // **************************************************************************
    // **************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Getters et setters">
    // TODO : Les getters

    
        
    
    
    // TODO : Les setters

   

    
    // </editor-fold>

    // **************************************************************************
    // **************************************************************************
    // **************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Mécanique de jeu">
    @Override
    public void afficherInfosPersonnage() {
        // TODO : Afficher les infos du personnage, tel que montré dans l'énoncé
        
        System.out.println();
        
        System.out.println(nom);
        System.out.println("\tAttaque : " + valeurMaxAttaque );
        System.out.println("\tDefense : " + valeurDefense );
        System.out.println("\tPoint de vie : " + pointDeVie );
        System.out.println("\tInitiative : " + initiative );
        
        
        
        if (pointDeVie <=0) {
            System.out.println("\tStatut : Mort" );

        }else{
            System.out.println("\tStatut : Vivant" );

        }
        
        
    }

    private int attaqueCalcul() {
        // TODO : Retourner la valeur de l'attaque du personnage.
        Random rand = new Random();
        // Cette valeur est trouvée aléatoirement et doit se situer entre ZÉRO et valeurMaxAttaque.
        return rand.nextInt(valeurMaxAttaque - 0) + 0;
    }

    public void frapperPersonnage(Rétiaire personnageCible) {
        // TODO : Récupérer la valeur d'attaque pour ce tour, calculer les dégats,
        //modifier les points de vie du personnage cible, afficher les détails
        // sur l'attaque, tel que montré dans l'énoncé.
        int forceDeFrappe;
        int valeurDeDefence;
        int dommages;
        
        forceDeFrappe = attaqueCalcul();
        valeurDeDefence = personnageCible.valeurDefense;
        dommages = forceDeFrappe - valeurDeDefence;
        
        if (dommages < 0) {
            dommages =0;
        }
        
        personnageCible.pointDeVie -= dommages;
        
        if (personnageCible.pointDeVie < 0) {
            personnageCible.pointDeVie =0;
        }
        
        System.out.println();
        System.out.println(this.nom + " attaque avec une puissance de : " + forceDeFrappe);
        System.out.println(personnageCible.nom + " a une defense de : " + valeurDeDefence);
        System.out.println("Les dommages sont donc de : " + dommages);

    }

    @Override
    public void setNewInitiativeRandom() {
        // TODO : Modifier de façon aléatoire la valeur INI du personnage.
        Random rand = new Random();
        this.initiative =rand.nextInt(100 - 0) + 0;
    }
    // </editor-fold>
}
