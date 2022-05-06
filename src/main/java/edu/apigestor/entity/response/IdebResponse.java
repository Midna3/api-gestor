package edu.apigestor.entity.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>Essa classe representa uma resposta para solicitações do Ideb em diferentes níveis
 * (Nacional, Regional ou Estadual).</p>
 *
 * @author moesiof
 * @version 1.0
 * @see AbstractResponse
 */
public abstract class IdebResponse extends AbstractResponse<Map<String, Object>> {

  private static final String RESOURCE_TYPE = "idebData";

  private final IdebData data = new IdebData();
  private long id; // identificar da resposta
  private boolean hasError = false;

  /**
   * Adiciona um identificador único para essa resposta.
   *
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public IdebResponse id(long id) {
    this.id = id;
    return this;
  }

  /**
   * Adiciona o Ideb dos anos iniciais.
   *
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public IdebResponse idebIniciais(double idebIniciais) {
    this.data.idebInicias = idebIniciais;
    return this;
  }

  /**
   * Adiciona o Ideb dos anos finais.
   *
   * @return essa mesma resposta, permitindo <i>method chaining</i>.
   */
  public IdebResponse idebFinais(double idebFinais) {
    this.data.idebFinais = idebFinais;
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

    data.put("type", IdebResponse.RESOURCE_TYPE);
    data.put("id", this.id);

    this.data.others = this.additionalAttributes();

    data.put("attributes", this.data);

    return data;
  }

  protected abstract Map<String, Object> additionalAttributes();

  /**
   * Define os dados que compõem uma resposta sobre o Ideb de uma determinada entidade (região,
   * país, escola, etc).
   *
   * @author moesiof
   * @version 1.0
   */
  private static class IdebData {

    @JsonUnwrapped
    private Map<String, Object> others;

    @JsonProperty("idebIniciais")
    private double idebInicias; // ideb dos anos incias
    @JsonProperty("idebFinais")
    private double idebFinais; // ideb dos anos finais
  }
}