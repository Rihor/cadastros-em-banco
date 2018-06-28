package control;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.JanelaThread;
import model.MinhaThread;

public class JanelaThreadControl {

    private JanelaThread janelaThread;
    private MinhaThread thread1, thread2, thread3;
    String selecao;

    public JanelaThreadControl() {
        janelaThread = new JanelaThread();

        thread1 = new MinhaThread("Thread1", 0);
        thread2 = new MinhaThread("Thread2", 0);
        thread3 = new MinhaThread("Thread3", 0);

        janelaThread.comboThread.addItem("Thread1");
        janelaThread.comboThread.addItem("Thread2");
        janelaThread.comboThread.addItem("Thread3");

        selecao = null;

        actions();
    }

    public JanelaThread getJanelaThread() {
        return janelaThread;
    }

    public void setJanelaThread(JanelaThread janelaThread) {
        this.janelaThread = janelaThread;
    }

    private void actions() {

        janelaThread.btnStart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (thread1.getParar()) {
                    try {
                        // thread não podem ser reiniciadas,
                        // então eu recrio ela bem onde ela parou a contagem
                        thread1 = new MinhaThread("Thread1", thread1.getContador());
                        thread2 = new MinhaThread("Thread2", thread2.getContador());
                        thread3 = new MinhaThread("Thread3", thread3.getContador());
                    } catch (Throwable ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                        Logger.getLogger(JanelaThreadControl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                thread1.start();
                thread2.start();
                thread3.start();

                Runnable thread0 = new Runnable() {
                    @Override
                    public void run() {
                        // escreve a contagem ao mesmo tempo que as threads contam
                        JanelaThread.txtArea.append(thread1.getNome() + " : " + thread1.getContador() + "\n");
                        JanelaThread.txtArea.append(thread2.getNome() + " : " + thread2.getContador() + "\n");
                        JanelaThread.txtArea.append(thread3.getNome() + " : " + thread3.getContador() + "\n");

                    }
                };

                thread0.run();

            }

        });

        janelaThread.btnStop.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // para o loop na thread
                thread1.setParar(true);
                thread2.setParar(true);
                thread3.setParar(true);

                // resultado final depois de parar                
                janelaThread.txtArea.append("\n >> Resultado << \n");
                janelaThread.txtArea.append(thread1.getNome() + " : " + thread1.getContador() + "\n");
                janelaThread.txtArea.append(thread2.getNome() + " : " + thread2.getContador() + "\n");
                janelaThread.txtArea.append(thread3.getNome() + " : " + thread3.getContador() + "\n");

            }

        });

        // da valor ao atributo selecao, para poder achar qual thread foi selecionado mais tarde
        janelaThread.comboThread.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                selecao = e.getItem().toString();
            }

        });

        // radio maximo
        janelaThread.rMaxima.addActionListener((ActionEvent e1) -> {
            mudancaPrioridade(selecao, e1);
        });

        // radio normal
        janelaThread.rNormal.addActionListener((ActionEvent e) -> {
            mudancaPrioridade(selecao, e);
        });

        // radio minimo
        janelaThread.rMinima.addActionListener((ActionEvent e) -> {
            mudancaPrioridade(selecao, e);
        });

        // faz com que a rolagem acompanhe a impressão automaticamente
        janelaThread.scroll.getVerticalScrollBar().addAdjustmentListener((ex) -> {
            ex.getAdjustable().setValue(ex.getAdjustable().getMaximum());
        });

    }

    //recebe a selecao do comboBox e a ação do botao Radio
    public void mudancaPrioridade(String selecao, ActionEvent e) {
        switch (selecao) {
            case "Thread1":
                if (janelaThread.rMaxima.isSelected()) {
                    thread1.setPriority(Thread.MAX_PRIORITY);
                } else {
                    if (janelaThread.rMinima.isSelected()) {
                        thread1.setPriority(Thread.MIN_PRIORITY);
                    } else {
                        thread1.setPriority(Thread.NORM_PRIORITY);
                    }
                }
                break;

            case "Thread2":
                if (janelaThread.rMaxima.isSelected()) {
                    thread2.setPriority(Thread.MAX_PRIORITY);
                } else {
                    if (janelaThread.rMinima.isSelected()) {
                        thread2.setPriority(Thread.MIN_PRIORITY);
                    } else {
                        thread2.setPriority(Thread.NORM_PRIORITY);
                    }
                }
                break;

            case "Thread3":
                if (janelaThread.rMaxima.isSelected()) {
                    thread3.setPriority(Thread.MAX_PRIORITY);
                } else {
                    if (janelaThread.rMinima.isSelected()) {
                        thread3.setPriority(Thread.MIN_PRIORITY);
                    } else {
                        thread3.setPriority(Thread.NORM_PRIORITY);
                    }
                }
                break;

            default:
                break;

        }

        JOptionPane.showMessageDialog(janelaThread, selecao + " : " + e.getActionCommand());
    }
}
