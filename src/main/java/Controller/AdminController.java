package Controller;
import Services.AdminService;
import Services.ProductService;
import model.Category;
import model.Category;
import model.Product;
import model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    AdminService service;

    @RequestMapping("/Admin")
    public String Admin( ) {

        return "adminChoices";
    }
    @RequestMapping("/Category")
    public String Category(Model model ) {
        List<Category> categories = service.getAllCategory();
        model.addAttribute("categories", categories);
        return "adminCategory";
    }
    @RequestMapping("/Supplier")
    public String Supplier(Model model ) {
        List<Supplier> suppliers = service.getAllSupplier();
        model.addAttribute("suppliers", suppliers);
        return "adminSupplier";
    }
    @GetMapping("/addcategoryredirect")
    public String addNewcat()
    {
        return "adminCategoryadd";
    }
    @GetMapping("/deletecategoryredirect")
    public String deleteexistcat()
    {
        return "adminCategoryDelete";
    }
    @GetMapping("/updatecategoryredirect")
    public String updateNewcat()
    {
        return "adminCategoryupdate";
    }
    @GetMapping("/addsupplierredirect")
    public String addNewsupp()
    {
        return "adminSupplieradd";
    }
    @GetMapping("/deletersupplierredirect")
    public String deleteexistsupp()
    {
        return "adminSupplierDelete";
    }
    @GetMapping("/updatesupplierredirect")
    public String updateNewsupp()
    {
        return "adminSupplierupdate";
    }
    @PostMapping("/addcategory")
    public String addCat(@ModelAttribute Category cat )
    {
        service.addCategory(cat);
        return "adminChoices";
    }
    @PostMapping("/deletecategory")
    public String deleteCat(@ModelAttribute Category cat )
    {
        service.deleteCategory(cat.getId());
        return "adminChoices";
    }
    @PostMapping("/updatecategory")
    public String updateCat(@ModelAttribute Category cat )
    {
        service.updateCategory(cat.getId(), cat);
        return "adminChoices";
    }
    @PostMapping("/addsupplier")
    public String addSup(@ModelAttribute Supplier sup )
    {
        service.addSupplier(sup);
        return "adminChoices";
    }
    @PostMapping("/deletesupplier")
    public String deleteSup(@ModelAttribute Supplier sup )
    {
        service.deleteSupplier(sup.getId());
        return "adminChoices";
    }
    @PostMapping("/updatesupplier")
    public String updateSup(@ModelAttribute Supplier sup )
    {
        service.updateSupplier(sup.getId(), sup);
        return "adminChoices";
    }
    @RequestMapping("/GenerateReport")
    public String report(Model model, Model model1 ) {
        List<Product> products = service.getAllProducts();
        List<Category> categories = service.getAllCategory();
        model.addAttribute("categories", categories);
        model.addAttribute("products", products);
        return "report";
    }
}
