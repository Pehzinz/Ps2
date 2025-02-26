import java.util.*;

public interface GerenciadorNomes{
    //variaveis constantes;
    int MAX_CARACTERS_NOMES = 20;

    //metodos abstratos;
    List<String> obterNomes();   

    void adicionarNome(String nome);
}