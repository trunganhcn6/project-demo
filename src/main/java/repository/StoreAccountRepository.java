package repository;

import entity.StoreAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreAccountRepository extends JpaRepository<StoreAccount, Integer> {
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    StoreAccount findByUsername(String username);
}