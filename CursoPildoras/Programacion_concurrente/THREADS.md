# THREADS (o Hilos de Ejecución)

### *¿Qué es?*
- (...)
### *Crear hilos de ejecución*
1. Crear clase que implemente la interfaz Runnable (método run()).
2. Escribir el código de la tarea dentro del método run.
3. Instanciar la clase creada y almacenar la instancia en variable de tipo Runnable.
4. Crear instancia de la clase Thread pasando como parámetro al constructor de Thread el objeto Runnable anterior.
5. Poner en marcha el hilo de ejecución con el método start() de la clase Thread.