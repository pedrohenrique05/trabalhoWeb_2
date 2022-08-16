package trabalho.tvc8.pedro;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class ProjetoGeral {

    @NotBlank(message = "E preciso um titulo!")
    private String titulo;

    @NotBlank(message = "E preciso a url do repositorio!")
    private String urlRepositorio;

    @NotBlank(message = "E preciso a url do perfil principal do projeto!")
    private String urlPerfil;

    @OneToMany
    private List<ObservacaoGeral> obs;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 


    
    

    public ProjetoGeral(Long id,
            @NotBlank(message = "E preciso um titulo!") String titulo,
            @NotBlank(message = "E preciso a url do repositorio!") String urlRepositorio,
            @NotBlank(message = "E preciso a url do perfil principal do projeto!") String urlPerfil,
            List<ObservacaoGeral> obs) {
        this.titulo = titulo;
        this.urlRepositorio = urlRepositorio;
        this.urlPerfil = urlPerfil;
        this.obs = obs;
        this.id = id;
    }

    public ProjetoGeral(Long id, String titulo, String urlRepositorio,String urlPerfil){
        this(id,titulo,urlRepositorio,urlPerfil,null);
    }

    public ProjetoGeral(Long id, String titulo, String urlRepositorio){
        this(id,titulo,urlRepositorio,null,null);
    }

    public ProjetoGeral(Long id, String titulo){
        this(id,titulo,null,null,null);
    }

    public ProjetoGeral(long id){
        this(id,null,null,null,null);
    }

    public ProjetoGeral(){
        this(null,null,null,null,null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrlRepositorio() {
        return urlRepositorio;
    }

    public void setUrlRepositorio(String urlRepositorio) {
        this.urlRepositorio = urlRepositorio;
    }

    public String getUrlPerfil() {
        return urlPerfil;
    }

    public void setUrlPerfil(String urlPerfil) {
        this.urlPerfil = urlPerfil;
    }

    public List<ObservacaoGeral> getObs() {
        return obs;
    }

    public void setObs(List<ObservacaoGeral> obs) {
        this.obs = obs;
    }

    @Override
    public String toString() {
        return "ProjetoGeral [id=" + id + ", obs=" + obs + ", titulo=" + titulo + ", urlPerfil=" + urlPerfil
                + ", urlRepositorio=" + urlRepositorio + "]";
    }

    


    

        
    
}
