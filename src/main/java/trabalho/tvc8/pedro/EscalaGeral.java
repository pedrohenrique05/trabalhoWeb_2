package trabalho.tvc8.pedro;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;





@Entity
public class EscalaGeral {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotBlank(message = "E preciso um nome!")
    String nome;

    @NotBlank(message = "E preciso a url para a sua descrição!")
    String urlDescricao;

    
    Boolean good;


    Boolean badSmells;


    
    public EscalaGeral(Long id, @NotBlank(message = "E preciso um nome!") String nome,
            @NotBlank(message = "E preciso a url para a sua descrição!") String urlDescricao, Boolean good,
            Boolean badSmells) {
        this.id = id;
        this.nome = nome;
        this.urlDescricao = urlDescricao;
        this.good = good;
        this.badSmells = badSmells;
    }

    

    public EscalaGeral(Long id, @NotBlank(message = "E preciso um nome!") String nome,
            @NotBlank(message = "E preciso a url para a sua descrição!") String urlDescricao, Boolean good) {
        this(id,nome,urlDescricao,good,null);
    }

    



    public EscalaGeral(Long id, @NotBlank(message = "E preciso um nome!") String nome,
            @NotBlank(message = "E preciso a url para a sua descrição!") String urlDescricao) {
        this(id,nome,urlDescricao,null,null);
    }

    

    public EscalaGeral(Long id, @NotBlank(message = "E preciso um nome!") String nome) {
        this(id,nome,null,null,null);
    }
    
    public EscalaGeral(Long id) {
        this(id,null,null,null,null);
    }

    public EscalaGeral(){
        this(null,null,null,null,null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrlDescricao() {
        return urlDescricao;
    }

    public void setUrlDescricao(String urlDescricao) {
        this.urlDescricao = urlDescricao;
    }

    public Boolean getGood() {
        return good;
    }

    public void setGood(Boolean good) {
        this.good = good;
    }

    public Boolean getBadSmells() {
        return badSmells;
    }

    public void setBadSmells(Boolean badSmells) {
        this.badSmells = badSmells;
    }

    @Override
    public String toString() {
        return "Escala [badSmells=" + badSmells + ", good=" + good + ", id=" + id + ", nome=" + nome + ", urlDescricao="
                + urlDescricao + "]";
    }

    

    
}
