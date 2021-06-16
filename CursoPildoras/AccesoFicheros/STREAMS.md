# STREAMS (Flujos de datos o Secuencias)

## .1 Manejo de archivos. Acceso a ficheros

### *¿Qué es un Stream?*
- Es un **flujo de datos** mediante el cual se comunican el **programa** y el **origen/destino** de la información.
    1. Flujo de Entrada (comunicación programa-origen)
    2. Flujo de Salida (comunicación programa-destino)

### *¿Porqué el uso de ficheros?*

- Para **almacenar** la información de forma **permanente** en algún dispositivo de almacenamiento, y no en RAM, que es temporal.
Para hacerlo necesitamos el uso de Streams.
    - Modos de **acceso a ficheros**:
        - Modo **Escritura**
        - Modo **Lectura**
    - Modos de **acceso a datos** del fichero:
        - Acceso **secuencial** (De principio a fin)
        - Acceso **directo** o Aleatorio (A partir de una posición determinada)
<br/><br/>

Las **clases** vinculadas a los flujos Entrada y Salida (E/S) se encuentran en el **paquete `java.io`**

**Excepción** vinculada y definida en el mismo paquete: **`IOException`**

![java.io](src/img/javaIO.png)


### *Formas de abordar los streams:*
1. Flujos de **Bytes**
    - **Uso general:** envío de información a través de la red. 
    - **Clases:** `InputStream` y `OutputStream` (Abstractas).
2. Flujos de **Caracteres**
    - **Uso general:** lectura/escritura de datos "humana".
    - **Clases:** `Reader` y `Writer` (Abstractas).

### *Clases fundamentales:*

![clases fundamentales de java.io](src/img/clasesFundamentalesIO.png)
<br/><br/>

## .2 Buffer (Modificador de flujo o Filtro)

### *¿Qué es un Buffer?*
- Un buffer es un modificador de flujo, es decir, altera el comportamiento normal del Stream, y lo hace para mejorar el rendimiento en la lectura/escritura de grandes cantidades de datos.

### *¿Cómo lo hace?*
- **Lectura:** Se cargan en memoria más datos de los necesarios en un primer momento, para que no sea necesario volver a acceder a  todos los datos desde el dispositivo de almacenamiento.
- **Escritura:** Los datos se van guardando en memoria y no se vuelcan hasta que hay una cantidad suficiente para el correcto funcionamiento.

**Clases:** `BufferedReader` ,  `BufferedWriter` , (`Buffered...`)

