package com.polytech;


import com.polytech.tp.ICours;
import com.polytech.tp.Cours;
import com.polytech.tp.CoursBuilder;
import com.polytech.tp.CoursMagistral;
import com.polytech.tp.CoursEnAnglais ;
import com.polytech.tp.CoursEnLigne;
import com.polytech.tp.Observer;
import com.polytech.tp.Etudiant;
import com.polytech.tp.Responsable;
import com.polytech.tp.GestionnaireEmploiDuTemps;


public class App 
{
    public static void main( String[] args )
    {
        
        Cours cours = new CoursBuilder()
                .setMatiere("pafa")
                .setEnseignant("mahmoud")
                .setSalle("11")
                .setDate("21/09/2003")
                .setHeureDebut("10:00")
                .setEstOptionnel(false)
                .setNiveau("2eme")
                .setNecessiteProjecteur(true)
                .build();

        System.out.println("cours normal : " + cours.getDescription());

        
        GestionnaireEmploiDuTemps gestionnaire = new GestionnaireEmploiDuTemps();

        Etudiant e1 = new Etudiant("charara");
        Etudiant e2 = new Etudiant("mahmoud");
        Responsable r = new Responsable("manai");

        gestionnaire.attach(e1);
        gestionnaire.attach(e2);
        gestionnaire.attach(r);

        gestionnaire.ajouterCours(cours);
        gestionnaire.modifierCours(cours, "changer la salle a 100");
        gestionnaire.setChangement("le cours anuler");

        
        ICours coursenligne = new CoursEnLigne(cours);
        ICours coursenanglais = new CoursEnAnglais(cours);
        ICours coursenmagestral = new CoursMagistral(cours);
        
        

        System.out.println("\n Cours decore : " + coursenligne.getDescription());
        System.out.println("\n Cours decore : " + coursenanglais.getDescription());
        System.out.println("\n Cours decore : " + coursenmagestral.getDescription());

    }
}
