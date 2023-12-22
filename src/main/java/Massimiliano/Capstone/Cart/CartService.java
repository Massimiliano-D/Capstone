package Massimiliano.Capstone.Cart;

import Massimiliano.Capstone.CustomerAdmin.User;
import Massimiliano.Capstone.Exeption.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;


    public Cart createCart(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        return cartRepository.save(cart);
    }

    public Cart getCartById(Long cartId) {
        return cartRepository.findById(cartId).orElseThrow(() -> new NotFoundException(cartId));
    }

    public void updateCart(Cart cart) {
        cartRepository.save(cart);
    }

    public void deleteCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }


    public void updateCartItemQuantity(Long cartId, Long cartItemId, int newQuantity) {
        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        optionalCart.ifPresent(cart -> {
            cart.getCartItems().stream()
                    .filter(item -> item.getId().equals(cartItemId))
                    .findFirst()
                    .ifPresent(item -> {
                        item.setQuantity(newQuantity);
                        cartRepository.save(cart);
                    });
        });
    }


}