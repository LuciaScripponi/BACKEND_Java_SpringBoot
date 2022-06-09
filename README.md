# BACKEND_Java_SpringBoot
Este API REST esta creada en **Java 8**, mediante el **IDE IntelliJ IDEA**. 
Se utilizó **Springboot** con Maven para armar el proyecto.

### 📌 Instrucciones para correr 📌
1️⃣ Dentro del proyecto, en la ruta:
```
src/main/resources/application.properties
```
configurar conexion a la base de datos url, puerto,user, password, etc. y guardar configuracion.
  
2️⃣ Abrir el motor de base de datos deseado (que sea MySQL) y correr el script para ingresar datos a la base (raiz del proyecto, en la carpeta database).

3️⃣ En la ruta:
```
src/main/java/ApiInstrumentosApplication
```
se encuentra el metodo main. Hay que correr el proyecto desde ahi (con el motor y la base de datos corriendo).
   
4️⃣ En el navegador, colocar [localhost:8080/instrumentos](https://localhost:8080/instrumentos) para verificar el funcionamiento del backend (debe retornar el Json completo, con todos los instrumentos). Probar los demas endpoints (se encuentran en InstrumentoController).

5️⃣ Ejecutar [Frontend 🖥](https://github.com/LuciaScripponi/FRONTEND_React_TypeScript)
