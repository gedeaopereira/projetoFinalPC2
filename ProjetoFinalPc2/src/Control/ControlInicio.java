package Control;

import View.ViewInicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class ControlInicio implements ActionListener {

    private ViewInicio viewInicio;
    private ArrayList<String> crimes;

    public ControlInicio() {
        this.viewInicio = new ViewInicio();
        this.viewInicio.setVisible(true);
        this.viewInicio.setLocationRelativeTo(null);
        this.viewInicio.getBtn_armas().addActionListener(this);
        this.viewInicio.getBtn_batmovel().addActionListener(this);
        this.viewInicio.getBtn_sair().addActionListener(this);
        this.crimes = new ArrayList<>();
        adicionarCrimes();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("armas".equals(e.getActionCommand())) {
            try {
                ControlArmas controlArmas = new ControlArmas();
            } catch (IOException ex) {
                System.out.println("Erro ao caregar arquivo");
            }
            this.viewInicio.dispose();
        } else if ("batmovel".equals(e.getActionCommand())) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/Sons/batmovel.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                System.out.println("Erro ao executar SOM!" + ex);
            }
            JOptionPane.showMessageDialog(viewInicio, "O batmóvel está pronto para ação!!");
        } else if ("sair".equals(e.getActionCommand())) {
            viewInicio.dispose();
            System.exit(0);
        }
    }

    private void adicionarCrimes() {
        Random gerador = new Random();
        int aleatorio = gerador.nextInt(13);

        this.crimes.add("O Coringa sequestrou dois navios, e está ameaçando explodir");
        this.crimes.add("O Espantalho criou um novo gás tóxico");
        this.crimes.add("O Pinguim está planejando a fulga da prisão");
        this.crimes.add("O Charada está espalhando suas pegadinhas pela cidade");
        this.crimes.add("A Mulher Gato deseja ter um encontro amigável");
        this.crimes.add("O Detetive Gordon está em apuros, em uma briga de gangue");
        this.crimes.add("O Robin enlouqueceu, e está querendo sequelar o Coringa");
        this.crimes.add("O Duas Caras está prestes a botar fogo em um hotel");
        this.crimes.add("O Bayne fugiu da prisão e está devastando a cidade");
        this.crimes.add("Nova reunião da Liga da Justiça");
        this.crimes.add("Flash está sendo coagido a trabalhar de garçom");
        this.crimes.add("O salário do Alfred está atrasado");

        this.viewInicio.getTxt_alerta().setText(this.crimes.get(aleatorio));
    }

}
