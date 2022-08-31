package br.ufpb.dcx.rodrigor.atividade.matricular_alunos.controleAcademico;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Disciplina {

    private String codigo;
    private String nome;
    private List<Turma> turmas;

    public Disciplina(String codigo, String nome){
        this.codigo = codigo;
        this.nome = nome;
        this.turmas = new ArrayList<>();
    }


    public Turma criarTurma(){
        Turma novaTurma = new Turma(this,turmas.size()+1);
        this.turmas.add(novaTurma);
        return novaTurma;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String toString(){
        StringBuffer disciplinaStr = new StringBuffer(this.codigo+" - "+this.nome);
        if(!this.turmas.isEmpty()){
            disciplinaStr.append(" - turma(s): ");
            for(Turma turma: turmas)
                disciplinaStr.append(turma.getNumeroTurma()+" ");
        }
        return disciplinaStr.toString() ;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public List<Turma> getTurmas() {
        return this.turmas;
    }

    public Turma getTurma(int turma) {
        return this.turmas.get(turma-1);
    }
}
