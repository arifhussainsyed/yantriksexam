package com.example.assessment.controller;

import com.example.assessment.model.Product;
import com.example.assessment.model.Supply;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class MainController {

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

    @PostMapping("/updateSupply")
    public Supply updateSupply(@RequestBody Supply supply) {
//      This is not working. 
//      Was having some issues, need to resolve fix some stuff with this code
        List<Supply> supplyList = new ArrayList<Supply>();
        supplyList.add(new Supply("Product1", new Date("2021-03-16T08:53:48.616Z"), 10.0));
        supplyList.add(new Supply("Product2", new Date("2021-03-16T08:53:48.616Z"), 5.0));
        supplyList.add(new Supply("Product3", new Date("2021-03-16T08:53:48.616Z"), 30.0));
        supplyList.add(new Supply("Product4", new Date("2021-03-16T09:10:48.616Z"), 20.0));

        return (Supply) supplyList.stream().map(item -> {
            if (item.getProductId().equals(supply.getProductId())) {
                if (item.getUpdateTimeStamp().before(supply.getUpdateTimeStamp())) {
                    item.setStatus("Out of Sync Update");
                    return item;
                } else {
                    item.setQuantity(item.getQuantity() + supply.getQuantity());
                    item.setStatus("Updated");

                    return item;
                }
            } else {
                return new Supply();
            }
        });
    }
}
