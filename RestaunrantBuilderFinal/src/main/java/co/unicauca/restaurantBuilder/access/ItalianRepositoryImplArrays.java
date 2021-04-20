package co.unicauca.restaurantBuilder.access;

import co.unicauca.restaurantBuilder.domain.Product;
import java.util.ArrayList;
import java.util.List;

public class ItalianRepositoryImplArrays implements IProductRepository{
    public static List<Product> products;
    
    public ItalianRepositoryImplArrays(){
        products = new ArrayList<>();
        initialize();
    }
    /**
    *  Inicializacion, se agregan 6 componentes de Comida Italiana
    */
    private void initialize() {
        products.add(new Product(1, "Spaguetti", 25000d));
        products.add(new Product(2, "Especial Italiano", 50000d));
        products.add(new Product(3, "Pizza carbonada", 20000d));
        products.add(new Product(4, "Lasagna", 10000d));
        products.add(new Product(5, "Carpaccio", 20000d));
        products.add(new Product(6, "Spaghetti alla Bolognese", 20000d));
    }
    
    /**
    *  @return: lista de productos
    */
    @Override
    public List<Product> findAll() {
        return products;
    }
    
    /**
    *  Busca una id de un componente.
    *  @param: id 
    *  @return: lista de productos
    */
    @Override
    public Product findById(Integer id) {
        for(Product prod:products){
            if (prod.getId() == id) {
                return prod;
            }
        }
        return null;
    }

    /**
    *  Crea un componente.
    *  @param: newProduct
    *  @return: boolean
    */
    @Override
    public boolean create(Product newProduct) {
        Product prod = this.findById(newProduct.getId());
        if (prod != null) {
                return false;
        }
        products.add(newProduct);
        return true;
    }
    
    /**
    *  Actualiza un componente.
    *  @param: newProduct 
    *  @return: boolean
    */
    @Override
    public boolean update(Product newProduct) {
        Product prod = this.findById(newProduct.getId());
        if (prod != null) {
            prod.setName(newProduct.getName());
            prod.setPrice(newProduct.getPrice());
        return true;
        }
    return false;
    }

    /**
    *  Elimina un componente.
    *  @param: id 
    *  @return: boolean
    */
    @Override
    public boolean delete(Integer id) {
        for (Product prod : products) {
                if (prod.getId() == id) {
                    products.remove(prod);
                    return true;
                }
        }
        return false;
    }
}
