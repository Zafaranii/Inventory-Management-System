package Services;


import Repositories.AdminDB;
import Repositories.CategoryDB;
import Repositories.ProductDB;
import Repositories.SupplierDB;
import model.Admin;
import model.Category;
import model.Product;
import model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class AdminService{

    @Autowired
    ProductDB db;
    @Autowired
    CategoryDB db1;
    @Autowired
    SupplierDB db2;
    @Autowired
    AdminDB adb;

    public List<Product> getAllProducts()
    {
        return db.findAll();
    }
    public List<Category> getAllCategory()
    {
        return db1.findAll();
    }
    public List<Supplier> getAllSupplier()
    {
        return db2.findAll();
    }

    public void addCategory(Category c)
    {
        db1.save(c);
    }
    public void addSupplier(Supplier s)
    {
        db2.save(s);
    }
    public void deleteCategory(int id)
    {
        db1.deleteById(id);
    }
    public void deleteSupplier(int id)
    {
        db2.deleteById(id);
    }
    @Transactional
    public void updateCategory(int id, Category temp)
    {
        Category c = db1.getById(id);
       c.setType(temp.getType());
    }
    @Transactional
    public void updateSupplier(int id, Supplier temp)
    {
        Supplier c = db2.getById(id);
        c.setName(temp.getName());
    }
    public Boolean loginUser(String name,String password)
    {
    return adb.existsByUsernameAndPassword(name,password);
    }
    public void signupUser(Admin a)
    {
        adb.save(a);
    }




}
