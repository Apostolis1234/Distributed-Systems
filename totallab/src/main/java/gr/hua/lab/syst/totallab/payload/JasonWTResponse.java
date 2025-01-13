package gr.hua.lab.syst.totallab.payload;


import org.springframework.data.web.ProjectedPayload;

import java.util.List;

@ProjectedPayload
public class JasonWTResponse {

    private String token;

    private String type = "Bearer";

    private Long id;

    private String username;

    private String email;

    private List<String> roles;

    public JasonWTResponse(String email, String username, String type, String token, List<String> roles, Long id) {
        this.email = email;
        this.username = username;
        this.type = type;
        this.token = token;
        this.roles = roles;
        this.id = id;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }
}



}
