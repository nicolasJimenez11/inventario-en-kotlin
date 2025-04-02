//cd c:\Users\USER\OneDrive\Documentos
//kotlinc inventario.kt -include-runtime -d inventario.jar
//java -jar inventario.jar


// Clase Producto
class Producto(private var id: Int, private var nombre: String, private var cantidad: Int, private var precioUnitario: Double) {

    // Metodos para acceder y modificar los datos
    fun obtenerId(): Int = id
    fun obtenerNombre(): String = nombre
    fun obtenerCantidad(): Int = cantidad
    fun obtenerPrecioUnitario(): Double = precioUnitario

    fun actualizarNombre(nuevoNombre: String) {
        nombre = nuevoNombre
    }

    fun actualizarCantidad(nuevaCantidad: Int) {
        cantidad = nuevaCantidad
    }

    fun actualizarPrecioUnitario(nuevoPrecio: Double) {
        precioUnitario = nuevoPrecio
    }

    // Calcular el precio total de un item
    fun calcularPrecioTotal(): Double {
        return cantidad * precioUnitario
    }

    override fun toString(): String {
        return "ID: $id, Nombre: $nombre, Cantidad: $cantidad, Precio: $precioUnitario"
    }
}

// Clase Inventario
class Inventario {
    private val listaProductos = mutableListOf<Producto>()

    // Agregar un nuevo producto
    fun agregarProducto(producto: Producto) {
        listaProductos.add(producto)
        println("Producto agregado: ${producto.obtenerNombre()}")
    }

    // Consultar productos existentes
    fun consultarProductos() {
        if (listaProductos.isEmpty()) {
            println("El inventario esta vacio.")
        } else {
            println("Productos en el inventario:")
            listaProductos.forEach { println(it) }
        }
    }

    // Modificar la informacion de un producto
    fun modificarProducto(id: Int, nuevoNombre: String? = null, nuevaCantidad: Int? = null, nuevoPrecio: Double? = null) {
        val producto = listaProductos.find { it.obtenerId() == id }
        if (producto != null) {
            nuevoNombre?.let { producto.actualizarNombre(it) }
            nuevaCantidad?.let { producto.actualizarCantidad(it) }
            nuevoPrecio?.let { producto.actualizarPrecioUnitario(it) }
            println("Producto modificado: $producto")
        } else {
            println("Producto con ID $id no encontrado.")
        }
    }

    // Eliminar productos del inventario
    fun eliminarProducto(id: Int) {
        val producto = listaProductos.find { it.obtenerId() == id }
        if (producto != null) {
            listaProductos.remove(producto)
            println("Producto eliminado: ${producto.obtenerNombre()}")
        } else {
            println("Producto con ID $id no encontrado.")
        }
    }

    // Calcular el IVA de una venta
    fun calcularIVA(): Double {
        val total = listaProductos.sumOf { it.calcularPrecioTotal() }
        return total * 0.19 // IVA del 19%
    }

    // Calcular el precio total de todos los productos
    fun calcularPrecioTotalInventario(): Double {
        return listaProductos.sumOf { it.calcularPrecioTotal() }
    }
}

// Funcion principal con menu interactivo
fun main() {
    val inventario = Inventario()
    var opcion: Int?

    do {
        println("--- Menu de Gestion de Inventarios ---")
        println("1. Agregar producto")
        println("2. Consultar productos")
        println("3. Modificar producto")
        println("4. Eliminar producto")
        println("5. Calcular precio total del inventario")
        println("6. Calcular IVA del inventario")
        println("7. Salir")
        print("Seleccione una opcion: ")

        opcion = readLine()?.toIntOrNull()

        when (opcion) {
            1 -> {
                try {
                    print("Ingrese el ID del producto: ")
                    val id = readLine()?.toIntOrNull() ?: throw IllegalArgumentException("ID invalido.")
                    print("Ingrese el nombre del producto: ")
                    val nombre = readLine()?.takeIf { it.isNotEmpty() } ?: throw IllegalArgumentException("Nombre invalido.")
                    print("Ingrese la cantidad del producto: ")
                    val cantidad = readLine()?.toIntOrNull()?.takeIf { it >= 0 } ?: throw IllegalArgumentException("Cantidad invalida.")
                    print("Ingrese el precio del producto: ")
                    val precioUnitario = readLine()?.toDoubleOrNull()?.takeIf { it >= 0 } ?: throw IllegalArgumentException("Precio invalido.")
                    inventario.agregarProducto(Producto(id, nombre, cantidad, precioUnitario))
                } catch (e: IllegalArgumentException) {
                    println(e.message)
                }
            }
            2 -> inventario.consultarProductos()
            3 -> {
                try {
                    print("Ingrese el ID del producto a modificar: ")
                    val id = readLine()?.toIntOrNull() ?: throw IllegalArgumentException("ID invalido.")
                    print("Ingrese el nuevo nombre (o presione Enter para no modificar): ")
                    val nuevoNombre = readLine()?.takeIf { it.isNotEmpty() }
                    print("Ingrese la nueva cantidad (o presione Enter para no modificar): ")
                    val nuevaCantidad = readLine()?.toIntOrNull()
                    print("Ingrese el nuevo precio unitario (o presione Enter para no modificar): ")
                    val nuevoPrecio = readLine()?.toDoubleOrNull()
                    inventario.modificarProducto(id, nuevoNombre, nuevaCantidad, nuevoPrecio)
                } catch (e: IllegalArgumentException) {
                    println(e.message)
                }
            }
            4 -> {
                try {
                    print("Ingrese el ID del producto a eliminar: ")
                    val id = readLine()?.toIntOrNull() ?: throw IllegalArgumentException("ID invalido.")
                    inventario.eliminarProducto(id)
                } catch (e: IllegalArgumentException) {
                    println(e.message)
                }
            }
            5 -> {
                val total = inventario.calcularPrecioTotalInventario()
                println("El precio total del inventario es: $total")
            }
            6 -> {
                val iva = inventario.calcularIVA()
                println("El IVA del inventario es: $iva")
            }
            7 -> println("Saliendo del sistema...")
            else -> println("Opcion no valida. Intente de nuevo.")
        }
    } while (opcion != 7)
}
