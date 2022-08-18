package trabalho.tvc8.pedro;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;

import javax.validation.constraints.NotBlank;

//import dcc193.tvc8.trabalho.escala.Escala;

@Entity
public class ObservacaoGeral {
    //@NotBlank(message = "E preciso o ID do projeto!")
    private Long idProjeto;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @NotBlank(message = "E preciso um nome!")
    String nome;
    @NotBlank(message = "E preciso a url para a sua descrição!")
    String urlDescricao;
    //@NotBlank(message = "E preciso uma única escala a que pertence!")
    
    //@ManyToOne(cascade = CascadeType.ALL)
    //Escala esc;
    //Escala esc ;
    //String esc;
    Long esc;


    
    public ObservacaoGeral(Long id, @NotBlank(message = "E preciso um nome!") String nome,
            @NotBlank(message = "E preciso a url para a sua descrição!") String urlDescricao,
            @NotBlank(message = "E preciso uma única escala a que pertence!") Long esc, Long idProjeto) {
        this.id = id;
        this.nome = nome;
        this.urlDescricao = urlDescricao;
        this.esc = esc;
        this.idProjeto = idProjeto;
    }

    public ObservacaoGeral(Long id, @NotBlank(message = "E preciso um nome!") String nome,
            @NotBlank(message = "E preciso a url para a sua descrição!") String urlDescricao,
            @NotBlank(message = "E preciso uma única escala a que pertence!") Long esc) {
        this(id,nome,urlDescricao,esc,null);
    }

    public ObservacaoGeral(Long id, @NotBlank(message = "E preciso um nome!") String nome) {
        this(id,nome,null,null,null);
    }

    public ObservacaoGeral(Long idProjeto) {
        this(null,null,null,null,idProjeto);
    }

    public ObservacaoGeral() {
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

    public Long getEsc() {
        return esc;
    }

    public void setEsc(Long esc) {
        this.esc = esc;
    }

    public Long getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(Long idProjeto) {
        this.idProjeto = idProjeto;
    }

    @Override
    public String toString() {
        return "ObservacaoGeral [esc=" + esc + ", id=" + id + ", idProjeto=" + idProjeto + ", nome=" + nome
                + ", urlDescricao=" + urlDescricao + "]";
    }

        
}
