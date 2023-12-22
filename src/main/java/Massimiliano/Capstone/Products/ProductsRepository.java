package Massimiliano.Capstone.Products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
  @Query("SELECT p FROM Products p WHERE p.type = :genere")
    List<Products> findByGenere(String genere);
    @Query("SELECT p FROM Products p WHERE p.price BETWEEN :prezzo_min AND :prezzo_max")
    List<Products> findByPrezzoBetween(Integer prezzo_min, Integer prezzo_max);
    @Query("SELECT p FROM Products p WHERE p.description = :description")
    List<Products> findByNome(String description);
}