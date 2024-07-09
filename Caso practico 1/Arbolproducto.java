import java.util.Scanner;

public class Arbolproducto{
    private Nodo raiz = new Nodo();

    public void comprobarRaiz(Productos producto) {
        if (raiz.getDato() != null) {
            System.out.println("Excediste la cantidad de raíces");
        } else {
            crearRaiz(null);
        }
    }

    public void crearRaiz(Productos producto) {
        if (raiz == null || raiz.getDato() == null) {
            raiz = new Nodo(producto);
        } else {
            System.out.println("La raíz ya existe.");
        }
    }

    public void insertarNodo(int codigo, String nombre, int cantidad, float precio) {
        Productos nuevoProducto = new Productos(codigo, nombre, cantidad, precio);
        raiz = insertarNodoRecursivo(raiz, nuevoProducto);
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void inorden(Nodo raiz) {
        if (raiz != null) {
            inorden(raiz.getIzq());
            System.out.println(raiz.getDato());
            inorden(raiz.getDer());
        }
    }

    public void visualizarRecorridos() {
        System.out.println("Recorrido Inorden:");
        inorden(raiz);
    }

    private Nodo insertarNodoRecursivo(Nodo actual, Productos nuevoProducto) {
        if (actual == null) {
            return new Nodo(nuevoProducto);
        }

        if (nuevoProducto.getCodigo() < actual.getDato().getCodigo()) {
            actual.setIzq(insertarNodoRecursivo(actual.getIzq(), nuevoProducto));
        } else if (nuevoProducto.getCodigo() > actual.getDato().getCodigo()) {
            actual.setDer(insertarNodoRecursivo(actual.getDer(), nuevoProducto));
        } else {
            System.out.println("El código del producto ya existe.");
        }

        return actual;
    }

    public void actualizarProducto() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el código del producto a actualizar:");
        int codigo = entrada.nextInt();
        Nodo nodo = buscarProducto(raiz, codigo);
        
        if (nodo != null) {
            Productos producto = nodo.getDato();
            System.out.println("Producto encontrado: Código: " + producto.getCodigo() +
                    ", Nombre: " + producto.getNombre() +
                    ", Cantidad: " + producto.getCantidad());
            
            boolean cantidadValida = false;
            int nuevaCantidad = -1; 
            
            while (!cantidadValida) {
                System.out.println("Ingrese la nueva cantidad en existencia (no puede ser negativa):");
                nuevaCantidad = entrada.nextInt();
                
                if (nuevaCantidad >= 0) {
                    cantidadValida = true;
                } else {
                    System.out.println("La cantidad en existencia no puede ser negativa.");
                }
            }
            
            nodo.getDato().setCantidad(nuevaCantidad);
            System.out.println("Cantidad actualizada.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
    

    public Nodo buscarProducto(Nodo actual, int codigo) {
        if (actual == null || actual.getDato() == null) {
            return null;
        }
        if (codigo == actual.getDato().getCodigo()) {
            return actual;
        }
        if (codigo < actual.getDato().getCodigo()) {
            return buscarProducto(actual.getIzq(), codigo);
        } else {
            return buscarProducto(actual.getDer(), codigo);
        }
    }
}
