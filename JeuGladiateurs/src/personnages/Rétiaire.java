package personnages;

import java.util.Random;
public class Rétiaire extends Personnage{

    // **************************************************************************
    // **************************************************************************
    // **************************************************************************
    // <editor-fold desc="Attributs">
    // TODO : Mettre vos attributs ici
       boolean filet = true;
   
    
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
    

    private int attaqueCalcul() {
        // TODO : Retourner la valeur de l'attaque du personnage.
        Random rand = new Random();
        // Cette valeur est trouvée aléatoirement et doit se situer entre ZÉRO et valeurMaxAttaque.
        return rand.nextInt(valeurMaxAttaque - 0) + 0;
    }

       @Override
    public void frapperPersonnage(Personnage personnageCible) {
        // TODO : Récupérer la valeur d'attaque pour ce tour, calculer les dégats,
        //modifier les points de vie du personnage cible, afficher les détails
        // sur l'attaque, tel que montré dans l'énoncé.
        int forceDeFrappe;
        int valeurDeDefence;
        int dommages;
        int touche;
        
        if (filet) {
            System.out.println();
            System.out.println(this.nom + " lance son filet");
            filet = false;
            
            Random rand = new Random();
            touche = rand.nextInt(100 - 1) + 1;
            if (touche <= 10) {
                System.out.println();
                System.out.println("Son filet attrape " + personnageCible +" et il l'empale sauvagement avec sa lance");
            } else {
                System.out.println();
                System.out.println("Le filet n'atteint pas sa cible");
            }
            
        } else {
            
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
            System.out.println(this.nom + " ramasse son filet et en profite pour attaquer");
            this.filet = true;
            System.out.println();
            System.out.println(this.nom + " attaque avec une puissance de : " + forceDeFrappe);
            System.out.println(personnageCible.nom + " a une defense de : " + valeurDeDefence);
            System.out.println("Les dommages sont donc de : " + dommages);

        }
    }

    @Override
    public void setNewInitiativeRandom() {
        // TODO : Modifier de façon aléatoire la valeur INI du personnage.
        Random rand = new Random();
        this.initiative =rand.nextInt(100 - 0) + 0;
    }
    // </editor-fold>
}
