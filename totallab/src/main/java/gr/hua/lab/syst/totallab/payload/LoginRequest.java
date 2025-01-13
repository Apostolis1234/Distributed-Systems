package gr.hua.lab.syst.totallab.payload;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.web.ProjectedPayload;

@ProjectedPayload
public class LoginRequest {

        @NotBlank
        private String username;

        @NotBlank
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
