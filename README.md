# JAVA - Ejercicios básicos Ficheros y Streams

<aside>
**EJERCICIO 1: LECTURA Y COPIA DE FICHEROS DE TEXTO DE MANERA SECUENCIAL**.

Tenemos un fichero de nombre “AdaLovelace.txt”. Se desea escribir toda su información en un archivo de nombre “CopiaAda.txt”
Para ello debes tener en cuenta lo siguiente:

- El primer archivo se asocia con un flujo de entrada.
- El segundo, con un flujo de salida.

Por lo tanto debemos instanciar un objeto flujo de entrada y otro de salida del tipo **FileInputStream** y **FileOutputStream**, respectivamente. 

La **lectura se deber realizar byte a byte** con el método read(); cada byte se escribe en el flujo de salida invocando al método write().

El proceso termina cuando read() devuelve –1, señal de haber alcanzado el fin del fichero “AdaLovelace.txt”. 

</aside>

<aside>
**EJERCICIO 2: GENERAR UN FICHERO DE DATOS BINARIOS**

Crea un fichero de datos binarios “datosClientes.dat” que almacene registros de datos personales. 

Para ello se va a emplear un registro con 4 campos (1: identificador, 2: nombre, 3: edad, 4: teléfono). 

A continuación se describe con más detalle cada uno de los campos:   

1. Número entero. Será el índice del registro. Comienza por el número 1.  (Int)
2. Nombre persona. Tamaño 30 caracteres. (String)
3. Edad de la persona. Número entero (Int)
4. Número de teléfono. Tamaño 9 caracteres.(String)

Para ello debes emplear las FileOutputStream y DataOutputStream. 

Se pedirán desde teclado los datos de los nuevos clientes a dar de alta hasta que el usuario/a pulse la tecla 0 para salir. 

NOTA: La generación del fichero se hará en una misma ejecución, no se pide la gestión de añadir nuevos clientes al fichero en posteriores ejecuciones. Si quieres sobreescribir el fichero deberás borrarlo del proyecto para que se cree de nuevo vacío. 

</aside>

<aside>
**EJERCICIO 3: LEER UN FICHERO DE DATOS BINARIOS DE MANERA SECUENCIAL**

Realiza un programa que lea de manera secuencial el fichero de datos binarios creado en en el ejercicio anterior y muestre los datos por pantalla. 

</aside>

<aside>
**EJERCICIO 4: LEER UN FICHERO DE DATOS BINARIOS DE MANERA ALEATORIA**

Realiza un programa que lea de manera ALEATORIA el fichero de datos binarios creado en en el ejercicio 2 y muestre los datos por pantalla. 

Para ello se pedirá al usuario el número de cliente que quiere leer, se buscará y se mostrará la información de los 4 campos (número de cliente, nombre, edad y teléfono).

El programa debe controlar que no se solicita un número de cliente que no está dado de alta, para ello podéis usar el método length() que nos devolverá la longitud del fichero en bytes y con el tamaño de registro podremos saber cuántos clientes tenemos registrados.

<aside>
💡 Ten en cuenta que es necesario conocer el **tamaño del registro en bytes**.

1. Número entero (índice del registro): 4 bytes (int).
2. Nombre de la persona (cadena de caracteres de 30 caracteres): 60 bytes (2 bytes por carácter).
3. Edad de la persona: 4 bytes (int).
4. Número de teléfono (cadena de caracteres de 9 caracteres): 18 bytes (2 bytes por carácter).
</aside>

</aside>

<aside>
** EJERCICIO 5: SERIALIZACIÓN DE OBJETOS**

En Java trabajamos con objetos y por ello disponemos de las clases **ObjectInputStream** y **ObjectOutputStream** que nos permiten leer y escribir objetos de manera muy sencilla sobre un stream. 

Para poder emplear está funcionalidad los objetos deben ser SERIALIZABLES (implementan la interfaz serializable). 

<aside>
💡 **Recuerda**: *Que un objeto sea **serializable** significa que puede ser transformado en bytes y almacenado en una cadena de caracteres para posteriormente ser leídos de forma que se reconstruya el objeto original*

</aside>

Partiendo de las clases Persona y Vehiculo: 

```java
public class Persona {

    private String DNI;
    private String nombre;
    private int edad;
    private Vehiculo vehiculo;

    public Persona(String DNI, String nombre, int edad, Vehiculo vehiculo) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.edad = edad;
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return "Persona [DNI=" + DNI + ", nombre=" + nombre + ", edad=" + edad + ", vehiculo=" + vehiculo + "]";
    }
}

```

```java
public class Vehiculo {
    private String tipo;
    private double kilometros;
    private String matricula;

    public Vehiculo(String tipo, double kilometros, String matricula) {
        this.tipo = tipo;
        this.kilometros = kilometros;
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Vehiculo [tipo=" + tipo + ", kilometros=" + kilometros + ", matricula=" + matricula + "]";
    }
}
```

<aside>
👉🏼 Realiza las modificaciones necesarias en las clases [Persona.java](http://Persona.java) y [Vehiculo.java](http://Vehiculo.java) para que puedan ser serializables.

</aside>

<aside>
👉🏼 Además completa la siguiente clase principal para poder escribir el objeto serializado en el fichero y posteriormente leerlo.

</aside>

<aside>
✅ La **SERIALIZACIÓN DE OBJETOS** hacen que la escritura y lectura de objetos en ficheros sea muy sencillo.

</aside>

 

```java
public class Ejercicio5 {
    
    public static void main(String[] args) {
    
        // Crear un objeto Vehiculo y un objeto Persona
        Vehiculo vehiculo = new Vehiculo("Coche", 10000, "1234ABC");
        Persona persona = new Persona("12345678A", "Juan", 30, vehiculo);

        // Escritura: Serializar el objeto Persona y escribirlo en el archivo
        try {
	          // Instanciar FileOutputStream para gestionar el fichero personas.dat
            
            // Instanciar ObjectOutputStream
            
            // Escribir objeto en el fichero
           
            // Cerrar instancias
            
            System.out.println("Objeto Persona serializado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Lectura: Deserializar el objeto Persona y volverlo a guardar en un objeto Persona
        try {
            // Instanciar FileInputStream para gestionar el fichero personas.dat
            
            // Instanciar ObjecInputStream
            
            // Leer objeto en el fichero
            
            // Cerrar instancias
            
            System.out.println("Objeto Persona deserializado correctamente:");
            // Mostrar objeto leido
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```

</aside>
