package Massimiliano.Capstone.Products;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int price;
    private String description;
    private String immagine;
    @Enumerated(EnumType.STRING)
    private ProducType type;


    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", price=" + price +
                ", description=" + description +
                ", type=" + type +
                '}';
    }
}
