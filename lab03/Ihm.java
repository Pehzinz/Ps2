import java.util.*;
import static java.lang.System.out;

public class Ihm {
    private GerenciadorNomes g;
    private Scanner entrada = new Scanner(System.in);

    public Ihm(GerenciadorNomes g){
        this.g = g;
    }

    public void dialogar(){
        boolean sair = false;

        while(!sair){
            out.println("GERENCIADOR DE NOMES");
            out.println("(1) listar Nomes");
            out.println("(2) Adicionar Nomes");
            out.println("(3) Sair"); 

            String op = entrada.nextLine();

            switch(op){
                case "1": 
                    listar();
                    break;
                
                case "2":
                    adicionar();
                    break;

                case "3": 
                    sair = true;
                    break;

                default:
                    out.println("Opcao invalida!");
            } 
        }
        out.println("\nFim do programa");
    }

    private void listar(){
        List<String> nomes = g.obterNomes();
        out.println("\n>> Lista de nomes: ");
        for (String nome : nomes){
            out.println(nome);
        }
        System.out.println();
    }

    private void adicionar(){
        out.println("\n>> Digite o novo nome: ");
        String novoNome = entrada.nextLine();
        g.adicionarNome(novoNome); // Corrigido para usar o nome correto do método
    }
}