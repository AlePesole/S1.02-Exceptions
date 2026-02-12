package n1ejercicio1;

public class Main {
    public static void main(String[] args) {
        n1ejercicio1.Sale sale1 = new Sale();

        //Prueba ejecución normal del programa
        sale1.addProduct(new Product("Pizza",9.50));
        sale1.addProduct(new Product("Pasta",10.99));
        try {
            sale1.calculateTotal();
        } catch (EmptySaleException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Productos:\n" + sale1.getProducts() + "\nTotal:" + sale1.getTotal());

        //Prueba acceder una posición inexistente de la lista
        System.out.println("\n-------Prueba acceder posición inexistente lista-------");
        try {
            System.out.println("Obtener tercer productor(inexistente): " + sale1.getProducts().get(2));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No existe el producto en esa posición de la lista");
        }


        Sale sale2 = new Sale();
        // Prueba checked-exception (lista vacía - sin interrumpir la ejecución)
        System.out.println("\n-------Prueba calcular total con lista vacía (checked)exception-------");
        try {
            sale2.calculateTotal();
        } catch (EmptySaleException e) {
            System.out.println(e.getMessage());
        }

        // Prueba unchecked-exception (lista vacía - interrumpe la ejecución)
        System.out.println("\n-------Prueba calcular total con lista vacía (unchecked)exception-------");
        sale2.calculateTotal2();

        System.out.println("Fin del main");
    }
}
