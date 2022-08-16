package trabalho.tvc8.pedro;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryObservacaoGeral extends JpaRepository<ObservacaoGeral, Long> {
    
    @Query(value="SELECT obs.* FROM ObservacaoGeral obs WHERE obs.idProjeto=(?idprojeto)", nativeQuery = true)
    List<ObservacaoGeral> listarObservacoes(@Param("idprojeto") Long idProjeto);
    

   // @Query( value = "select * from minhas_receitas where (MONTH(data_receita) = 
    //?1 and YEAR(data_receita) = ?2) or (usuario_id = ?3) ",
    //        nativeQuery = true
    //)
    //List<MinhasReceitas> buscarPorAnoByUsuario(String mes, String ano, Long usuarioId);
}
