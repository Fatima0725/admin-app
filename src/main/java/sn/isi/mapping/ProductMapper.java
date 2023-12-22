package sn.isi.mapping;

import org.mapstruct.Mapper;
import sn.isi.dto.Product;
import sn.isi.entities.ProductEntity;

@Mapper
public interface ProductMapper {
    Product toProduct (ProductEntity productEntity);
    ProductEntity fromProduct(Product product);
}
