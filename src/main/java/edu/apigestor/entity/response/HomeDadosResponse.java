package edu.apigestor.entity.response;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>Essa classe representa uma resposta para solicitações de dados gerais sobre a educação
 * brasileira em algum nível (Nacional, Regional ou Estadual).</p>
 *
 * @author moesiof
 * @version 1.0
 * @see AbstractResponse
 */
public abstract class HomeDadosResponse extends AbstractResponse<Map<String, Object>> {

  private static final String RESOURCE_TYPE = "eduData";

  private final HomeDadosData data = new HomeDadosData();
  private long id; // identificar da resposta

  private boolean hasError = false;

  /**
   * Adiciona um identificador único para essa resposta.
   *
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public HomeDadosResponse id(long id) {
    this.id = id;
    return this;
  }

  /**
   * Adiciona o índice de Complexidade de Gestão médio.
   *
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public HomeDadosResponse icg(Double icg) {
    this.data.meanICG = icg;
    return this;
  }

  /**
   * Adiciona o indicador de esforço docente médio.
   *
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public HomeDadosResponse ied(Double ied) {
    this.data.meanIED = ied;
    return this;
  }

  /**
   * Adiciona o indicador de adequação da formação docente médio.
   *
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public HomeDadosResponse afd(Double afd) {
    this.data.meanAFD = afd;
    return this;
  }

  /**
   * Adiciona o indicador de regularidade docente médio.
   *
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public HomeDadosResponse ird(Double ird) {
    this.data.meanIRD = ird;
    return this;
  }

  /**
   * Adiciona o indicador de distorção idade série médio.
   *
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public HomeDadosResponse tdi(Double tdi) {
    this.data.meanTDI = tdi;
    return this;
  }

  @Override
  protected void handleError() {
    this.hasError = true;
  }

  @Override
  protected Map<String, Object> buildData() {
    if (this.hasError) {
      return null;
    }

    Map<String, Object> data = new LinkedHashMap<>();

    data.put("type", HomeDadosResponse.RESOURCE_TYPE);
    data.put("id", this.id);

    this.data.others = this.additionalAttributes();

    data.put("attributes", this.data);

    return data;
  }

  protected abstract Map<String, Object> additionalAttributes();

  /**
   * Define os dados que compõem uma resposta sobre os dados da educação brasileira. Todos
   * representam uma média.
   *
   * @author moesiof
   * @version 1.0
   */
  private static class HomeDadosData {

    @JsonAnyGetter
    private Map<String, Object> others;
    @JsonProperty("ied")
    private double meanIED; // esforço docente médio
    @JsonProperty("ird")
    private double meanIRD; // regularidade docente média
    @JsonProperty("tdi")
    private double meanTDI; // distorção idade série média
    @JsonProperty("icg")
    private double meanICG; // complexidade de gestão escolar média
    @JsonProperty("afd")
    private double meanAFD; // adequação de formação docente média
  }
}
