package Services;


import model.Client;
import Repositories.ClientDB;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientService  {

    @Autowired
    ClientDB db;

    public void loginUser(String name,String password)
    {
       boolean i = db.existsByUsernameAndPassword(name,password);
       System.out.println(i);
    }
    public void signupUser(Client c)
    {
        db.save(c);
    }


    public List<Client> getAllClients() {
        return db.findAll();
    }

    public double generateinvoice(double d, int q)
    {
        return d*q;
    }
}
