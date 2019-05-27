package monartisant.com.projetartisant.ws;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Data @AllArgsConstructor  @ToString
public class SmsRequest {
    @NotBlank
    @JsonProperty("phoneNumber")
    private final String phoneNumber; // destination
    @NotBlank
    @JsonProperty("message")
    private final String message;

}
