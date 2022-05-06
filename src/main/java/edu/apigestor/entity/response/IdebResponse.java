package edu.apigestor.entity.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class IdebResponse extends AbstractResponse<Map<String, Object>> {

  private static final String RESOURCE_TYPE = "idebData";

  private final IdebData data = new IdebData();
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

    data.put("type", IdebResponse.RESOURCE_TYPE);
    data.put("id", this.id);

    this.data.others = this.additionalAttributes();

    data.put("attributes", this.data);

    return data;
  }

  protected abstract Map<String, Object> additionalAttributes();

  private static class IdebData {

    @JsonUnwrapped
    private Map<String, Object> others;

    @JsonProperty("idebIniciais")
    private double idebInicias; // ideb dos anos incias
    @JsonProperty("idebFinais")
    private double idebFinais; // ideb dos anos finais
  }
}
