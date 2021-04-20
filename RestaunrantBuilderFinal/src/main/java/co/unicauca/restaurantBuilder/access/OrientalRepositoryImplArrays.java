package co.unicauca.restaurantBuilder.access;

import co.unicauca.restaurantBuilder.domain.Product;
import java.util.ArrayList;
import java.util.List;

public class OrientalRepositoryImplArrays implements IProductRepository{
    public static List<Product> products;
    
    public OrientalRepositoryImplArrays(){
        products = new ArrayList<>();
        initialize();
    }
    /**
    *  Inicializacion, se agregan 6 productos de Comida Oriental
    */
    private void initialize() {
        
        products.add(new Product(1, "Wonton", 30000d));
        products.add(new Product(2, "Chow Mein", 25000d));
        products.add(new Product(3, "POLLO GONG BAO", 25000d));
        products.add(new Product(4, "MA PO TOFU", 30000d));
        products.add(new Product(5, "WONTON", 10000d));
        products.add(new Product(6, "Arroz Oriental", 15000d));
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
                //Ya existe
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
