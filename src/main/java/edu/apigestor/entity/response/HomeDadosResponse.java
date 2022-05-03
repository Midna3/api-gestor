package edu.apigestor.entity.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class HomeDadosResponse extends AbstractResponse<Map<String, Object>> {

  private static final String RESOURCE_TYPE = "eduData";

  private final HomeDadosData data = new HomeDadosData();
  private long id; // identificar da resposta

  private boolean hasError = false;

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

  private static class HomeDadosData {

    @JsonUnwrapped
    private Map<String, Object> others;
    @JsonProperty("efd")
    private double meanEFD; // esforço docente médio
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
