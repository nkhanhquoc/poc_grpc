package ascendcorp.com.order.exception.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum InternalServerMessage implements ApplicationMessage {
  INTERNAL_SERVER_ERROR("system_error", "System error");

  private String message;
  private String description;

  @Override
  public int getStatusCode() {
    return 500;
  }

  @Override
  public String getKey() {
    return this.name();
  }
}
