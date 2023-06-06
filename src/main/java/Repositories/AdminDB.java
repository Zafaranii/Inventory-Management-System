package Repositories;

import model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDB extends JpaRepository<Admin,Integer> {

    boolean existsByUsernameAndPassword(String username, String password);


}
