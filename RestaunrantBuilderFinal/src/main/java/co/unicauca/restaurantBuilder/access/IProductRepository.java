
package co.unicauca.restaurantBuilder.access;

import co.unicauca.restaurantBuilder.domain.Product;
import java.util.List;

/**
 *  Interface del repositorio.
 */
public interface IProductRepository {
    List<Product> findAll();
    Product findById(Integer id);
    boolean create(Product newProduct);
    boolean update(Product newProduct);
    boolean delete(Integer id);
}
