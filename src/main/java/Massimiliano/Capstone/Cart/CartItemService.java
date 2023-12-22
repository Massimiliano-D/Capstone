package Massimiliano.Capstone.Cart;

import Massimiliano.Capstone.Products.Products;
import Massimiliano.Capstone.Products.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {
    @Autowired
    private CartItemsRepository cartItemsRepository;
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductsService productsService;
    @Autowired
    private CartRepository cartRepository;


    public void addItemToCart(Long cartId, Long productId) {
        Cart cart = cartService.getCartById(cartId);
        Products products = productsService.getProductById(productId);
        List<CartItem> cartItems = cart.getCartItems();
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setProducts(products);
        cartItem.setQuantity(1);
        cart.setTotalPrice(cart.getTotalPrice() + products.getPrice());
        cartService.updateCart(cart);
        if (cartItems.contains(cartItem)) {
            CartItem found = cartItemsRepository.findByCartIdAndProductsId(cartId, productId);
            found.setQuantity(found.getQuantity() + 1);
            cartItemsRepository.save(found);

        } else {
            cartItemsRepository.save(cartItem);
        }
    }


    public void removeItemFromCart(Long cartId, Long productId) {
        Cart cart = cartService.getCartById(cartId);
        Products products = productsService.getProductById(productId);
        CartItem found = cartItemsRepository.findByCartIdAndProductsId(cartId, productId);
        cart.setTotalPrice(cart.getTotalPrice() - products.getPrice());
        cartService.updateCart(cart);
        if (found.getQuantity() >= 2) {
            found.setQuantity(found.getQuantity() - 1);
            cartItemsRepository.save(found);
        } else {
            cartItemsRepository.delete(found);
        }

    }


}

