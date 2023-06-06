package Controller;

import Services.ProductService;
import model.Category;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class ProductController {

    @Autowired
    ProductService service;


    @RequestMapping("/Inventory")
    public String Inventorypage(Model model) {
        List<Product> products = service.getAllProducts();
        model.addAttribute("products", products);
        return "product";
    }

    @GetMapping("/addprodredirect")
    public String addNewprod()
    {
        return "Prodfeaturesadd";
    }
    @GetMapping("/deleteprodredirect")
    public String deleteexisstprod()
    {
        return "ProdfeaturesDelete";
    }
    @GetMapping("/updateprodredirect")
    public String updateNewprod()
    {
        return "Prodfeaturesupdate";
    }

    @PostMapping("/addedprod")
    public String addprodd(@ModelAttribute Product p )
    {
        service.addProduct(p);
        return "LP";
    }
    @PostMapping("/deleteprod")
    public String deleteProd(@ModelAttribute Product p )
    {
        service.deleteProduct(p.getId());
        return "LP";
    }
    @PostMapping("/updateprod")
    public String updateProd(@ModelAttribute Product p)
    {
        service.updateProduct(p.getId(), p);
        return "LP";
    }
    @RequestMapping ("/Productexp")
    public String checkprod(Model model)
    {
        List<Product> products = service.checkProducts();
        model.addAttribute("products", products);
        return "productexpiry";
    }



}
