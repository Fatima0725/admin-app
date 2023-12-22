package sn.isi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int id;
    @NotNull(message = "Le nom ne doit pas être null")
    private String nom;
    @NotNull
    private double qteStock;

}
