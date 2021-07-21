package movieTicketing.movieTicketing.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class LoginForm {

    private String id;

    private String pw;
}
