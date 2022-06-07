package com.ifast.controllers;

import com.ifast.entities.Product;
import com.ifast.entities.ProductDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    public static Map<Integer, Product> productMap = new HashMap<>();
    static {
        productMap.put(1,new Product(1,"samsang","Mobile",10000));
        productMap.put(2,new Product(2,"samsang","Mobile",10000));
    }

    /*@Autowired
    private ProductService productService;*/

    @GetMapping("/")
    public String homeController(Model model){
        List<Product> products = new ArrayList<>();
        System.out.println(productMap);
        for(Map.Entry<Integer,Product> entry : productMap.entrySet()){
            products.add(entry.getValue());
        }
        System.out.println(products);
        model.addAttribute("products",products);
        return "home";
    }


   @RequestMapping("/add-product")
    public String addProduct(){
        return "add-product-form";
    }

    @RequestMapping(value = "/handle-product",method= RequestMethod.POST)
    public RedirectView handleProduct(@ModelAttribute ProductDTO productDto, HttpServletRequest request ){

        Product newProduct = new Product(productMap.size()+1,productDto.getName(),productDto.getDescription(),productDto.getPrice());
        productMap.put(productMap.size()+1,newProduct);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath() + "/");
        return redirectView;
    }

    @RequestMapping(value = "/delete/{productId}")
    public RedirectView deleteProduct(@PathVariable(name = "productId") int productId,HttpServletRequest request){

        productMap.remove(productId);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath() + "/");
        return redirectView;
    }

    @RequestMapping("/edit/{productId}")
    public String editProduct(@PathVariable(name = "productId") int productId,Model model){
       Product savedProduct = productMap.get(productId);
       model.addAttribute("product",savedProduct);

       return "edit-product-form";

    }

    @RequestMapping(value = "/edit/edit-product",method = { RequestMethod.GET, RequestMethod.POST })
    public RedirectView handleEditProduct(@ModelAttribute Product product,HttpServletRequest request){
        System.out.println("edit called");
        productMap.remove(product.getId());
        productMap.put(product.getId(),product);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath() + "/");
        return redirectView;
    }
}
