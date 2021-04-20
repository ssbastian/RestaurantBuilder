
package co.unicauca.restaurantBuilder.consola;

import co.unicauca.restaurantBuilder.access.ItalianRepositoryImplArrays;
import co.unicauca.restaurantBuilder.domain.Product;
import co.unicauca.restaurantBuilder.EnumSize.EnumSize;
import co.unicauca.restaurantBuilder.services.DishBuilder;
import co.unicauca.restaurantBuilder.utilities.Consola;
import java.util.ArrayList;
import java.util.List;

public class ItalianDishBuilder extends DishBuilder{
    private ItalianDish myItalianDish;
    /**
     *  Lee de forma dinamica los componentes a partir de una lista
     * 
     *  @param myProducts
     *  @param dishPart
     *  @return 
     */
    private Product read(List<Product> myProducts, String dishPart) {
        int input=0;
        while (input<1 || input>myProducts.size()){
            int i = 1;
            Consola.escribirSaltarLinea("", false);
            Consola.escribirSaltarLinea("----Plato Italiano-----", false);
            Consola.escribirSaltarLinea("Seleccione una " + dishPart, false);
            for (Product each : myProducts) {
                Consola.escribirSaltarLinea("" + i + ". " + each.getName() + ":" + each.getPrice(), false);
                i++;
            }
            input=Consola.leer("Ingrese el código de la "+dishPart +":",input, false);
        }
        return myProducts.get(input - 1);
    }
    /**
     * crea el plato Italiano
     * 
     * @param nombre
     * @param imagen
     * @return 
     */
    @Override
    public DishBuilder init(String nombre,String imagen) {
        myRepository = new ItalianRepositoryImplArrays();
        myDish = new ItalianDish(nombre,imagen,0.0);
        myItalianDish = (ItalianDish) myDish;
        //Obtenemos todos los productos
        allProducts = myRepository.findAll();
        // Obtenemos las bases y las opciones
        bases = new ArrayList<>();
        options = new ArrayList<>();
        for (Product each : allProducts) {
            if (each.getId() <4) {
                bases.add(each);
            } else if (each.getId() >3) {
                options.add(each);
            }
        }
        return this;
    }
    /**
     * Añade la base del plato Italiano
     * 
     * @return 
     */
    @Override
    public DishBuilder setCore() {
        myItalianDish.setBase(read(bases, "Base"));
        return this;
    }
    
    /**
     * Añade los acompañantes del plato Italiano
     * 
     * @return 
     */
    @Override
    public boolean addPart() {
        String opcion=" ";
        myItalianDish.addOption(read(options, "Opcion"));
        opcion=Consola.leer("Digite S para obtener más opciones de lo contrario presione cualquier "
                + "tecla para Continuar",opcion,false);
        return opcion.matches("[Ss]");
    }
    
    /**
     * tamaño del plato Italiano
     * 
     * @return 
     */
    @Override
    public DishBuilder setSize() {
        String tamano = " ";
        do {
            tamano = Consola.leer("Digite la letra correspondiente para el tamaño "
                    + "Completo (C), Mitad (M)", tamano, false);
        } while (!Consola.validar(tamano));
        if (tamano.equals("C")) {
            myItalianDish.setSize(EnumSize.ALL);
        }
        if (tamano.equals("M")) {
            myItalianDish.setSize(EnumSize.HALF);
        }
        return this;
    }
    
}
