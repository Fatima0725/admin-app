package sn.isi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.entities.ProductEntity;

public interface IProduitRepository extends JpaRepository<ProductEntity, Integer> {

}
