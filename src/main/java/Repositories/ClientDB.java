package Repositories;


import model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDB extends JpaRepository<Client,Integer> {

    boolean existsByUsernameAndPassword(String username, String password);

}
