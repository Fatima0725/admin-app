package sn.isi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {

    private int id;
    @NotNull(message = "Le nom ne doit pas être null")
    private String nom;
    @NotNull(message = "Le prenom ne doit pas être null")
    private String prenom;
    @NotNull(message = "L'email ne doit pas être null")
    private String email;
    @NotNull(message = "Le mot de passe ne doit pas être null")
    private String password;
    @NotNull
    private int etat;
}
