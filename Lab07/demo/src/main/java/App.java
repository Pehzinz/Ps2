import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import static java.lang.System.out;
import java.util.Scanner;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private ProfessorRepo professorRepo;

    @Autowired
    private FaculdadeRepo faculdadeRepo;

    private static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) {
        while (true) {
            out.println("\n# Menu Principal");
            out.println("(1) Cadastrar Faculdade");
            out.println("(2) Listar Faculdades");
            out.println("(3) Cadastrar Professor");
            out.println("(4) Listar Professores");
            out.println("(5) Sair");
            out.print("Escolha uma opção: ");
            
            int opcao = Integer.parseInt(entrada.nextLine());
            switch (opcao) {
                case 1:
                    cadastrarFaculdade();
                    break;
                case 2:
                    listarFaculdades();
                    break;
                case 3:
                    cadastrarProfessor();
                    break;
                case 4:
                    listarProfessores();
                    break;
                case 5:
                    out.println("Saindo...");
                    return;
                default:
                    out.println("Opção inválida!");
            }
        }
    }

    private void cadastrarFaculdade() {
        out.print("Nome da nova faculdade: ");
        String nome = entrada.nextLine();
        out.print("Ano de fundação: ");
        int ano = Integer.parseInt(entrada.nextLine());
        Faculdade faculdade = new Faculdade(nome, ano);
        faculdadeRepo.save(faculdade);
        out.println("Faculdade cadastrada com sucesso!");
    }

    private void listarFaculdades() {
        Iterable<Faculdade> faculdades = faculdadeRepo.findAll();
        out.println("\nFaculdades cadastradas:");
        for (Faculdade f : faculdades) {
            out.println(f.getId() + " - " + f.getNome());
        }
    }

    private void cadastrarProfessor() {
        out.print("Nome do novo professor: ");
        String nome = entrada.nextLine();
        out.print("CPF do novo professor: ");
        String cpf = entrada.nextLine();
        out.print("Matrícula do novo professor: ");
        int matricula = Integer.parseInt(entrada.nextLine());

        List<Faculdade> faculdades = (List<Faculdade>) faculdadeRepo.findAll();
        if (faculdades.isEmpty()) {
            out.println("Nenhuma faculdade cadastrada. Cadastre uma antes de adicionar professores.");
            return;
        }

        out.println("Faculdade do novo professor (selecione um dos números abaixo):");
        for (int i = 0; i < faculdades.size(); i++) {
            out.println("(" + (i + 1) + ") " + faculdades.get(i).getNome());
        }
        out.print("Entre o número da faculdade: ");
        int escolha = Integer.parseInt(entrada.nextLine()) - 1;
        
        if (escolha < 0 || escolha >= faculdades.size()) {
            out.println("Opção inválida!");
            return;
        }

        Professor professor = new Professor(nome, cpf, matricula);
        professor.setFaculdade(faculdades.get(escolha));
        professorRepo.save(professor);
        out.println("Professor cadastrado com sucesso!");
    }

    private void listarProfessores() {
        Iterable<Professor> professores = professorRepo.findAll();
        out.println("\nID    NOME          CPF          MATRÍCULA     FACULDADE");
        for (Professor p : professores) {
            out.printf("%d    %s    %s    %d    %s\n", p.getId(), p.getNome(), p.getCpf(), p.getMatricula(), p.getFaculdade().getNome());
        }
    }
}
