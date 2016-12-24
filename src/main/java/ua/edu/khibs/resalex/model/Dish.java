package ua.edu.khibs.resalex.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "dish")
public class Dish {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column (name = "id")
    private Long id;

    @Column (name = "name")
    private String name;

    @Column (name = "weight")
    private Integer weight;

    @Column (name = "price")
    private Integer price;

    @Column (name = "photo")
    private String photo;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable (
            name = "dish_to_ingredient",
            joinColumns = @JoinColumn(name = "dish_id"),
            inverseJoinColumns = @JoinColumn (name = "ingredient_id")
    )
    private List<Ingredient> listOfIngredient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<Ingredient> getListOfIngredient() {
        return listOfIngredient;
    }

    public void setListOfIngredient(List<Ingredient> listOfIngredient) {
        this.listOfIngredient = listOfIngredient;
    }

    public void setInfo (String name, Integer weight, Integer price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                ", photo='" + photo + '\'' +
                ", listOfIngredient=" + listOfIngredient +
                '}';
    }
}
