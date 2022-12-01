package repository;

import entity.BrandProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandProductRepository extends JpaRepository<BrandProduct, Integer> {
    BrandProduct findByName(String name);

}