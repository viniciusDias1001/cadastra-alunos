import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;


public class Aluno {
    
    private String nome;
    private int matricula;


    Aluno(){
        String nome =JOptionPane.showInputDialog(null, "Digite Seu Nome Completo");
          this.nome = nome;
    }


    public void gerarMatricula(){
        Random random = new Random();
        this.matricula = random.nextInt(5000);   
        JOptionPane.showMessageDialog(null, "Sua matricula é: " + matricula  , "Matricula", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    public String getNome() {
        return nome;
    }
    

    public void setNome(String nome) {
        this.nome = nome;
    }


  


    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getMatricula(){
        return matricula;
    }

    public String toString(){
       String saida = getNome().toUpperCase() + " ->  Matricula: " + getMatricula() + "\n";

       return saida;

    }









}