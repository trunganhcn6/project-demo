package repository;

import entity.BrandAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandAccountRepository extends JpaRepository<BrandAccount, Integer> {
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    BrandAccount findByUsername(String username);
}