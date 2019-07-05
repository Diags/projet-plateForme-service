package monartisant.com.projetartisant.ws;

public class ConfirmRegister {
    private String jwtToken;

    public ConfirmRegister() {
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public ConfirmRegister(String token) {
        this.jwtToken = token;

    }
}
