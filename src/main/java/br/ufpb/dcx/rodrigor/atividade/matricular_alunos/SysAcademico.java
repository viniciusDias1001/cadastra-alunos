package br.ufpb.dcx.rodrigor.atividade.matricular_alunos;

import br.ufpb.dcx.rodrigor.atividade.matricular_alunos.controleAcademico.Aluno;
import br.ufpb.dcx.rodrigor.atividade.matricular_alunos.controleAcademico.Departamento;
import br.ufpb.dcx.rodrigor.atividade.matricular_alunos.controleAcademico.Disciplina;
import br.ufpb.dcx.rodrigor.atividade.matricular_alunos.controleAcademico.Turma;

public class SysAcademico {

    private int tamLinha;
    private int margem = 5;
    private Departamento departamento;

    public SysAcademico(String nomeDepartamento) {
        this.tamLinha = nomeDepartamento.length() + 10;
        this.departamento = new Departamento(nomeDepartamento);
    }

    public static void main(String[] args) {
        SysAcademico sys = new SysAcademico("Departamento de Ciências Exatas");
        sys.run();
    }

    public void run(){
        printMenuPrincipal();
    }

    private void printMenuPrincipal() {
        boolean continua = true;
        while(continua) {
            String[] opcoes = {"1", "2", "3", "x"};
            String[] itens = {
                    "Gerenciar Disciplinas",
                    "Matricular Alunos",
                    "Listar Alunos",
                    "Sair"
            };
            String opcao = printMenu(departamento.getNome(), opcoes,itens);
            switch (opcao){
                case "1":
                    printMenuDisciplina();
                    break;
                case "2":
                    matricularAluno();
                    break;
                case "3":
                    listarAlunos();
                    break;
                case "x":
                    Texto.printMargem(margem,"Até logo!");
                    continua = false;
            }
        }
    }


    public String printMenu(String titulo, String[] opcoes,String[] itens){
        if(opcoes.length != itens.length) {
            throw new IllegalArgumentException("O número de opções deve ser igual ao número de itens do menu");
        }

        Texto.printCabecalho(titulo, tamLinha);
        for (int i = 0; i < opcoes.length; i++) {
            Texto.printMargem(margem,opcoes[i]+"\t"+itens[i]);
        }
        Texto.printLine(tamLinha);
        return Texto.selecionarOpcao(opcoes);

    }

    private void printMenuDisciplina(){
        boolean continua = true;
        while(continua) {
            String[] opcoes = {"1", "2", "3", "x"};
            String[] itens = {
                    "Cadastrar Disciplina",
                    "Listar Disciplinas",
                    "Criar Turma",
                    "Voltar"
            };
            String opcao = printMenu("Gerenciar Disciplinas", opcoes,itens);
            switch (opcao){
                case "1":
                    cadastrarDisciplina();
                    break;
                case "2":
                    listarDisciplinas();
                    break;
                case "3":
                    criarTurma();
                    break;
                case "x":
                    continua = false;
            }
        }

    }

    private void matricularAluno() {
        if(departamento.getDisciplinas().isEmpty()) {
            Texto.printMargem(margem, "Não existem disciplinas cadastradas");
            return;
        }
        listarDisciplinas();
        String codDisciplina = Texto.readString("Digite o código da disciplina:");
        if(!departamento.getCodigos().contains(codDisciplina)){
            Texto.printMargem(margem,"Disciplina inexistente '"+codDisciplina+"'");
            return;
        }
        Disciplina disciplina = departamento.getDisciplina(codDisciplina);
        if(disciplina.getTurmas().isEmpty()){
            Texto.printMargem(margem,"Esta disciplina não tem turmas cadastradas!");
            return;
        }
        int numTurma = Texto.readInt("Digite o número da turma:");
        Turma turma = disciplina.getTurma(numTurma);
        if(turma == null){
            Texto.printMargem(margem,"Turma Inválida: "+turma);
            return;
        }
        String nome = Texto.readString("Nome:");
        String matricula = Texto.readString("Matrícula:");
        Aluno novoAluno = new Aluno(matricula,nome);
        turma.matricularAluno(novoAluno);

    }


    private void criarTurma() {
        if(departamento.getDisciplinas().isEmpty()) {
            Texto.printMargem(margem, "Não existem disciplinas cadastradas");
            return;
        }
        listarDisciplinas();
        String codDisciplina = Texto.readString("Digite o código da disciplina");
        if(!departamento.getCodigos().contains(codDisciplina)){
            Texto.printMargem(margem,"Disciplina inexistente '"+codDisciplina+"'");
            return;
        }
        Turma novaTurma = departamento.getDisciplina(codDisciplina).criarTurma();
        Texto.printMargem(margem,"Turma criada: "+novaTurma.getNumeroTurma());
    }

    private void listarDisciplinas() {
        Texto.printCabecalho("Disciplinas cadastradas", tamLinha);
        for(Disciplina disciplina: departamento.getDisciplinas()){
            Texto.printMargem(margem,disciplina.toString());
        }
        Texto.printLine(tamLinha);
    }

    private void listarAlunos() {
        if (departamento.getDisciplinas().isEmpty()){
            Texto.printMargem(margem, "Não há disciplinas cadastradas");
            return;
        }
        Texto.printCabecalho("Alunos matriculados, por disciplina", tamLinha);
        int espaco = 4;
        for(Disciplina disciplina:departamento.getDisciplinas()){
            Texto.printMargem(margem,disciplina.toString());
            Texto.printLine(tamLinha);
            for(Turma turma: disciplina.getTurmas()){
                Texto.printMargem(margem+espaco,"Turma "+turma.getNumeroTurma());
                Texto.printLine(tamLinha);
                for(Aluno aluno: turma.getAlunos()){
                    Texto.printMargem(margem+espaco+espaco,aluno.toString());
                }
            }
        }
    }


    private void cadastrarDisciplina() {
        Texto.printLine(tamLinha);
        String codigo = Texto.readString("Código da disciplina:");
        String nome = Texto.readString("Nome da disciplina:");
        if(departamento.getDisciplina(codigo) != null){
            Texto.printMargem(margem,"Já existe uma disciplina com o código '"+codigo+"'");
        }else {
            departamento.criarDisciplina(codigo, nome);
        }
    }


}
