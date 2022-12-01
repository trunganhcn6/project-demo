package repository;

import entity.RequestDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestDetailsRepository extends JpaRepository<RequestDetails, Integer> {
}