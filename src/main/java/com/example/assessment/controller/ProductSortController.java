package com.example.assessment.controller;

import com.example.assessment.model.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class ProductSortController {

    @PostMapping("/sortProducts")
    public List<Product> sortedProducts(@RequestBody List<Product> productList) {
        Comparator<Product> comparator = Comparator.comparing(Product::getProductId).thenComparing(Product::getLaunchDate).reversed();
        return productList.stream().sorted(comparator).collect(Collectors.toList());
    }

    @PostMapping("/createProduct")
    public Product createProduct(@RequestBody Product product) {
        List<Product> productsList = new ArrayList<Product>();
        productsList.add(new Product("Prod1", "Shirt", "EACH", null, null));
        productsList.add(new Product("Prod2", "Trousers", "EACH", null, null));
        productsList.add(new Product("Prod3", "Tie", "EACH", null, null));

        if (productsList.stream().anyMatch(p -> p.getProductId().equals(product.getProductId()))) {
            product.setStatus("Exists");
            return product;
        }
        product.setStatus("Created");
        return product;

    }
}
