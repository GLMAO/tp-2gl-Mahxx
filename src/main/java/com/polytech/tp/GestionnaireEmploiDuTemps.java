package com.polytech.tp;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireEmploiDuTemps implements Subject{
    private List<ICours> listeCours = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();
    
    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }
    
    public void ajouterCours(ICours cours) {
        this.listeCours.add(cours);
        System.out.println("Nouveau cours ajouté : " + cours.getDescription());
        notifyObservers("Nouveau cours ajouté : " + cours.getDescription());
    }

    public void modifierCours(ICours cours, String message) {
        System.out.println("Cours modifié : " + message);
        String msg = "Cours modifié : " + cours.getDescription() + " (" + message + ")";
        
        notifyObservers("Cours modifié : " +msg);
    }
    

    public void setChangement(String message) {
        notifyObservers(message);
        System.out.println("Notification générale : " + message);
        
    }
}
