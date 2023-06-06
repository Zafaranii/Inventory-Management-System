package Repositories;

import model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierDB extends JpaRepository<Supplier,Integer> {

}