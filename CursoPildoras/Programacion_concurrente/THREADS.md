# THREADS (o Hilos de Ejecución)

## .1 Concepto y creación

### *¿Qué es?*
- Un Thread, o Hilo de ejecución, es un único flujo de control dentro de un programa. La máquina virtual java(JVM) es capaz de ejecutar varios hilos de ejecución simultáneamente. Esto posibilita la multitarea, es decir, la realización de tareas simultaneas.

### *Crear hilos de ejecución*
1. Crear clase que implemente la interfaz *`Runnable`* (método run()).
2. Escribir el código de la tarea dentro del método `run()`.
3. Instanciar la clase creada y almacenar la instancia en variable de tipo Runnable.
4. Crear instancia de la clase `Thread` pasando como parámetro al constructor de Thread el objeto Runnable anterior.
5. Poner en marcha el hilo de ejecución con el método `start()` de la clase Thread.

## .2 Hilos e interrupciones

#### Clase Thread
### *Métodos de interrupción*

- void `interrupt()` - Solicita la interrupción de un hilo en ejecución.
- boolean `isInterrupted()` - Devuelve true/false si **éste** hilo está/no está interrumpido.
- static boolean `interrupted()` - Devuelve true/false si el hilo **actual** está/no está interrumpido.
- ~~void `stop()`~~ - Obsoleto 

### *Método sleep()* 
static void `sleep()` - Pausa la ejecución del hilo durante: tiempo en milisegundos pasado por parámetro.
- Cuando el hilo se encuentra pausado por sleep, si se trata de interrumpir con el método `interrupt()`, el método void `sleep()` lanza una excepción `InterruptedException`

## .3 Sincronización de Threads

### *Estados de los Threads*
- **Nuevo** - Adquiere este estado al instanciarse.
- **Ejecutable** - Adquiere este estado cuando ya se ha iniciado con el método `start()`
- **Bloqueado** - Adquiere este estado cuando estando en estado Ejecutable se llama al método `sleep()`.
- **Muerto** - Adquiere este estado cuando concluye el método `run()`. Cuando ocurre una excepción y ésta no se captura. O cuando utilizamos el método ~~`stop()`~~.

En el uso de los hilos, surge la necesidad de sincronizar sus estados para el correcto funcionamiento del programa, hay varias formas de implementar esta **sincronización**:

- Uso del método `join()` de la clase Thread

- **Bloqueos explícitos**

    Tipos:

    0. Sin condición
    1. Una condición
    2. Varias condiciones
<br></br>
- **Bloqueos implícitos** (object)

Paquete `java.util`

import `java.util.concurrent.locks.`

### .3.1 Bloqueos explícitos (Locks)
0. Bloqueos **sin** condición - Como el bloqueo de reentrada:
    - Instanciando la clase `ReentrantLock`
    - Utilizando esa instancia desde el principio de la parte del código que queremos bloquear, llamando al método `lock()` para bloquear la entrada a esa parte del código al resto de hilos.
    - Utilizando la misma instancia, al final del código que queremos bloquear, llamando al método `unlock()` para desbloquear la entrada.
<br></br>

Un `Lock` puede tener varias `Condition` asociadas y de esta forma cada thread espera a su condición concreta.

1. Bloqueos con **una** condición
    - Seguimos los pasos para bloqueos sin condición y luego:
    - Todo el código que queremos bloquear lo metemos en un bloque `try-finally`
    - En el constructor de la clase creamos una nueva condición llamando al método `newCondition()` desde la instancia de la clase `ReentrantLock` que hemos creado en los pasos anteriores. Y guardamos esta condición en una variable de tipo `Condition`.
    - Dentro del bloque try-finally, y utilizando la variable de tipo Condition creada anteriormente, llamamos al `método await()` cuando se cumpla una condición. De esta manera el Thread que leyó la instrucción se pondrá en espera.
    - En el bloque finally llamamos al método `signalAll()` que "avisa" a los Threads en espera para que revisen si la condición se sigue cumpliendo. En caso de que se cumpliera la condición el Thread cambiaría su estado y continuaría la ejecución.
<br></br>
2. Bloqueos con **varias** condiciones
    - Repetimos los pasos que seguimos para bloquear con una unica condición, y establecemos una nueva condición bajo la que llamaremos al método `await()`.

### .3.2 Bloqueos implícitos
- Uso de palabra reservada `synchronized` en la definición del bloque de código después del modificador de acceso. Ej.: `public synchronized void ...`.
- Uso de métodos de la clase Object como `wait()` y `notifyAll` entre otros.
    - `wait()` - pone el hilo en espera.
    - `notifyAll()` - notifica a los hilos en espera para que revisen la condición y actualicen su estado según si se cumple o no.
- Esta forma de sincronizar nos permite establecer **una única condición** de bloqueo.