package ps2.lab08;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import static java.lang.System.out;
import java.util.Scanner;

@SpringBootApplication
public class Lab08Application implements CommandLineRunner {
	private Scanner entrada = new Scanner(System.in);


	@Autowired
	private MusicasRepo musicasRepo;

	private void cadastrarMusica(){
		out.print("Titulo: ");
		String titulo = entrada.nextLine();
		out.print("Compositor: ");
		String compositor = entrada.nextLine();
		out.print("Ano da musica: ");
		int ano = Integer.parseInt(entrada.nextLine());

		Musicas musica = new Musicas(titulo, compositor, ano);
		musicasRepo.save(musica);
	}



	private void listarMusicas(){
		Iterable<Musicas> musicas = musicasRepo.findAll();
		out.println("\n Musicas cadastradas");
		for(Musicas m : musicas){
			out.println(m.getTitulo() + " - " + m.getCompositor() + " - " + m.getAno());
		}
	}






	@Override
	public void run(String... args){
		while(true){
			out.println("Cadastrar musica");
			out.println("listar musicas");
			out.println("Sair");

			int opc = Integer.parseInt(entrada.nextLine());

			switch(opc) {
				case 1:
					cadastrarMusica();
					break;

				case 2:
					listarMusicas();
					break;
				
				default:
					out.println("Opção invalida");
			}
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(Lab08Application.class, args);
	}

}
