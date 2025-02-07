package io.github.niveastelmam.ProductAPI.controller;

import io.github.niveastelmam.ProductAPI.domain.Product;
import io.github.niveastelmam.ProductAPI.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController // API
@RequestMapping("/products")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public Product save(@RequestBody Product product){
       System.out.println("Produto Recebido: " + product);

       productRepository.save(product);
        return product;

    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable("id") UUID id) {
    //    Optional<Product> product = productRepository.findById(id);
    //    return product.isPresent() ? product.get() : null;

        return  productRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable("id") UUID id){
        productRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") UUID id, @RequestBody Product product){

        product.setId(id);
        productRepository.save(product);
    }

    @GetMapping
    public List<Product> searchByParam(@RequestParam("name") String name){

        return productRepository.findByName(name);

    }

    @GetMapping("/all")
    public List<Product> getAll(){

       return productRepository.findAll();
    }


}
