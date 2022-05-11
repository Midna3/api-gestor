package edu.apigestor.entity.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>Essa classe representa uma resposta para solicitações de dados para o Painel de Escolas.</p>
 *
 * @author moesiof
 * @version 1.0
 * @see AbstractResponse
 */
public final class PainelEscolaResponse extends AbstractResponse<Map<String, Object>> {

  private static final String RESOURCE_TYPE = "schoolData";

  private final PainelEscolaData data = new PainelEscolaData();
  private long id; // identificar da resposta
  private boolean hasError = false;

  /**
   * Adiciona um identificador único para essa resposta.
   *
   * @param id identificador.
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public PainelEscolaResponse id(long id) {
    this.id = id;
    return this;
  }

  /**
   * Adiciona um ano para essa resposta.
   *
   * @param ano ano dos dados da resposta.
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public PainelEscolaResponse ano(int ano) {
    this.data.year = ano;
    return this;
  }

  /**
   * Adiciona o nome da escola.
   *
   * @param nameEscola nome da escola.
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public PainelEscolaResponse nameEscola(String nameEscola) {
    this.data.nameEscola = nameEscola;
    return this;
  }

  /**
   * Adiciona o código INEP.
   *
   * @param codINEP código INEP (código da escola).
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public PainelEscolaResponse codINEP(int codINEP) {
    this.data.codINEP = codINEP;
    return this;
  }

  /**
   * Adiciona o endereço.
   *
   * @param address localização dessa escola.
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public PainelEscolaResponse address(String address) {
    this.data.address = address;
    return this;
  }

  /**
   * Adiciona a administração dessa escola (Privada, Federal, Municipal, etc).
   *
   * @param administration administração.
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public PainelEscolaResponse administration(String administration) {
    this.data.administration = administration;
    return this;
  }


  /**
   * Adiciona um número para contato.
   *
   * @param ddd         ddd do número de telefone.
   * @param phoneNumber contato da escola (telefone).
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public PainelEscolaResponse phoneNumber(String ddd, String phoneNumber) {
    this.data.ddd = ddd;
    this.data.phoneNumber = phoneNumber;
    return this;
  }

  /**
   * Adiciona o Ideb médio dos anos inicias.
   *
   * @param idebIniciais IDEB médio dos anos iniciais.
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public PainelEscolaResponse idebIniciais(Double idebIniciais) {
    this.data.addMeanIdebInicial(idebIniciais);
    return this;
  }

  /**
   * Adiciona a meta do Ideb dos anos inicias.
   *
   * @param idebIniciaisProjection meta do IDEB dos anos inicias.
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public PainelEscolaResponse idebIniciaisProjection(Double idebIniciaisProjection) {
    this.data.addProjectionIdebInicial(idebIniciaisProjection);
    return this;
  }

  /**
   * Adiciona o Ideb médio dos anos finais.
   *
   * @param idebFinais IDEB médio dos anos finais.
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public PainelEscolaResponse idebFinais(Double idebFinais) {
    this.data.addMeanIdebFinal(idebFinais);
    return this;
  }

  /**
   * Adiciona a meta do Ideb dos anos finais.
   *
   * @param idebFinaisProjection meta do IDEB dos anos finais.
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public PainelEscolaResponse idebFinaisProjection(Double idebFinaisProjection) {
    this.data.addProjectionIdebFinal(idebFinaisProjection);
    return this;
  }

  /**
   * Adiciona a quantidade de matrículas.
   *
   * @param nMatriculas quantidade de matrículas.
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public PainelEscolaResponse nMatriculas(Integer nMatriculas) {
    this.data.nMatriculas = nMatriculas;
    return this;
  }

  /**
   * Adiciona a quantidade de docentes.
   *
   * @param nDocentes quantidade de docentes.
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public PainelEscolaResponse nDocentes(Integer nDocentes) {
    this.data.nDocentes = nDocentes;
    return this;
  }

  /**
   * Adiciona o índice de Complexidade de Gestão médio para essa escola.
   *
   * @param icg      ICG médio.
   * @param category indica qual classe do indicador de complexidade de gestão esse valor se
   *                 encontra.
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public PainelEscolaResponse icg(Double icg, String category) {
    this.data.addMeanICG(icg, category);
    return this;
  }

  /**
   * Adiciona o indicador de esforço docente médio para essa escola.
   *
   * @param ied      IED médio.
   * @param category indica qual classe do indicador de esforço docente esse valor se encontra.
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public PainelEscolaResponse ied(Double ied, String category) {
    this.data.addMeanIED(ied, category);
    return this;
  }

  /**
   * Adiciona o indicador de adequação da formação docente média para essa escola.
   *
   * @param afd      AFD médio.
   * @param category indica qual classe da adequação de formação docente esse valor se encontra.
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public PainelEscolaResponse afd(Double afd, String category) {
    this.data.addMeanAFD(afd, category);
    return this;
  }

  @Override
  protected void handleError() {
    this.hasError = true;
  }

  @Override
  protected Map<String, Object> buildData() {
    if (this.hasError) {
      return null; // Caso possua algum erro, não devemos retornar dados.
    }

    Map<String, Object> data = new LinkedHashMap<>();
    data.put("id", this.id);
    data.put("type", PainelEscolaResponse.RESOURCE_TYPE);
    data.put("attributes", this.data); // Adiciona todos os dados nos atributos

    return data;
  }

  /**
   * Define os dados que compõem uma resposta para o Painel de Escola.
   *
   * @author moesiof
   * @version 1.0
   */
  private static class PainelEscolaData {

    // Informações da escola
    @JsonProperty("name")
    private String nameEscola;
    @JsonProperty("inep")
    private int codINEP;
    @JsonProperty("address")
    private String address;
    @JsonProperty("phone")
    private String phoneNumber;
    @JsonProperty("ddd")
    private String ddd;
    @JsonProperty("adm")
    private String administration;

    // Indicadores educacionais da escola
    @JsonProperty("year")
    private int year; // Ano dos dados
    @JsonProperty("idebIniciais")
    private Map<String, Object> idebIniciais = new HashMap<>();
    @JsonProperty("idebFinais")
    private Map<String, Object> idebFinais = new HashMap<>();
    @JsonProperty("matriculas")
    private Integer nMatriculas;
    @JsonProperty("docentes")
    private Integer nDocentes;
    @JsonProperty("icg")
    private Map<String, Object> icg = new HashMap<>();
    @JsonProperty("ied")
    private Map<String, Object> ied = new HashMap<>();
    @JsonProperty("afd")
    private Map<String, Object> afd = new HashMap<>();

    /**
     * Esse método adiciona uma média do IDEB dos anos iniciais nos dados da resposta.
     *
     * @param meanIdebInicial Ideb médio dos anos iniciais.
     */
    private void addMeanIdebInicial(Double meanIdebInicial) {
      this.idebIniciais.put("mean", meanIdebInicial);
    }

    /**
     * Esse método adiciona a meta do IDEB dos anos iniciais nos dados da resposta.
     *
     * @param projection meta do Ideb para os anos iniciais.
     */
    private void addProjectionIdebInicial(Double projection) {
      this.idebIniciais.put("projection", projection);
    }

    /**
     * Esse método adiciona uma média do IDEB dos anos iniciais nos dados da resposta.
     *
     * @param meanIdebFinal Ideb médio dos anos finais.
     */
    private void addMeanIdebFinal(Double meanIdebFinal) {
      this.idebFinais.put("mean", meanIdebFinal);
    }

    /**
     * Esse método adiciona a meta do IDEB dos anos finais nos dados da resposta.
     *
     * @param projection meta do Ideb para os anos finais.
     */
    private void addProjectionIdebFinal(Double projection) {
      this.idebFinais.put("projection", projection);
    }

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

  }
}
