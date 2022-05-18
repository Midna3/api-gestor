package edu.apigestor.data.repository;

import edu.apigestor.entity.domain.Censo;
import edu.apigestor.entity.domain.Censo.CensoKey;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface CensoRepository extends Repository<Censo, CensoKey> {

  @Query(nativeQuery = true,
      value = "SELECT *, " +
          "MATCH(nomeEscola) " +
          "AGAINST(?1 IN NATURAL LANGUAGE MODE) as s FROM censo " +
          "WHERE existeFundamental>0 AND ano=2020" +
          "ORDER BY s DESC " +
          "LIMIT ?2")
  List<Censo> getSchoolsSimilar(String schoolName, int limit);

}
