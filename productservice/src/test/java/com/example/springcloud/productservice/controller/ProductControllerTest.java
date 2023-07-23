package com.example.springcloud.productservice.controller;

import com.example.springcloud.productservice.model.Product;
import com.example.springcloud.productservice.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ProductControllerTest {
    ProductRepository productRepository = Mockito.mock(ProductRepository.class); //Create mock of productRepository
    ProductController productController = new ProductController(productRepository);
    @Mock
    private RestTemplate restTemplate;

//    @Test
//    public void testCreate() {
//        Product product=new Product();
//
//        when(productController.create(product)).thenReturn(product);
//        assertNotNull(product);
//    }
    @Test
    public void create_EXCEPTION()
    {
      assertThrows(IllegalArgumentException.class,()->{
          productController.create(null);
      });
    }
}