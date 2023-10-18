package com.ism;

import java.util.Scanner;

import com.ism.entities.Medecin;
import com.ism.entities.Patient;
import com.ism.repositories.DatabaseImpl;
import com.ism.repositories.MedecinImpl;
import com.ism.repositories.PatientImpl;
import com.ism.services.PersonneServiceImpl;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choix;
        DatabaseImpl database = new DatabaseImpl();
        PatientImpl patientImpl= new PatientImpl(database);
        MedecinImpl medecinImpl= new MedecinImpl(database);
        PersonneServiceImpl<Patient> patientServiceImpl = new PersonneServiceImpl<>(patientImpl);
        PersonneServiceImpl<Medecin> medecinServiceImpl = new PersonneServiceImpl<>(medecinImpl);
        do {
            System.out.println("Menu Principal:");
            System.out.println("1. Créer un patient");
            System.out.println("2. Créer un médecin");
            System.out.println("3. Planifier un rendez-vous");
            System.out.println("4. Afficher les rendez-vous du jour");
            System.out.println("5. Afficher les rendez-vous d'un médecin par jour");
            System.out.println("6. Annuler un rendez-vous");
            System.out.println("7. Quitter");
            choix = sc.nextInt();
            switch (choix) {
                case 1:
    System.out.println("Créer un patient :");

   
    System.out.print("Entrer le nom complet du patient : ");
    String nomCompletP = sc.next();
    System.out.print("Entrer les antécédents du patient : ");
    String antecedents = sc.next();

 
    Patient patient = new Patient();
    patient.setNomComplet(nomCompletP);
    patient.setAntecedents(antecedents);

    
    int resultP = patientServiceImpl.add(patient);

    if (resultP > 0) {
        System.out.println("Patient inséré avec succès !");
    } else {
        System.out.println("Échec de l'insertion du patient.");
    }
    break;



                case 2:
                    System.out.println("Entrer le nom complet du médecin : ");
                    String nomCompletM = sc.next();
                    Medecin medecin = new Medecin();
                    medecin.setNomComplet(nomCompletM);
                    medecin.setType(2);
                    System.out.println("Entrer la spécialité du médecin : ");
                    String specialite = sc.next();
                    medecin.setSpecialite(specialite);

                    int resultM = medecinServiceImpl.add(medecin);

                    if (resultM > 0) {
                        System.out.println("Médecin inséré avec succès !");
                    } else {
                        System.out.println("Échec de l'insertion du médecin.");
                    }
                    break;

            
                case 3:
                    System.out.println("Planifier un rendez-vous :");
                    System.out.print("Date et heure du rendez-vous (jj/mm/aaaa hh:mm) : ");
                    String dateHeure = sc.next();
                    break;
                
                case 4:
                    System.out.println("Afficher les rendez-vous du jour :");
            
                    break;

                case 5:
                    System.out.println("Afficher les rendez-vous d'un médecin par jour :");
                    System.out.print("Nom du médecin : ");
                    String nomMedecin = sc.next();
                    System.out.print("Date (jj/mm/aaaa) : ");
                    String date = sc.next();
                    break;

                    case 6:
                    System.out.println("Annuler un rendez-vous :");
                    
                    break;

                case 7:
                    System.out.println("Fermeture de l'application. Au revoir!");
                    break;
                default:
                    break;
            }
        } while (choix != 7);
        sc.close();
    }
}
