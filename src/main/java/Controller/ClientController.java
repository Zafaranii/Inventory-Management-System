package Controller;
import Services.ClientService;
import Services.ProductService;
import model.Client;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {

    @Autowired
    ClientService service;
    @Autowired
    ProductService pservice;

    @RequestMapping("/Client")
    public String Signuppage( ) {

        return "signup";
    }
    @PostMapping("/signup")
    public String addProd(@ModelAttribute Client c , Model model)
    {
        service.signupUser(c);
        List<Product> products = pservice.getAllProducts();
        model.addAttribute("products", products);
        return "client";
    }
    @RequestMapping ("/click")
    public String purchase()
    {
        return "purchase";
    }
    @PostMapping("/addprodtocart")
    public String total(@ModelAttribute Product p, Model model)
    {
       Optional<Product> q =  pservice.find(p.getId());
       double c = service.generateinvoice(q.get().getPrice(), p.getQuantity());
       model.addAttribute("Invoice", String.valueOf(c) );
       System.out.println(c);
        return "client";
    }



}
