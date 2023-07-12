import java.util.Scanner;

public class Cellulare {   
    
    double creditoDisponibile = 0.0;
    int chiamateEffettuate = 0; 
    double tariffa = 0.0; 
    int minutiChiamata; 
    double costoChiamata = 0.0; 
    String destinatarioChiamata = " ";  
    Scanner input = new Scanner(System.in);

    public void ricaricaCredito() {   // digitare 1
    
        System.out.println("Quanto vuoi ricaricare ?");
        double nuovaRicarica = input.nextDouble(); 
        creditoDisponibile += nuovaRicarica; 
        System.out.println("Ricarica Eseguita con successo");
        System.out.println("Il tuo nuovo credito è: " + Math.round(creditoDisponibile*100.00)/100.00 + " euro"); 
        System.out.println("");

    }


    public void eseguiChiamata(){   // digitare 3

        if (tariffa > 0) {

            System.out.println("Chi vuoi chiamare?");

            input.nextLine();

            String newDestinatarioChiamata = input.nextLine();
            destinatarioChiamata = newDestinatarioChiamata; 

            System.out.println("Di quanti minuti è la tua chiamata?");
    
            minutiChiamata = input.nextInt();

            costoChiamata = minutiChiamata * tariffa; 

            if ( creditoDisponibile >= (costoChiamata)) {

                System.out.println("Il tuo credito è sufficiente");

                chiamateEffettuate++; 
                creditoDisponibile -= costoChiamata; 
                System.out.println("Chiamata effettuata, Hai chiamato: " + destinatarioChiamata);
                System.out.println("Costo chiamata: " + Math.round(costoChiamata*100.0)/100.0);
                System.out.println("Il tuo nuovo credito disponibile è " + Math.round(creditoDisponibile*100.0)/100.0);
                System.out.println("");

            } else {
        
                System.out.println("Chiamata terminata , credito non sufficiente."); }
                System.out.println("");
                creditoDisponibile = 0; 
                chiamateEffettuate++;

        } else { 

            System.out.println("Sei sprovvisto di un piano tariffario");
            System.out.println("");
        }

    }

    public void mostraCredito(){ // digitare 4 
        
        System.out.println("Il credito disponibile è " + Math.round(creditoDisponibile*100.00)/100.00);
        System.out.println("");

    }

    public void chiamateEffettuate(){  // digitare 5
        
        System.out.println("Totale chiamate effettuate: " + chiamateEffettuate);
        System.out.println("");

    }

    public void azzeramentoChiamate() {   // digitare 6
        
        chiamateEffettuate = 0; 
        System.out.println("Nuovo totale chiamate effettuate: " + chiamateEffettuate);
        System.out.println("");

    }

    public void impostaTariffa(){ // digitare 2 
        
        double newTariffa = 0.0; 

        if ( tariffa > 0) {
            System.out.println("Inserisci la tua nuova tariffa");
            newTariffa = input.nextDouble(); 
            tariffa = newTariffa; 
            System.out.println("La tua nuova tariffa attuale è: " + tariffa + " euro al minuto");
    
        } else {
    
            System.out.println("Tariffa non valida");
    
        }
    }

    
public void menuPrincipale() { 

    int numeroDigitato = 0; 


        while (numeroDigitato != 7) {

            System.out.println("Gentile Cliente: digita 1 per ricaricare");
            System.out.println("Digita 2 per impostare la tariffa"); 
            System.out.println("Digita 3 per chiamare"); 
            System.out.println("Digita 4 per visualizzare il credito disponibile"); 
            System.out.println("Digita 5 per visualizzare le chiamate effettuate");
            System.out.println("Digita 6 per azzerare il numero di chiamate effettuate");
            System.out.println("Digita 7 per annullare");

            numeroDigitato = input.nextInt();
         

            switch (numeroDigitato) {

                case 1: 
    
                    ricaricaCredito();
                    break; 
                
                case 2: 
        
                impostaTariffa(); 
                    break;         
        
                case 3: 

                eseguiChiamata();
                    break; 

                case 4:
                
                mostraCredito(); 
                break; 
                
                case 5:

                chiamateEffettuate(); 
                break; 

                
                case 6:
                azzeramentoChiamate(); 
                break; 
        
                
                case 7:
        
                        System.out.println("Ritorno indietro...");
        
                    break; 
        
                default: 

                System.out.println("Numero digitato errato");
                    break;
            
                }

        } input.close();


        }
    }

        
