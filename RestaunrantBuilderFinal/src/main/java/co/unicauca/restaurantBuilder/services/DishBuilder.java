package co.unicauca.restaurantBuilder.services;


import co.unicauca.restaurantBuilder.access.IProductRepository;
import co.unicauca.restaurantBuilder.domain.Dish;
import co.unicauca.restaurantBuilder.domain.Product;
import java.util.List;

    /**
    *  Creacion de la Clase DishBuilder
    */

public abstract class DishBuilder {
    protected Dish myDish;
    protected IProductRepository myRepository;
    protected List<Product> allProducts;
    protected List<Product> bases;
    protected List<Product> options;

    /**
    *   Métodos set/get
    */   
    
    public IProductRepository getMyRepository() {
        return myRepository;
    }

    public void setMyRepository(IProductRepository myRepository) {
        this.myRepository = myRepository;
    }

    public List<Product> getAllProducts() {
        return allProducts;
    }

    public void setAllProducts(List<Product> allProducts) {
        this.allProducts = allProducts;
    }

    public List<Product> getBases() {
        return bases;
    }

    public void setBases(List<Product> bases) {
        this.bases = bases;
    }

    public List<Product> getOptions() {
        return options;
    }

    public void setOptions(List<Product> options) {
        this.options = options;
    }
    
    public Dish getDish() {
        return myDish;
    }
    
    public void setDish(Dish myDish) {
        this.myDish = myDish;
    }
    
    /**
    *   Métodos abstractos
    */   
    
    public abstract DishBuilder init(String nombre,String imagen);

    public abstract DishBuilder setCore();

    public abstract boolean addPart();

    public abstract DishBuilder setSize();
}
