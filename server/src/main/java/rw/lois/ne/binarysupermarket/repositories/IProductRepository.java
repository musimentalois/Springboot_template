package rw.lois.ne.binarysupermarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.lois.ne.binarysupermarket.models.Product;

public interface IProductRepository extends JpaRepository<Product,String> {
}
