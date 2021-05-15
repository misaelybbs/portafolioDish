
I-----

Ejecutar la base d datos de la carpeta BD

II------

Cambiar de cada proyecto de la carpeta "Services" los siguientes datos en el archivo de configuración application.yml

spring.datasource.url=jdbc:mysql://localhost:3306/cruddish?serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=root

de acuerdo a la ruta de base de datos donde se instalará y credenciales de la base de datos.

Una vez Renomabrado las direccions ip, ejecutar los servicios de las carpetas en el siguiente orden una a una.

1 - EurekaService
2 -Login
3 - Demo
4 - DemoServiciosCrud

Los servicios quedarán en linea y funcionando.

III------

En el projecto de la carpeta APP, cambiar:

De la clase "Utils" la direccion con la ip local 
public static final String dir = "http://192.168.1.86:9095/projects/";

De el achivo de prpoiedades "app.properties" cambiar las direcciones ip locales donde se ecuentre corriendo
los servicios
url.base.services = http://192.168.1.86:8761/api/
url.base.services2 = http://192.168.1.86:9093/crud/
url.base.services3 = http://192.168.1.86:9095/projects/

Ejecutar e instalar la aplicación en telefonos Android 10+.

alan.misael.se@hotmail.com