package edu.apigestor.entity.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Essa classe representa uma resposta para solicitações da Home sobre a lista de
 * escolas que possui um nome similar ao que foi passado.</p>
 *
 * @author moesiof
 * @version 1.0
 * @see AbstractResponse
 */
public class HomeEscolaResponse extends AbstractResponse<List<Map<String, Object>>> {

  private static final String RESOURCE_TYPE = "schoolInfo";

  private final List<String> nameEscolas = new ArrayList<>(); // Armazena os nomes das escolas
  private final List<Integer> codesINEP = new ArrayList<>(); // Armazena os códigos INEP
  private final List<Long> ids = new ArrayList<>(); // Armazena os IDs da resposta

  private boolean hasError = false;

  /**
   * Esse método adiciona as informações de uma escola a resposta.
   *
   * @param nameEscola nome da escola.
   * @param codINEP    código INEP da escola.
   * @param id         id da escola.
   */
  public void addEntry(String nameEscola, int codINEP, long id) {
    this.nameEscolas.add(nameEscola);
    this.codesINEP.add(codINEP);
    this.ids.add(id);
  }

  @Override
  protected void handleError() {
    hasError = true;
  }

  @Override
  protected List<Map<String, Object>> buildData() {
    if (this.hasError) {
      return null;
    }

    List<Map<String, Object>> data = new ArrayList<>();
    int size = this.nameEscolas.size();

    for (int i = 0; i < size; i++) {
      Map<String, Object> m = new LinkedHashMap<>();

      m.put("type", HomeEscolaResponse.RESOURCE_TYPE);
      m.put("id", this.ids.get(i));

      SchoolEntry entry = new SchoolEntry();
      entry.name = this.nameEscolas.get(i);
      entry.codINEP = this.codesINEP.get(i);

      m.put("attributes", entry);

      data.add(m);
    }

    return data;
  }

  /**
   * Define os dados que compõem uma resposta para a Home (identificação da escola).
   *
   * @author moesiof
   * @version 1.0
   */
  private static class SchoolEntry {

    @JsonProperty("name")
    private String name; // Nome da escola
    @JsonProperty("inep")
    private int codINEP; // Código INEP da escola
  }
}
