import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class GerenciadorNomesArq implements GerenciadorNomes{


    @Override
    public List<String> obterNomes(){
        List<String> nomes = new ArrayList<String>();
        try{
            FileReader arq = new FileReader("arquivo.txt");  //caminho do arquivo
            BufferedReader lerArq = new BufferedReader(arq); //abre o arquivo para leitura;
            String linha = lerArq.readLine(); //le linha por linha do arquivo aberto

            while(linha != null){
                nomes.add(linha);  //add as linhas no vetor de nomes - salvando info do arquivo;
                linha = lerArq.readLine(); //para ler a proxima linha - podia estar dentro de um for tambem, para rodar todas as linhas
            }
            lerArq.close();  //fechar o arquivo aberto - pois nao precisara mais dele;


        } catch(IOException e){
            System.out.println("Erro ao tentar ler o arquivo");
            e.getMessage();
        }
        return nomes;
    }


    @Override
    public void adicionarNome(String nome) {
        Path arq = Paths.get("arquivo.txt");
        try{
            Files.writeString(arq, nome + System.lineSeparator(), StandardOpenOption.APPEND);
            System.out.println("Nome add com sucesso!\n");

        } catch(IOException e){
            System.out.println("Erro ao tentar escrever no arquivo");
            e.printStackTrace();
        }
    }    
}
