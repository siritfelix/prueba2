# Prueba Tecnica 2

Reto por Felix Antonio Sirit Murillo siritfelix@gmail.com

Tecnologías necesarias

`Java 11`, `Maven`, `Spring-Boot`, `h2`,`Mysql 8`, `flyway`, `JPA`

Instalación del proyecto
* Clonar el proyecto desde el repositorio desde https://github.com/siritfelix/prueba2.git
> git clone https://github.com/siritfelix/prueba2.git

* Importar el proyecto en cualquier ide
* Compilar ejecutando: mvn clean install

* Levantar con: 
> mvn spring-boot:run
* Si usa docker crear puede levantar los contendedores por medio de :
> docker-compose up

Esto descargara las imagenes de MySql 8 y Java 11 para ejecutar la aplicacion en contenedores, esto puede tardar unos minutos.

Por defecto el perfil es dev que cual hace un dump en la base de datos al momento de levantar la aplicacion pero puede ejecutar el perfil prod. para no volcar datos a la db por medio de
>java -jar -Dspring.profiles.active=prod  prueba2-1.0.0.jar.jar
* La descripcion de los endpoint se puede observar al levantar el proyecto, mediante el swagger accedemos al recurso: http://localhost:8080/swagger-ui.html
* La covertura de test luego de compilar se encuentra en `target\site\jacoco\index.html con 81% de coverage`

* Repositorio : https://github.com/siritfelix/prueba2.git