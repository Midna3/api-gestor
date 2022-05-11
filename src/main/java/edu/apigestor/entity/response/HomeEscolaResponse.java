package edu.apigestor.entity.response;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
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

  private final List<SchoolEntry> schools = new ArrayList<>();
  private final List<Long> ids = new ArrayList<>(); // Armazena os IDs da resposta

  private boolean hasError = false;

  /**
   * Esse método adiciona as informações de uma escola a resposta.
   *
   * @param nameEscola nome da escola.
   * @param codINEP    código INEP da escola.
   * @param address    endereço da escola (Cidade/Estado).
   * @param id         id da escola.
   */
  public void addEntry(String nameEscola, int codINEP, String address, long id) {
    SchoolEntry entry = new SchoolEntry();
    entry.name = nameEscola;
    entry.codINEP = codINEP;
    entry.address = address;

    this.schools.add(entry);
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

    for (SchoolEntry school : this.schools) {
      Map<String, Object> m = new LinkedHashMap<>();

      m.put("value", school.codINEP);
      m.put("label", "%s, %s".formatted(school.name, school.address));

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
    @JsonProperty("address")
    private String address; // Endereço da escola
  }
}
