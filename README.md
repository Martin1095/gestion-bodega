# Sistema de Gestión de Bodegas

Proyecto desarrollado en **Spring Boot** orientado a la administración y control de bodegas, permitiendo gestionar artículos, inventario, pedidos, clientes y despachos mediante una arquitectura basada en microservicios.

## Descripción

El sistema permite optimizar la gestión logística de una bodega mediante el control de:

- Registro de artículos
- Gestión de inventario
- Administración de bodegas
- Gestión de clientes
- Control de pedidos
- Seguimiento de despachos
- Gestión de proveedores
- Detalle de pedidos
- Recepción de productos

El objetivo principal es mejorar la organización y trazabilidad de los procesos de almacenamiento y distribución.


## Tecnologías utilizadas

- Java 21
- Spring Boot
- Maven
- Spring Web
- JPA Repository
- Visual Studio Code
- Git y GitHub


# Arquitectura del proyecto

El sistema está organizado bajo arquitectura por capas:

## Model
Contiene las entidades del sistema.

## Repository
Gestiona el acceso a datos mediante interfaces.

## Service
Contiene la lógica de negocio.

## Controller
Expone los endpoints REST.

## DTO
Permite transferencia estructurada de datos.


# Microservicios implementados

- Cliente
- Pedido
- Artículo
- Detalle Pedido
- Bodega
- Inventario
- Despacho
- Recepción
- Proveedor
- Trabajador


# Funcionalidades principales

## Inventario
- Control de stock
- Registro de cantidades disponibles
- Asociación con bodegas

## Bodega
- Gestión de información de bodegas
- Ubicación y capacidad

## Despacho
- Registro de salida de productos
- Seguimiento de entregas

## Pedido
- Administración de solicitudes de clientes

## Proveedor
- Registro de abastecimiento


# Integrantes

- Cordoliani Moises Aaron
- Galvez Cesar Andre
- Maulen Martin Alfonso


# Cómo ejecutar el proyecto

1. Abrir el proyecto en el IDE (IntelliJ o Eclipse)  
2. Ejecutar la aplicación como Spring Boot App  
3. Acceder a: http://localhost:8080  
