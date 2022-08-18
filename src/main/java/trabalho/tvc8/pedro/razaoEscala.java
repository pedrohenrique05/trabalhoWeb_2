package trabalho.tvc8.pedro;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class razaoEscala {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotBlank(message = "É preciso a razão!")
    String razao;
 
    

    public razaoEscala(Long id, @NotBlank(message = "É preciso a razão!") String razao) {
        this.id = id;
        this.razao = razao;
    }

    public razaoEscala(Long id) {
        this(id,null);
    }

    public razaoEscala(){
        this(null,null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    @Override
    public String toString() {
        return "razaoEscala [id=" + id + ", razao=" + razao + "]";
    }

        
    
}
