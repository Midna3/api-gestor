package edu.apigestor.entity.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * A classe {@link AbstractResponse} representa a estrutura básica de uma resposta para qualquer
 * solicitação realizada a API. Essa classe utiliza as especificações do JSON:API para construção
 * das respostas. Instâncias das subclasses são convertidas automaticamente para JSON.
 *
 * @author moesiof
 * @version 1.0
 * @see <a href="https://jsonapi.org/format/1.0/">JSON:API (1.0)</a>
 */
@JsonInclude(Include.NON_EMPTY)
public abstract class AbstractResponse<T> {

  private final Map<String, String> meta; // Contém meta-informações sobre a resposta.

  private final Map<String, String> error; // Contém erros encontrados pela resposta.

  public AbstractResponse() {
    this.meta = new LinkedHashMap<>();
    this.error = new LinkedHashMap<>();
  }

  /**
   * Retorna um {@link Map} com os meta-dados dessa resposta.
   *
   * @return Mapa com meta-dados.
   */
  public Map<String, String> getMeta() {
    return this.meta;
  }

  /**
   * Retorna um {@link Map} com os erros dessa resposta. Se uma resposta possui erro, o método
   * {@link AbstractResponse#getData()} deve retornar null ou um objeto vazio (i.e., mapa sem nenhum
   * atributo).
   *
   * @return Mapa com meta-dados.
   */
  public Map<String, String> getError() {
    return this.error;
  }

  /**
   * Retorna os dados dessa resposta ou null (caso a solicitação tenha resultado em um erro).
   *
   * @return um objeto que contém os dados dessa resposta.
   */
  public T getData() {
    return this.buildData();
  }

  /**
   * Adiciona um meta-dado.
   *
   * @param key   chave de identificação do meta-dado.
   * @param value valor do meta-dado.
   */
  public void addMetaInfo(String key, String value) {
    this.meta.put(key, value);
    this.handleMetaInfo();
  }

  /**
   * Adiciona um erro.
   *
   * @param id     identificador único da ocorrência desse erro.
   * @param status status HTTP desse erro.
   */
  public void addError(long id, int status, String title) {
    this.error.put("id", Long.toString(id));
    this.error.put("status", Integer.toString(status));
    this.error.put("title", title);
    this.handleError();
  }

  /**
   * Método que determina como a resposta deve tratar a ocorrência de um erro (i.e., adicionar
   * meta-dados, não retornar dados, etc).
   */
  protected abstract void handleError();

  /**
   * Método que determina como a resposta deve tratar a adição de um novo meta-dado.
   */
  protected void handleMetaInfo() {
    // Tratamento padrão para adição de meta-informações é vazio.
  }

  /**
   * Método auxiliar que constrói o objeto que contém os dados dessa resposta.
   */
  protected abstract T buildData();
}
