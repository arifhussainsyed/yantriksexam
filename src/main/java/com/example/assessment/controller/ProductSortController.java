package com.example.assessment.controller;

import com.example.assessment.model.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
