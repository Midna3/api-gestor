package edu.apigestor.entity.response;

import com.fasterxml.jackson.annotation.JsonProperty;
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

  private final PainelEscolaData data = new PainelEscolaData();
  private long id; // identificar da resposta
  private boolean hasError = false;

  /**
   * Adiciona um identificador único para essa resposta.
   *
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public PainelEscolaResponse id(long id) {
    this.id = id;
    return this;
  }

  /**
   * Adiciona o nome da escola.
   *
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public PainelEscolaResponse nameEscola(String nameEscola) {
    this.data.nameEscola = nameEscola;
    return this;
  }

  /**
   * Adiciona o código INEP,.
   *
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public PainelEscolaResponse codINEP(long codINEP) {
    this.data.codINEP = codINEP;
    return this;
  }

  /**
   * Adiciona o endereço.
   *
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public PainelEscolaResponse address(String address) {
    this.data.address = address;
    return this;
  }

  /**
   * Adiciona um número para contato.
   *
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public PainelEscolaResponse phoneNumber(String phoneNumber) {
    this.data.phoneNumber = phoneNumber;
    return this;
  }

  /**
   * Adiciona o Ideb médio dos anos inicias.
   *
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public PainelEscolaResponse idebIniciais(Double idebIniciais) {
    this.data.idebIniciais = idebIniciais;
    return this;
  }

  /**
   * Adiciona o Ideb médio dos anos finais.
   *
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public PainelEscolaResponse idebFinais(Double idebFinais) {
    this.data.idebFinais = idebFinais;
    return this;
  }

  /**
   * Adiciona a quantidade de matrículas.
   *
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public PainelEscolaResponse nMatriculas(Long nMatriculas) {
    this.data.nMatriculas = nMatriculas;
    return this;
  }

  /**
   * Adiciona a quantidade de docentes.
   *
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public PainelEscolaResponse nDocentes(Long nDocentes) {
    this.data.nDocentes = nDocentes;
    return this;
  }

  /**
   * Adiciona o índice de Complexidade de Gestão.
   *
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public PainelEscolaResponse icg(Integer icg) {
    this.data.icg = icg;
    return this;
  }

  /**
   * Adiciona o indicador de esforço docente.
   *
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public PainelEscolaResponse ied(Integer ied) {
    this.data.ied = ied;
    return this;
  }

  /**
   * Adiciona o indicador de adequação da formação docente.
   *
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public PainelEscolaResponse afd(Integer afd) {
    this.data.afd = afd;
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
    data.put("id", Long.toString(this.id));
    data.put("type", "schoolData");
    data.put("attributes", this.data); // Adiciona todos os dados nos atributos

    return data;
  }

  /**
   * Define os dados que compõem uma resposta para o Paindel de Escola.
   *
   * @author moesiof
   * @version 1.0
   */
  private static class PainelEscolaData {

    // Informações da escola
    @JsonProperty("name")
    private String nameEscola;
    @JsonProperty("inep")
    private long codINEP;
    @JsonProperty("address")
    private String address;
    @JsonProperty("phone")
    private String phoneNumber;

    // Indicadores educacionais da escola
    @JsonProperty("idebIniciais")
    private Double idebIniciais;
    @JsonProperty("idebFinais")
    private Double idebFinais;
    @JsonProperty("matriculas")
    private Long nMatriculas; // Quantidade de matrículas
    @JsonProperty("docentes")
    private Long nDocentes; // Quantidade de docentes
    @JsonProperty("icg")
    private Integer icg; // Indicador da complexidade de gestão
    @JsonProperty("ied")
    private Integer ied; // Indicador do esforço docente
    @JsonProperty("afd")
    private Integer afd; // Indicador de adequação da formação docente
  }
}
