package com.ifast.controller;

import com.ifast.entities.Product;
import com.ifast.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ProductService productService;

   /* @Autowired
    public MainController(ProductService productService) {
        this.productService = productService;
    }*/

    @GetMapping("/home")
    public String openHome(Model model){
        System.out.println("get called");
        List<Product> products = productService.getProducts();
        model.addAttribute("products",products);
        return "home";
    }

    //Render Add-product page
    @RequestMapping(value = "/add-product")
    public String addProduct(Model model){
        model.addAttribute("title","Add-product");
        return "add-product-form";
    }

    //Handle add product form
    @RequestMapping(value = "/handle-product",method= RequestMethod.POST)
    public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest request ){
        System.out.println(product);
        productService.createProduct(product);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath() + "/home");
        return redirectView;
    }

    //delete handler
    @RequestMapping(value = "/delete/{productId}")
    public RedirectView deleteProduct(@PathVariable(name = "productId") int productId,HttpServletRequest request){
        productService.deleteProduct(productId);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath() +"/home");
        return redirectView;
    }

    @RequestMapping("/edit/{productId}")
    public String editProduct(@PathVariable(name = "productId") int productId,Model model){
        Product savedProduct = productService.getProduct(productId);
        model.addAttribute("product",savedProduct);

        return "edit-product-form";

    }

    @RequestMapping(value = "/edit/edit-product",method = RequestMethod.POST)
    public RedirectView handleEditProduct(@ModelAttribute Product product,HttpServletRequest request){
        System.out.println("edit called");

        Product savedProduct = productService.getProduct(product.getId());
        savedProduct.setName(product.getName());
        savedProduct.setDescription(product.getDescription());
        savedProduct.setPrice(product.getPrice());

        productService.createProduct(savedProduct);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath() + "/home");
        return redirectView;
    }

}
