# Generate Javadocs for multiple packages
## Generar Javadocs de multiples paquetes

*Instrucciones para generar documentacion de multiples paquetes desde cualquier directorio*

javadoc -d [DESTINATION_FOLDER] -sourcepath [SOURCE_FOLDER] -subpackages [PACKAGE1]:[PACKAGE2]

For example, if your hierarchy is:

- /home/my_project/src/com/foo/Class1.java
- /home/my_project/src/fr/foo/Class2.java

Then your command line will look like:

javadoc -d [DESTINATION_FOLDER] -sourcepath /home/my_project/src -subpackages com:fr
