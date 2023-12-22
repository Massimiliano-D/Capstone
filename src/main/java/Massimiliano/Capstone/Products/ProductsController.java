package Massimiliano.Capstone.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @Autowired
    private ProductsRepository productRepository;

    @PostMapping
    public Products createProduct(@RequestBody Products product) {
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public Products updateProduct(@PathVariable Long id, @RequestBody Products product) {
        product.setId(id);
        return productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }

    @GetMapping
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Products getProductById(@PathVariable Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @GetMapping("/search")
    public List<Products> searchProducts(@RequestParam(required = false) String type,
                                        @RequestParam(required = false) Integer prezzo_min,
                                        @RequestParam(required = false) Integer prezzo_max,
                                        @RequestParam(required = false) String name) {

        List<Products> prodotti = new ArrayList<>();

        if (type != null) {
            prodotti = productRepository.findByGenere(type);
        } else if (prezzo_min != null && prezzo_max != null) {
            prodotti = productRepository.findByPrezzoBetween(prezzo_min, prezzo_max);
        } else if (name != null) {
            prodotti = productRepository.findByNome(name);
        } else {
            prodotti = productRepository.findAll();
        }

        return prodotti;
    }

}