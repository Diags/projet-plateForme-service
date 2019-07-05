package monartisant.com.projetartisant.ws;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Register {
    private String  name;
    private String  lasName;
    private String  password ;
    private String confirmPassword;
    private String email;

}
