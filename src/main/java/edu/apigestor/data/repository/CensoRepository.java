package edu.apigestor.data.repository;

import edu.apigestor.entity.domain.Censo;
import edu.apigestor.entity.domain.Censo.CensoKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface CensoRepository extends Repository<Censo, CensoKey> {

  @Query(nativeQuery = true,
      value = "SELECT *, " +
          "MATCH(nomeEscola) " +
          "AGAINST(?1 IN NATURAL LANGUAGE MODE) as s FROM censo " +
          "WHERE existeFundamental>0 AND ano=2020 " +
          "ORDER BY s DESC " +
          "LIMIT ?2")
  List<Censo> getSchoolsSimilar(String schoolName, int limit);

  @Query(nativeQuery = true, value = "SELECT * FROM censo WHERE "
          + "codEscola = ?1 AND "
          + "ano = ?2  AND "
          + "existeFundamental = 1")
  Censo getCenso(int codEscola, int year);

  @Query(nativeQuery = true,
          value = "SELECT COUNT(*) FROM censo WHERE "
          + "codEscola = ?2 AND "
          + "ano = ?1")
  long countCensoByAnoAndCodINEP(long ano, long codINEP);

}
