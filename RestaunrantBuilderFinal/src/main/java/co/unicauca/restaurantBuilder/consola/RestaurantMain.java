package co.unicauca.restaurantBuilder.consola;

import co.unicauca.restaurantBuilder.domain.Dish;
import co.unicauca.restaurantBuilder.domain.Menu;
import co.unicauca.restaurantBuilder.services.DishDirector;
import co.unicauca.restaurantBuilder.utilities.Consola;

public class RestaurantMain {

    public static void main(String[] args) {
        String ruta="";
        DishDirector directorOriental = new DishDirector(new OrientalDishBuilder());
        DishDirector directorItalian =new DishDirector(new ItalianDishBuilder());
        
        directorOriental.create("Plato Oriental",ruta);
        Dish myDish = directorOriental.getDish();
        
        Menu menOriental=new Menu("Oriental");
        menOriental.setPlatos(myDish);
        Consola.escribirSaltarLinea("Menu "+menOriental.getNombre(), false);
        for (Dish plato : menOriental.getPlatos()) {
            Consola.escribirSaltarLinea("plato: "+plato.getNombre(), false);
            Consola.escribirSaltarLinea("Precio: "+plato.getPrice(), false);
        }
        directorItalian.create("Plato Italiano",ruta);
        Dish myDishIta=directorItalian.getDish();

        Menu menItaliano=new Menu("Italiano");
        menItaliano.setPlatos(myDishIta);
        Consola.escribirSaltarLinea("Menu "+menItaliano.getNombre(), false);
        for (Dish plato : menItaliano.getPlatos()) {
            Consola.escribirSaltarLinea("plato: "+plato.getNombre(), false);
            Consola.escribirSaltarLinea("Precio: "+plato.getPrice(), false);
        }     
    }   
}
