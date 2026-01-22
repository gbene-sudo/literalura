# 📚 Literalura

Proyecto desarrollado en **Java con Spring Boot** que consume la API pública **Gutendex** para buscar libros, almacenar información en una base de datos **PostgreSQL** y permitir consultas a través de un menú por consola.

---

## 🚀 Funcionalidades

La aplicación permite:

1. 🔍 **Buscar libros por título**
   - Consulta la API de Gutendex
   - Guarda el libro en la base de datos si no existe
   - Evita duplicados

2. 📖 **Listar libros registrados**
   - Muestra todos los libros almacenados en la base de datos

3. ✍️ **Listar autores registrados**
   - Muestra todos los autores guardados

4. 📆 **Listar autores vivos en un año determinado**
   - Filtra autores según año de nacimiento y fallecimiento

5. 🌍 **Listar libros por idioma**
   - Permite filtrar libros por idioma (ej: `es`, `en`, `fr`)

---

## 🛠️ Tecnologías utilizadas

- ☕ **Java 17**
- 🌱 **Spring Boot**
- 🗄️ **Spring Data JPA**
- 🐘 **PostgreSQL**
- 🔄 **Hibernate**
- 🌐 **API Gutendex**
- 📦 **Maven**

---

## 🧱 Arquitectura del proyecto

El proyecto sigue una arquitectura en capas:

├── Model → Entidades JPA
├── DTO → Clases para mapear datos de la API
├── Repository → Interfaces JPARepository
├── Service → Lógica de negocio
├── Principal → Menú e interacción por consola

## 🗃️ Base de datos

- Base de datos: **PostgreSQL**
- Persistencia implementada con **JPA / Hibernate**

Durante el desarrollo, las tablas se generan automáticamente con Hibernate.

Configuración recomendada en `application.properties` para entorno de desarrollo:

```properties
spring.jpa.hibernate.ddl-auto=create
