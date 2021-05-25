# calculator
Microservicio API con Spring-boot de calculadora que realiza las operaciones basicas de sumar, restar, multiplicar y dividir

#Modo de utilizacion
Para poder ejecutar el siguiente microservicio se han de seguir los siguientes pasos:
	1- Tener el codigo descargado en nuestro equipo, para ello lo haremos con el siguiente codigo: "git clone https://github.com/cmodest/calculator.git"
	2- Realizar una instalacion desde cero con Maven que podemos hacer con el comando "mvn clean install" desde el directorio raiz del proyecto.
	3- Ejecutar el archivo .jar resultante de la instalacion, el comando seria el siguiente "java -jar calculator-1.0.0-SNAPSHOT.jar"	
	
A pertir de aqui ya podemos lanzar las peticiones a la direccion "http://localhost:8080/iteriam/api/calculate"

#Funcionamiento

Los datos que se han de pasar al API tienen que ser a traves de la url de la peticion que hacemos y el API recibe tres datos diferentes que son los dos operadores y el tipo de operacion a realizar.
Los operadores se envian bajo los objetos operator1 y operator2.
Las operaciones se envian bajo el objeto operationType y se pueden poner tanto por simbolo(+,-,*,/) como por palabras(add,substraction,multiplication,division).
Para poner la operacion como simbolo la equivalencia de los simbolos al añadirlos en la url es la siguiente:
	,Simbolo "+" --> %2B
	,Simbolo "-" --> -
	,Simbolo "/" --> %2F
	,Simbolo "*" --> *
	

De esta manera un ejemplo de peticion seria la siguiente "http://localhost:8080/iteriam/api/calculate?operator1=3&operator2=10&operationType=multiplication" y el resultado que nos devolveria seria 30.
Y otro ejemplo introduciendo la operacion como simbolo podria ser "http://localhost:8080/iteriam/api/calculate?operator1=3&operator2=10&operationType=%2B" y el resultado seria 13.
Ademas tambien podremos ver el resultado de la operacion en la consola donde hemos ejecutado el archivo .jar con una traza en la que nos da el resultado de la operacion.

