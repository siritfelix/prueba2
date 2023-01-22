# Prueba Tecnica V1

Reto por Felix Antonio Sirit Murillo siritfelix@gmail.com

Tecnologías necesarias

`Java 11`, `Maven`, `Spring-Boot`, `h2`, `flyway`, `JPA`

Instalación del proyecto
* Clonar el proyecto desde el repositorio desde https://github.com/siritfelix/pruebatecnica.git
> git clone https://github.com/siritfelix/pruebatecnica.git

* Importar el proyecto en cualquier ide
* Compilar ejecutando: mvn clean install

* Levantar con: 
> mvn spring-boot:run
* Si usa docker crear y levantar imagen

> docker build -t pruebatecnica .
>
> docker run -p 8080:8080 pruebatecnica
>
Por defecto el perfil es dev , el cual hace un dump en la base de datos en memoria, para levantar con perfil prod, se puede usar 
>java -jar -Dspring.profiles.active=prod  vehicle-1.0.0.jar
* La descripcion de los endpoint se puede observar al levantar el proyecto, mediante el swagger accedemos al recurso: http://localhost:8080/swagger-ui.html
* La covertura de test luego de compilar se encuentra en `target\site\jacoco\index.html con 81% de coverage`

* Repositorio : https://github.com/siritfelix/pruebatecnica

docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:tag