
package co.unicauca.restaurantBuilder.consola;

import co.unicauca.restaurantBuilder.domain.Dish;
import co.unicauca.restaurantBuilder.domain.Product;
import co.unicauca.restaurantBuilder.EnumSize.EnumSize;
import java.util.ArrayList;

/**
 *  @autor Sergio-PC
 */
public class OrientalDish extends Dish{

    /**
    *  Constructor de la clase
    */
    public OrientalDish(String nombre,String imagen,double precio) {
        this.nombre=nombre;
        this.imagen=imagen;
        this.price = precio;
        this.myOptions = new ArrayList<>();
    }
    
    /**
     * Agrega opciones al plato Oriental
     * 
     * @param option 
     */
    public void addOption(Product option) {
        this.getMyOptions().add(option);
    }
    /**
     * Calcula el precio del plato Oriental
     * 
     * @return 
     */
    @Override
    public double getPrice(){
        this.price = this.base.getPrice();
        for(Product each: myOptions){
            price = price + each.getPrice();
        }
        if(size==EnumSize.HALF) price = price/2;
        return price;
    }
}
