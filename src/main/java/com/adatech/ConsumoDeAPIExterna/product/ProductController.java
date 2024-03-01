package com.adatech.ConsumoDeAPIExterna.product;

import com.adatech.ConsumoDeAPIExterna.client.ExternalProduct;
import com.adatech.ConsumoDeAPIExterna.client.ProductRestClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductRestClient productRestClient;

    public ProductController(ProductRepository productRepository, ProductRestClient productRestClient) {
        this.productRepository = productRepository;
        this.productRestClient = productRestClient;
    }

    @GetMapping("/external-products")
    public List<Product> getAllExternalProducts() {
        List<ExternalProduct> listExternalProduct = productRestClient.getAllProducts().products();

//         listExternalProduct.stream()
//                .map(this::converter)
//                .forEach(this.productRepository::save);

        List<Product> returnList = new ArrayList<>();
        for (var externalProduct : listExternalProduct) {
            Product newProduct = converter(externalProduct);
            var productSaved = productRepository.save(newProduct);
            returnList.add(productSaved);
        }
        return returnList;
    }

    private Product converter(ExternalProduct externalProduct) {
        Product product = new Product();
        product.setTitle(externalProduct.title());
        product.setDescription(externalProduct.description());
        product.setPrice(externalProduct.price());
        product.setDiscountPercentage(externalProduct.discountPercentage());
        product.setRating(externalProduct.rating());
        product.setStock(externalProduct.stock());
        product.setBrand(externalProduct.brand());
        product.setCategory(externalProduct.category());
        return product;
    }
}
