package com.example.springcloud.productservice.controller;

import com.example.springcloud.productservice.dto.Coupon;
import com.example.springcloud.productservice.model.Product;
import com.example.springcloud.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/products-api")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Value("${coupounService.url}")
    private String couponServiceURL;

    public ProductController(ProductRepository productRepository) {
        this.productRepository=productRepository;
    }

    @PostMapping("/add")
    public Product create(@RequestBody Product product){
        if(product==null)
            throw new IllegalArgumentException("Product Details missing");

       Coupon coupon= restTemplate.getForObject(couponServiceURL+product.getCouponCode(), Coupon.class);
       product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
         return productRepository.save(product);
    }


}
