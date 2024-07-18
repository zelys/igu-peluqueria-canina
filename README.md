# App de escritorio para Peluquería Canina

App desarrollada con Java Swing con conexión a base de datos MySQL.

## Tecnologías

- Java JDK 17
- Java JPA
- MySQL
- Maven

## Dependencias

- MySQL Driver
- Hibernate
- Lombok

[![En Desarrollo](https://img.shields.io/badge/Estado-En%20Desarrollo-yellow?style=for-the-badge&logo=codecov&logoColor=white)](https://github.com/tu-usuario/tu-repositorio)

## Registros para interactuar con la base de datos

- Tabla duenios:
```sql
INSERT INTO duenios (nombreDuenio, telefono)
VALUES ('Juan Pérez', '123456789'),
       ('María García', '987654321'),
       ('Carlos Sánchez', '456789123'),
       ('Ana Martínez', '789123456'),
       ('Luis Rodríguez', '321654987'),
       ('Laura Fernández', '654321789'),
       ('José López', '147258369'),
       ('Marta Gómez', '369258147');
```
- Tabla mascotas
```sql
INSERT INTO mascotas (nombreMascota, raza, color, alergico, atencionEspecial, observacion, duenio_id)
VALUES ('Firulais', 'Labrador', 'Negro', 0, 0, 'Ninguna observación', 1),
       ('Michi', 'Persa', 'Blanco', 1, 1, 'Alergia a ciertos alimentos', 2),
       ('Rex', 'Pastor Alemán', 'Marrón', 0, 1, 'Requiere medicación diaria', 3),
       ('Bunny', 'Conejo', 'Gris', 1, 0, 'Alergia al polvo', 4),
       ('Thor', 'Golden Retriever', 'Dorado', 0, 0, 'Ninguna observación', 5),
       ('Nala', 'Siames', 'Marrón claro', 1, 0, 'Alergia a los lácteos', 6),
       ('Luna', 'Bulldog Francés', 'Blanco con negro', 0, 1, 'Requiere cuidado especial en la piel', 7),
       ('Rocky', 'Boxer', 'Atigrado', 0, 0, 'Ninguna observación', 8);
```