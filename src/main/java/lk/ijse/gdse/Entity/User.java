
package lk.ijse.gdse.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class User {
    @Id
    private String user_id;
    private String username;
    private String nic;
    private String Name;
    private String Address;
    private String user_phone;
    private String user_email;
    private String Position;
    private String password;
}
