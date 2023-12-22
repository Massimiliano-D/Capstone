package Massimiliano.Capstone.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductsService {

    private final ProductsRepository productRepository;

    @Autowired
    public ProductsService(ProductsRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Products createProduct(Products product) {
        return productRepository.save(product);
    }

    public Products updateProduct(Long id, Products product) {
        product.setId(id);
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    public Products getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Products> searchProducts(String genere, Integer prezzo_min, Integer prezzo_max, String nome) {
        if (genere != null) {
            return productRepository.findByGenere(genere);
        } else if (prezzo_min != null && prezzo_max != null) {
            return productRepository.findByPrezzoBetween(prezzo_min, prezzo_max);
        } else if (nome != null) {
            return productRepository.findByNome(nome);
        } else {
            return productRepository.findAll();
        }
    }
}
