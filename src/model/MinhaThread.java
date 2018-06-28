package model;

import java.util.logging.Level;
import java.util.logging.Logger;
import view.JanelaThread;

public class MinhaThread extends Thread {

    private String nome;
    private int contador = 1;
    private boolean parar = false;

    public boolean getParar() {
        return parar;
    }

    public void setParar(boolean parar) {
        this.parar = parar;
    }

    public MinhaThread(String nome, int contador) {
        this.nome = nome;
        this.contador = contador;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void run() {
        parar = false;
        
        while (parar == false) {
            JanelaThread.txtArea.append(this.nome + " : " + (++contador) + "\n");
            try {
                sleep(0,1);
            } catch (InterruptedException ex) {
                Logger.getLogger(MinhaThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
