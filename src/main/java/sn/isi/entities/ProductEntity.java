package sn.isi.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column( nullable = false, length = 200)
    private String nom;
    @Column
    private double qteStock;
    @ManyToOne
    private AppUserEntity appUser;
}
