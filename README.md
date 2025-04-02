# inventario-en-kotlin
INFORME TÉCNICO DEL SISTEMA DE GESTIÓN DE INVENTARIOS EN KOTLIN

1. Introducción
En el presente informe se describe el desarrollo de un sistema de gestión de inventarios implementado en Kotlin. El sistema permite realizar operaciones básicas sobre un inventario de productos, como agregar, modificar, consultar y eliminar productos. Además, se incluyen funciones para calcular el precio total del inventario y el IVA correspondiente.

Este sistema está diseñado con el propósito de mejorar la organización y administración de productos en un entorno comercial, proporcionando una interfaz interactiva mediante la consola.

2. Objetivos

Implementar un sistema funcional de gestión de inventarios utilizando Kotlin.

Aplicar conceptos de Programación Orientada a Objetos (POO) para estructurar el código de manera modular y reutilizable.

Proporcionar un mecanismo fácil de usar para la manipulación de productos.

Calcular automáticamente el precio total del inventario y el IVA.

3. Desarrollo del sistema

El sistema consta de dos clases principales: Producto e Inventario, además de una función main que proporciona un menú interactivo para la gestión del inventario.

3.1. Clase Producto

La clase Producto representa cada producto dentro del inventario y contiene los siguientes atributos:

id: Identificador único del producto.

nombre: Nombre del producto.

cantidad: Cantidad disponible en inventario.

precioUnitario: Precio de cada unidad del producto.

Además, se incluyen métodos para obtener y modificar estos atributos, así como un método calcularPrecioTotal() que retorna el costo total del producto en función de su cantidad y precio unitario.

3.2. Clase Inventario

Esta clase maneja una lista de productos y permite realizar las siguientes operaciones:

Agregar productos: Se incorpora un nuevo producto a la lista.

Consultar productos: Se imprime la lista de productos almacenados en el inventario.

Modificar productos: Permite actualizar el nombre, cantidad y precio de un producto específico.

Eliminar productos: Se elimina un producto a partir de su ID.

Calcular precio total: Suma el valor de todos los productos en inventario.

Calcular IVA: Aplica un 19% sobre el total del inventario.

3.3. Funcionalidad interactiva

La función main implementa un menú interactivo que permite al usuario seleccionar las acciones que desea realizar mediante la consola. Utiliza readLine() para recibir la entrada del usuario y when para gestionar las diferentes opciones.

4. Resultados y pruebas
Durante las pruebas realizadas, el sistema respondió correctamente a las distintas operaciones solicitadas. Se validaron casos como:

Agregar productos con valores correctos y erróneos.

Modificar productos existentes y no existentes.

Calcular correctamente el total del inventario y el IVA.

Eliminar productos y verificar la integridad de la lista restante.

Los resultados obtenidos demuestran que el sistema cumple con los objetivos planteados y brinda una solución eficiente para la gestión de inventarios.

pantallasos de ejecucion

1. MENU
   
![image](https://github.com/user-attachments/assets/5cd2350a-71ea-4d50-87ce-0de90671459b)

2.AGREGAR PRODUCTO

![image](https://github.com/user-attachments/assets/a5b8278f-31cd-43b1-a0d9-b2a64eca5f74)

3.CONSULTAR PRODUCTO

![image](https://github.com/user-attachments/assets/47ea4110-401f-4137-96d9-165a5f1dfa2e)

en el caso de que este vacia el resultado mostrado en el terminal es

![image](https://github.com/user-attachments/assets/8ab5fbb6-c497-41d1-a5f1-6047c3473c5c)


4.ELIMINAR PRODUCTO

![image](https://github.com/user-attachments/assets/41476aff-03c7-4ccb-9942-25d036c61c09)

5. CALCULAR PRECIO TOTAL INVENTARIO

![image](https://github.com/user-attachments/assets/1638bb84-9eed-49db-adff-31b280c7f13f)

6.CALCULAR IVA DEL INVENTARIO

![image](https://github.com/user-attachments/assets/1acd4b53-4308-4ce9-9e7a-a1acd959f3f0)

7. SALIR DEL SISTEMA

![image](https://github.com/user-attachments/assets/af1e6210-77f7-4e2f-bcdd-3fb50bf9af5a)






