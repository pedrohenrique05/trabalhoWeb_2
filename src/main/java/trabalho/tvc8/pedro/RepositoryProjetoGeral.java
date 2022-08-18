package trabalho.tvc8.pedro;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryProjetoGeral extends JpaRepository<ProjetoGeral, Long> {
    
}
