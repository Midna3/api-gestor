package edu.apigestor.entity.response;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
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
   * @param id identificador.
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public HomeDadosResponse id(long id) {
    this.id = id;
    return this;
  }

  /**
   * Adiciona um ano para essa resposta.
   *
   * @param ano ano dos dados da resposta.
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public HomeDadosResponse ano(int ano) {
    this.data.year = ano;
    return this;
  }

  /**
   * Adiciona o índice de Complexidade de Gestão médio.
   *
   * @param icg      ICG médio.
   * @param category indica qual classe de gestão esse valor se encontra.
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public HomeDadosResponse icg(Double icg, String category) {
    this.data.addMeanICG(icg, category);
    return this;
  }

  /**
   * Adiciona o indicador de esforço docente médio.
   *
   * @param ied      IED médio.
   * @param category indica qual classe de esforço docente esse valor se encontra.
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public HomeDadosResponse ied(Double ied, String category) {
    this.data.addMeanIED(ied, category);
    return this;
  }

  /**
   * Adiciona o indicador de adequação da formação docente médio.
   *
   * @param afd      AFD médio.
   * @param category indica qual classe da adequação de formação docente esse valor se encontra.
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public HomeDadosResponse afd(Double afd, String category) {
    this.data.addMeanAFD(afd, category);
    return this;
  }

  /**
   * Adiciona o indicador de regularidade docente médio.
   *
   * @param ird      IRD médio.
   * @param category indica qual classe do indicador de regularidade esse valor se encontra.
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public HomeDadosResponse ird(Double ird, String category) {
    this.data.addMeanIRD(ird, category);
    return this;
  }

  /**
   * Adiciona o indicador de distorção idade série médio.
   *
   * @param tdi TDI médio.
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public HomeDadosResponse tdi(Double tdi) {
    this.data.addMeanTDI(tdi);
    return this;
  }

  /**
   * Adiciona o Ideb dos anos iniciais.
   *
   * @param idebIniciais IDEB médio.
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public HomeDadosResponse idebIniciais(Double idebIniciais) {
    this.data.addMeanIdebInicial(idebIniciais);
    return this;
  }

  /**
   * Adiciona o Ideb dos anos finais.
   *
   * @param idebFinais IDEB médio.
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public HomeDadosResponse idebFinais(Double idebFinais) {
    this.data.addMeanIdebFinal(idebFinais);
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
    private Map<String, Object> ied = new HashMap<>();
    @JsonProperty("ird")
    private Map<String, Object> ird = new HashMap<>();
    @JsonProperty("tdi")
    private Map<String, Object> tdi = new HashMap<>();
    @JsonProperty("icg")
    private Map<String, Object> icg = new HashMap<>();
    @JsonProperty("afd")
    private Map<String, Object> afd = new HashMap<>();
    @JsonProperty("idebIniciais")
    private Map<String, Object> idebIniciais = new HashMap<>();
    @JsonProperty("idebFinais")
    private Map<String, Object> idebFinais = new HashMap<>();
    @JsonProperty("year")
    private int year; // Ano dos dados

    /**
     * Esse método adiciona uma média do IED nos dados da resposta.
     *
     * @param meanIED  IED médio.
     * @param category categoria.
     */
    private void addMeanIED(Double meanIED, String category) {
      this.ied.put("mean", meanIED);
      this.ied.put("meanCategory", category);
    }

    /**
     * Esse método adiciona uma média do IRD nos dados da resposta.
     *
     * @param meanIRD  IRD médio.
     * @param category categoria.
     */
    private void addMeanIRD(Double meanIRD, String category) {
      this.ird.put("mean", meanIRD);
      this.ird.put("meanCategory", category);
    }

    /**
     * Esse método adiciona uma média do ICG nos dados da resposta.
     *
     * @param meanICG  ICG médio.
     * @param category categoria.
     */
    private void addMeanICG(Double meanICG, String category) {
      this.icg.put("mean", meanICG);
      this.icg.put("meanCategory", category);
    }

    /**
     * Esse método adiciona uma média do AFD nos dados da resposta.
     *
     * @param meanAFD  AFD médio.
     * @param category categoria.
     */
    private void addMeanAFD(Double meanAFD, String category) {
      this.afd.put("mean", meanAFD);
      this.afd.put("meanCategory", category);
    }

    /**
     * Esse método adiciona uma média do TDI nos dados da resposta.
     *
     * @param meanTDI TDI médio.
     */
    private void addMeanTDI(Double meanTDI) {
      this.tdi.put("mean", meanTDI);
    }

    /**
     * Esse método adiciona uma média do IDEB dos anos iniciais nos dados da resposta.
     *
     * @param meanIdebInicial Ideb médio dos anos iniciais.
     */
    private void addMeanIdebInicial(Double meanIdebInicial) {
      this.idebIniciais.put("mean", meanIdebInicial);
    }

    /**
     * Esse método adiciona uma média do IDEB dos anos iniciais nos dados da resposta.
     *
     * @param meanIdebFinal Ideb médio dos anos finais.
     */
    private void addMeanIdebFinal(Double meanIdebFinal) {
      this.idebFinais.put("mean", meanIdebFinal);
    }
  }
}
