# THREADS (o Hilos de Ejecución)

## .1 Concepto y creación

### *¿Qué es?*
- Un Thread, o Hilo de ejecución, es un único flujo de control dentro de un programa. La máquina virtual java(JVM) es capaz de ejecutar varios hilos de ejecución simultáneamente. Esto posibilita la multitarea, es decir, la realización de tareas simultaneas.

### *Crear hilos de ejecución*
1. Crear clase que implemente la interfaz Runnable (método run()).
2. Escribir el código de la tarea dentro del método run.
3. Instanciar la clase creada y almacenar la instancia en variable de tipo Runnable.
4. Crear instancia de la clase Thread pasando como parámetro al constructor de Thread el objeto Runnable anterior.
5. Poner en marcha el hilo de ejecución con el método start() de la clase Thread.

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
- **Ejecutable** - Adquiere este estado cuando ya se ha iniciado con el método start()
- **Bloqueado** - Adquiere este estado cuando estando en estado Ejecutable se llama al método sleep().
- **Muerto** - Adquiere este estado cuando concluye el método run(). Cuando ocurre una excepción y ésta no se captura. O cuando utilizamos el método ~~stop()~~.