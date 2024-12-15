package com.example.productwebapp.controller;

import com.example.productwebapp.model.Product;
import com.example.productwebapp.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/addProduct")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/addProduct?success";
    }
    @GetMapping("/products")
    public String listProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products";
    }
 // Edit product
    @GetMapping("/editProduct")
    public String showEditProductForm(@RequestParam("id") Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "edit-product"; // You will need an `edit-product.html` form
    }

    // Delete product
    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("id") Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
    //update product
    @PostMapping("/updateProduct")
    public String updateProduct(@ModelAttribute("product") Product product) {
        productService.updateProduct(product); // Method to update the product in the database
        return "redirect:/products"; // Redirect to the product list after successful update
    }

}
