import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Arbolproducto arbol = new Arbolproducto();
        Scanner entrada = new Scanner(System.in);
        int opc;

        do {
            System.out.println("1. Agregar Productos\n2. Actualizar producto\n3. Visualizar productos\n4. Guardar recorrido en archivo 1txt \n5. Salir");
            opc = entrada.nextInt();
            entrada.nextLine();

            switch (opc) {
                case 1:
                    agregarProducto(arbol, entrada);
                    break;

                case 2:
                    arbol.actualizarProducto();
                    break;

                case 3:
                    arbol.visualizarRecorridos();
                    break;

                case 4:
                    Archivo archivo = new Archivo(arbol);
                    archivo.escribirInformacion();
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opc != 5);
        
    }

    private static void agregarProducto(Arbolproducto arbol, Scanner entrada) {
        boolean codigoValido = false;
        int codigo = 0;
        
        while (!codigoValido) {
            System.out.println("Ingrese el código del producto (solo tres dígitos y no negativo):");
            codigo = entrada.nextInt();
            entrada.nextLine();

            if (String.valueOf(codigo).length() == 3 && codigo > 0) {
                codigoValido = true;
            } else {
                System.out.println("El código del producto debe tener exactamente tres dígitos y no ser negativo.");
            }
        }
    
        boolean codigoExistente = true;
        
        while (codigoExistente) {
            if (arbol.getRaiz() != null && arbol.buscarProducto(arbol.getRaiz(), codigo) != null) {
                System.out.println("El código del producto ya existe.");
                System.out.println("Ingrese otro código del producto:");
                codigo = entrada.nextInt();
                entrada.nextLine();
            } else {
                codigoExistente = false;
            }
        }
    
        System.out.println("Ingrese el nombre del producto:");
        String nombre = entrada.nextLine();
        
        int cantidad = -1; 

        while (cantidad < 0) {
            System.out.println("Ingrese la cantidad del producto (no puede ser negativa):");
            cantidad = entrada.nextInt();
            
            if (cantidad < 0) {
                System.out.println("La cantidad del producto no puede ser negativa.");
            }
        }
        
        float precio = -1; 

        while (precio < 0) {
            System.out.println("Ingrese el precio del producto (no puede ser negativo):");
            precio = entrada.nextFloat();
            
            if (precio < 0) {
                System.out.println("El precio del producto no puede ser negativo.");
            }
        }

        if (arbol.getRaiz() == null || arbol.getRaiz().getDato() == null) {
            arbol.crearRaiz(new Productos(codigo, nombre, cantidad, precio));
        } else {
            arbol.insertarNodo(codigo, nombre, cantidad, precio);
        }
    }
}
