package trabalho.tvc8.pedro;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryObservacaoGeral extends JpaRepository<ObservacaoGeral, Long> {
    
    
    public List<ObservacaoGeral> findByIdProjeto(Long idProjeto);
    //public EscalaGeral findByEsc(Long esc);
    
}
