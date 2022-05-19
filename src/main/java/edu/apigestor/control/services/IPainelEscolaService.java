package edu.apigestor.control.services;


import edu.apigestor.entity.response.PainelEscolaResponse;
import org.springframework.http.ResponseEntity;

/**
 * Essa interface define os serviços que podem ser realizados para o painel da escola:
 *
 * <ul>
 *   <li> Buscar todas informações de uma escola.</li>
 * </ul>
 */
public interface IPainelEscolaService {

    ResponseEntity<PainelEscolaResponse> dataEscola(int codINEP, int year);

}
