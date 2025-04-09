package ps2.lab08;



import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

@Entity
public class Musicas{
    @Id @GeneratedValue
    private long id;
    private String titulo;
    private String compositor;
    private int ano;

    public Musicas(String t, String c, int a){
        this.titulo = t;
        this.compositor = c;
        this.ano = a;
    }

    public String getTitulo(){
        return titulo;
    }
    public String getCompositor(){
        return compositor;
    }
    public int getAno(){
        return ano;
    }

    public void setTitulo(String t){
        titulo = t;
    }
    public void setCompositor(String c){
        compositor = c;
    }
    public void setAno(int a){
        ano = a;
    }

    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }

}