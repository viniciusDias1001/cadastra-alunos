package br.ufpb.dcx.rodrigor.atividade.matricular_alunos.controleAcademico;

public class Aluno {


    private String nome;
    private String matricula;

    public Aluno(String matricula, String nome){
        this.nome = nome;
        this.matricula = matricula;
    }

    public String toString(){
        return this.matricula+"\t"+this.nome;
    }


}
