import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Diciplina {
 private String nome;
 private String horario;


 Diciplina(){
     String  nome = JOptionPane.showInputDialog(null, "Diga o nome da disciplina","Nome da Disciplina", JOptionPane.QUESTION_MESSAGE);
     this.nome = nome;

     String hora = JOptionPane.showInputDialog(null, "Digite o horario da disciplina " + "\n" + "Exemplo de horário 8-10 AM (OBS: Siga tal padrão)","Horário da Disciplina",JOptionPane.QUESTION_MESSAGE);
    
     this.horario = hora;

 }


public String getNome() {
    return nome;
}


public void setNome(String nome) {
    this.nome = nome;
}


public String getHorario() {
    return horario;
}


public void setHorario(String horaio) {
    this.horario = horaio;
}


 public String toString(){

    String saida = getNome() + " ->  Horário: " + getHorario() + "\n";
    return  saida;
 }

}