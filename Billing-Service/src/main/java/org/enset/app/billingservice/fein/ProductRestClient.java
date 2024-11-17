package org.enset.app.billingservice.fein;

import org.enset.app.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("inventory-service")
public interface ProductRestClient {
    @GetMapping("/api/products/{id}")
    Product getProductId(@PathVariable String id);

    @GetMapping("api/products")
    PagedModel<Product> getAllProducts();
}

