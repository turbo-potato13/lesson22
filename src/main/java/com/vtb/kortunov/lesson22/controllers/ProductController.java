package com.vtb.kortunov.lesson22.controllers;

import com.vtb.kortunov.lesson22.entities.Product;
import com.vtb.kortunov.lesson22.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public String getAllBoxes(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "all_products";
    }

    @PostMapping("/add")
    public String addNewBox(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/products/all";
    }


}
