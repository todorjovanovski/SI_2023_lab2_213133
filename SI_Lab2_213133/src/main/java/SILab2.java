import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SILab2 {

    public static boolean function (User user, List<User> allUsers) {
        if (user==null || user.getPassword()==null || user.getEmail()==null){ // A
            throw new RuntimeException("Mandatory information missing!"); // B
        }

        if (user.getUsername()==null){ // C
            user.setUsername(user.getEmail()); // D
        }

        int same = 1;
        if (user.getEmail().contains("@") && user.getEmail().contains(".")) { // E
            same = 0;
            for (int i=0;i<allUsers.size();i++) { // F i == 0 |||| G i < n |||| L i ++
                User existingUser = allUsers.get(i);
                if (existingUser.getEmail() == user.getEmail()) { // H
                    same += 1; // I
                }
                if (existingUser.getUsername() == user.getUsername()) { // J
                    same += 1; // K
                }
            }
        }

        String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}";
        String password = user.getPassword();
        String passwordLower = password.toLowerCase();

        if (passwordLower.contains(user.getUsername().toLowerCase()) || password.length()<8) { // M
            return false; // N
        }
        else {
            if (!passwordLower.contains(" ")) { // O
                for (int i = 0; i < specialCharacters.length(); i++) { // P i == 0 |||| Q i < n ||||  T i ++
                    if (password.contains(String.valueOf(specialCharacters.charAt(i)))) { // R
                        return same == 0; // S
                    }
                }
            }
        }
        return false; // U
    } // Z

}
