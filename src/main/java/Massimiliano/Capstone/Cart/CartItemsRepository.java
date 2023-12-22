package Massimiliano.Capstone.Cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItem, Long> {
    public CartItem findByCartIdAndProductsId(Long cartId, Long productsId);
}