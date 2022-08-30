package com.example.skillsauditor.user.domain.common.staff;


import com.example.skillsauditor.user.domain.common.ValueObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
public class LoginDetails extends ValueObject {

    private String username;
    private String password;

    public LoginDetails(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean equals(Object o){
        if(o == null && o.getClass() != this.getClass()){
            return false;
        }

        LoginDetails loginDetails = (LoginDetails) o;

        return loginDetails.username.equals(this.username) && loginDetails.password.equals(this.password);
    }

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

    public String toString(){
        return String.format("%s %s", username, password);
    }

}
