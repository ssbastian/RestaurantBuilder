
package co.unicauca.restaurantBuilder.consola;

import co.unicauca.restaurantBuilder.access.OrientalRepositoryImplArrays;
import co.unicauca.restaurantBuilder.domain.Product;
import co.unicauca.restaurantBuilder.EnumSize.EnumSize;
import co.unicauca.restaurantBuilder.services.DishBuilder;
import co.unicauca.restaurantBuilder.utilities.Consola;
import java.util.ArrayList;
import java.util.List;

public class OrientalDishBuilder extends DishBuilder{
    private OrientalDish myOrientalDish;
    /**
     * Lee de forma dinamica los productos a partir de una lista
     * 
     * @param myProducts
     * @param dishPart
     * @return 
     */
    private Product read(List<Product> myProducts, String dishPart) {
        int input=0;
        while (input<1 || input>myProducts.size()){
            int i = 1;
            Consola.escribirSaltarLinea("----Plato Oriental-----", false);
            Consola.escribirSaltarLinea("Seleccione una " + dishPart, false);
            for (Product each : myProducts) {
                Consola.escribirSaltarLinea("" + i + ". " + each.getName() + ":" + each.getPrice(), false);
                i++;
            }
            input=Consola.leer("Digite la "+dishPart +":",input, false);
        }
        return myProducts.get(input - 1);
    }
    /**
     * crea el plato Oriental
     * 
     * @param nombre
     * @param imagen
     * @return 
     */
    @Override
    public DishBuilder init(String nombre,String imagen) {
        myRepository = new OrientalRepositoryImplArrays();
        myDish = new OrientalDish(nombre,imagen,0.0);
        myOrientalDish = (OrientalDish) myDish;
        //Obtenemos todos los productos
        allProducts = myRepository.findAll();
        // Obtenemos las bases y las opciones
        bases = new ArrayList<>();
        options = new ArrayList<>();
        for (Product each : allProducts) {
            if (each.getId() < 4) {
                bases.add(each);
            } else if(each.getId()>3 && each.getId()<7){
                options.add(each);
            }
        }
        return this;
    }
    /**
     * A??ade la base del plato Oriental
     * 
     * @return 
     */
    @Override
    public DishBuilder setCore() {
        myOrientalDish.setBase(read(bases, "Base"));
        return this;
    }
    
    /**
     * A??ade los acompa??antes del plato Oriental
     * 
     * @return 
     */
    @Override
    public boolean addPart() {
        String opcion=" ";
        myOrientalDish.addOption(read(options, "Opcion"));
        opcion=Consola.leer("Digite S para obtener m??s opciones de lo contrario presione cualquier "
                + "tecla para Continuar",opcion,false);
        return opcion.matches("[Ss]");
    }
    
    /**
     * tama??o del plato Oriental
     * 
     * @return 
     */
    @Override
    public DishBuilder setSize() {
        String tamano = " ";
        do {
            tamano = Consola.leer("Digite la letra para el tama??o del plato que desea: "
                    + "Completo (C), Mitad (M)", tamano, false);
        } while (!Consola.validar(tamano));
        if (tamano.equals("C")) {
            myOrientalDish.setSize(EnumSize.ALL);
        }
        if (tamano.equals("M")) {
            myOrientalDish.setSize(EnumSize.HALF);
        }
        return this;
    }
}
