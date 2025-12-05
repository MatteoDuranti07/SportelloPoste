/**
 * Classe che implementa il thread per il totem touch screen che aggiunge
 * i clienti alla lista di attesa e genera il numero di attesa.
 * rappresenta il produttore
 * @author frida
 * @version 1.0
 */
public class GestoreArrivi implements Runnable {

    /* variabili d'istanza sono;
     * la risorsa condivisa listaClienti */
    private ListaClienti listaClienti;
    private int totem;
    /* ms fra un arrivo e l'altro */
    private final int attesaArrivi = 1000;
    /**
     * constructor
     * @param listaClienti
     */
    public GestoreArrivi(ListaClienti listaClienti, int totem) {
        this.listaClienti = listaClienti;
        this.totem = totem;
    }
    /**
     * @see Runnable
     */
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Thread.sleep(attesaArrivi);
                Integer clienteArrivato = listaClienti.addCliente(totem);
                if (clienteArrivato == null) {
                    break;
                }

            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrotto durante lo sleep");
        } finally {
            System.out.println("Posta Chiusa");
        }
    }
}
