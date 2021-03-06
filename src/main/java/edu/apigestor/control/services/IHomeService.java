package edu.apigestor.control.services;

import edu.apigestor.entity.response.HomeDadosNacionalResponse;
import edu.apigestor.entity.response.HomeDadosRegionalResponse;
import edu.apigestor.entity.response.HomeEscolaResponse;
import org.springframework.http.ResponseEntity;

/**
 * Essa interface define os serviços que podem ser realizados pela home:
 *
 * <ul>
 *   <li> Buscar dados gerais da educação para um país.</li>
 *   <li> Buscar dados gerais da educação para uma região.</li>
 *   <li> Buscar dados gerais da educação para um estado.</li>
 *   <li> Buscar uma lista de escolas com nomes similares a uma String.</li>
 * </ul>
 */
public interface IHomeService {

  /**
   * Retorna dados da educação para um país em um dado ano.
   *
   * @param country país.
   * @param year    ano dos dados.
   * @return uma resposta contendo esses dados ou uma informação de erro.
   */
  ResponseEntity<HomeDadosNacionalResponse> dataCountry(String country, int year);

  /**
   * Retorna uma lista de escolas com nome similar ao digitado.
   *
   * @param name  nome da escola.
   * @param limit limite da quantidade de escolas.
   * @return uma resposta contendo esses dados ou uma informação de erro.
   */
  ResponseEntity<HomeEscolaResponse> listSchool(String name, int limit);

  ResponseEntity<HomeDadosRegionalResponse> dataRegion(String country, int year);
}
