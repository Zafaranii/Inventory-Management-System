package Services;
import java.time.Duration;

import model.Product;
import Repositories.ProductDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.Math.abs;

@Component
public class ProductService{

    @Autowired
    ProductDB db;

    public List<Product> getAllProducts()
    {
        return db.findAll(Sort.by(Sort.Direction.ASC,"id"));
    }

    public void addProduct(Product p)
    {
        db.save(p);
    }
    @Transactional
    public void updateProduct(int id, Product temp)
    {
        Product p = db.getById(id);
        p.update(temp);
    }
    public void deleteProduct(int id)
    {
        db.deleteById(id);
    }

    public List<Product> checkProducts()
    {
        LocalDate date = LocalDate.now();
        List<Product> prods = db.findAll();
        List<Product> products = new ArrayList<>();
        for (Product p : prods) {
            long duration = Duration.between( date.atStartOfDay(),p.getExpiration().atStartOfDay()).toDays();
            if (duration < 30 ) {
                    products.add(p);
            }
                System.out.println(duration);
        }
        return products;
    }
    public double generateinvoice(double price, int quantity)
    {
        return price*quantity;
    }
    public Optional<Product> find(int id)
    {
        Optional<Product> p = db.findById(id);
        return  p;
    }

}
