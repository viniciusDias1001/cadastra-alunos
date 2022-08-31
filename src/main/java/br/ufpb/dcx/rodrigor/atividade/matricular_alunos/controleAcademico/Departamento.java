package br.ufpb.dcx.rodrigor.atividade.matricular_alunos.controleAcademico;

import java.util.*;

public class Departamento {

    private String nome;
    private Map<String,Disciplina> disciplinas;

    public Departamento(String nome) {
        this.nome = nome;
        disciplinas = new LinkedHashMap<>();
    }

    public Disciplina criarDisciplina(String codigo, String nome) {
//        if(disciplinas.containsKey(codigo)) {
//            throw new DepartamentoException("Já existe uma disciplina com o código '"+codigo+"'");
//        }
        Disciplina novaDisciplina = new Disciplina(codigo,nome);
        disciplinas.put(codigo,novaDisciplina);
        return novaDisciplina;
    }

    public String getNome() {
        return this.nome;
    }

    public Disciplina getDisciplina(String codigo) {
        return this.disciplinas.get(codigo);
    }

    public Collection<Disciplina> getDisciplinas() {
        return this.disciplinas.values();
    }

    public Set<String> getCodigos(){
        return this.disciplinas.keySet();
    }

}
