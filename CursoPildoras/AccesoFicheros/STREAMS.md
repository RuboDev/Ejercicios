# STREAMS (Flujos de datos o Secuencias)

## Manejo de archivos. Acceso a ficheros

### *¿Porqué el uso de ficheros?*

- Para **almacenar** la información de forma **permanente** en algún dispositivo de almacenamiento, y no en RAM, que es temporal.
Para hacerlo necesitamos el uso de Streams.

Paquete **`java.io`**

### *Formas de abordar los streams:*
1. Flujos de **Bytes**
    - **Uso general:** envío de información a través de la red. 
    - **Clases:** `InputStream` y `OutputStream` (Abstractas).
2. Flujos de **Caracteres**
    - **Uso general:** lectura/escritura de datos "humana".
    - **Clases:** `Reader` y `Writer` (Abstractas).

