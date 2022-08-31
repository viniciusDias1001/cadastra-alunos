import java.util.ArrayList;
import javax.swing.JOptionPane;




public class plataforma {


     public static  final ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
     public static final ArrayList listaMatricula = new ArrayList<>();
     public static final ArrayList <String> turma01 = new ArrayList<>();
     public static final ArrayList<String> turma02 = new ArrayList<>();
     public static final ArrayList<Diciplina> disciplinas = new ArrayList<>();
     
     
     


     
     
     public static void main(String[] args) {


       
         
         System.out.println("Olá ta pegando");
         
         
         boolean sair = false;
         String saindo = "Sair";
         
        while(!sair){
            
            String opcao = JOptionPane.showInputDialog(null, "Selecione uma abaixo: "
			+ "\n[ 1 ] Cadastrar Aluno"
			+ "\n[ 2 ] Cadastra aluno em uma turma"
            + "\n[ 3 ] Ver lista de alunos e suas matriculas"
			+ "\n[ 4 ] Ver lista de alunos em cada turma"
			+ "\n[ 5 ] Criar disciplinas"
            + "\n[ 6 ] Ver Algumas Disciplinas e seus Horarios"
			+ "\n[ 7 ] Encerrar programa", "Sistema academico", JOptionPane.QUESTION_MESSAGE);
          
            boolean continuar;

            
            switch (opcao) {
                //Adicionar aluno e gerar matricula//
                case "1":
                
                try {
                    
                    Aluno aluno1 = new Aluno();
                    
                    listaAlunos.add(aluno1);
                    JOptionPane.showMessageDialog(null, "Aluno adicionado com sucesso", "Adicionar aluno", JOptionPane.INFORMATION_MESSAGE);
                    aluno1.gerarMatricula();
                    listaMatricula.add(aluno1.getMatricula());
                    
                    Boolean letras = aluno1.getNome().contains("^[a-Z]");
                    letras = false;
                    
                    
                } catch (NumberFormatException n) {
                    
                    JOptionPane.showMessageDialog(null, "Digite um nome válido","Erro", JOptionPane.ERROR_MESSAGE);
                    throw n;
                    
                }

                    break;
    
                case "2":

                   String opcaoTurma = JOptionPane.showInputDialog(null, "Selecione uma abaixo: "
                   + "\n[ 1 ] Turma 01"
                   + "\n[ 2 ] Turma 02"
                  , JOptionPane.QUESTION_MESSAGE);

                   switch (opcaoTurma) {
                    case "1":

                    String lista = " ";
                    for (Aluno listaGeral : listaAlunos) {

                        lista += listaGeral.toString(); 
                      
                    }

                     String escolha = JOptionPane.showInputDialog(null, "Qual desses alunos deseja adicionar a turma 01 (OBS: Digite o nome completo)  \n " + lista, "Escolha", JOptionPane.INFORMATION_MESSAGE);
            
                        turma01.add(escolha);
                         JOptionPane.showMessageDialog(null, "Aluno adicionado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                                    
                                  
                        break;


                    case "2":

                    String lista2 = " ";
                    for (Aluno listaGeral2 : listaAlunos) {

                        lista2 += listaGeral2.toString(); 
                      
                    }
                    

                     String escolha2 = JOptionPane.showInputDialog(null, "Qual desses alunos deseja adicionar a turma 01  \n " + lista2, "Escolha", JOptionPane.INFORMATION_MESSAGE);
                     turma02.add(escolha2);
                     JOptionPane.showMessageDialog(null, "Aluno adicionado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        

                    break;
                   
                    default:
                        break;
                   }




                
                break;

                 //Ver lista de alunos e matriculas//
                case "3":
                String lista = " ";
                
               
                  for (Aluno listaGeral : listaAlunos) {

                      lista += listaGeral.toString(); 
                    
                  }

                  JOptionPane.showMessageDialog(null, lista, "Lista de Alunos e suas Matriculas", JOptionPane.INFORMATION_MESSAGE);
       
                


                break;


                case "4":

                String escolha = JOptionPane.showInputDialog(null, "Qual turma dessa ver a lista de alunos \n Turma 01 \n Turma 02", "Escolha", JOptionPane.INFORMATION_MESSAGE);
                if(escolha.toUpperCase().equals("1")){
                    String listaTurma01 = "";
                    for (String a : turma01) {

                        listaTurma01 += a.toString() + "\n";
                        
                    }
                    JOptionPane.showMessageDialog(null, "lista de alunos: \n" + listaTurma01, "Lista de alunos da Turma 01", JOptionPane.INFORMATION_MESSAGE);
                } else{

                    String listaTurma02 = "";

                    for (String b : turma02) {

                        listaTurma02 += b.toString() + "\n";
                        
                    }
                    JOptionPane.showMessageDialog(null, "lista de alunos: \n" + listaTurma02, "Lista de alunos da Turma 02", JOptionPane.INFORMATION_MESSAGE);

                }



                break;


                case "5":

                

                Diciplina disciplina = new Diciplina();

                JOptionPane.showConfirmDialog(null, "Disciplina criada com sucesso", "Criação de Disciplina", JOptionPane.PLAIN_MESSAGE);
                  
               int deseja =  JOptionPane.showConfirmDialog(null, "Deseja adicionar essa disciplina a lista de Disciplinas do seu curso ?", "Adicionar Disciplina", JOptionPane.YES_NO_OPTION,
                 JOptionPane.QUESTION_MESSAGE);

                 if (deseja == JOptionPane.YES_OPTION) {

                    disciplinas.add(disciplina);

                     JOptionPane.showConfirmDialog(null, "Disciplina adicionada com sucesso", "Sucesso", JOptionPane.PLAIN_MESSAGE);
                        
                 } else{

                    JOptionPane.showMessageDialog(null, "Se eu fosse tu, eu colocava viss boy", "TEM CERTEZA????", JOptionPane.WARNING_MESSAGE);
                    break;
                 }




                break;


                case "6":

                String saida = " ";

                for (Diciplina d : disciplinas) {
                    saida += d.toString();
                    
                }


                JOptionPane.showMessageDialog(null,"Displinas já criadas: " + "\n" + saida , "Lista de Displinas e seus Horarios", JOptionPane.INFORMATION_MESSAGE);

                break;


                case "7":
                     sair = true;
                break;
            
                default:
				JOptionPane.showMessageDialog(null, "Operação inexistente! Tente novamente!", "OPÇÃO INVALIDA", JOptionPane.ERROR_MESSAGE);
				break;
            }
        }
        
    }
    
}
