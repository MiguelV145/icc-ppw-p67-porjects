# Evaluación Técnica: Gestión de Personas y Proyectos de Software

## Instrucciones de Desarrollo

Para ver las instrucciones completas del desarrollo de la evaluación, consulta el documento:

**[Ver especificaciones completas aquí](https://pablot18.github.io/icc-ppw-p67-porjects/)**

---

## CRITERIOS DE EVALUACIÓN

### Backend (60%)

| Criterio                                                          | Puntos |
|-------------------------------------------------------------------|--------|
| ENDPOINT 1 – GET /api/persons (con filtro activeOnly)             | 6.0    |
| ENDPOINT 2 – PATCH /api/persons/{id}/toggle-active                | 6.0    |
| ENDPOINT 3 – GET /api/persons/{id}                                | 6.0    |
| ENDPOINT 4 – GET /api/persons/{id}/projects (con filtro minCost)  | 6.5    |
| Relaciones JPA correctas (OneToMany, ManyToOne, OneToOne)         | 2.0    |
| Estructura del proyecto y arquitectura                            | 4.0    |
| **SUBTOTAL BACKEND**                                              | **30.0** |

### Frontend (40%)

| Criterio                                                          | Puntos |
|-------------------------------------------------------------------|--------|
| Página Home: Listado de personas con cards                        | 6.0    |
| Página Home: Filtro activos y botón activar/desactivar            | 2.0    |
| Página Home: Íconos de redes sociales y navegación                | 1.5    |
| Página Proyectos: Información de persona y listado de proyectos   | 6.0    |
| Página Proyectos: Filtro por costo                                | 2.0    |
| Manejo de casos especiales (sin proyectos, persona inexistente)   | 2.0    |
| Validaciones de rutas (/proyectos sin ID, ID inválido)            | 1.5    |
| **SUBTOTAL FRONTEND**                                             | **20.0** |

---

##  NOTAS IMPORTANTES

**Backend:**
- Cada endpoint debe cumplir EXACTAMENTE con la estructura del DTO
- Relaciones JPA deben estar correctamente configuradas
- Códigos HTTP deben ser los especificados
- Validaciones de negocio deben estar implementadas

**Frontend:**
- Las interfaces TypeScript deben coincidir con los DTOs del backend
- Manejo de errores debe ser robusto (404, errores de red, etc.)
- La navegación debe funcionar correctamente
- Los filtros deben llamar correctamente a los endpoints

**Datos de prueba:**
- 10 personas: 8 activas, 2 inactivas
- Persona #2 NO debe tener proyectos (caso especial a probar)
- Cada persona: 2-4 enlaces de contacto
- Cada persona (excepto #2): 5-10 proyectos
- Enlaces deben incluir GitHub, LinkedIn y otros

**Penalización total (0 puntos) si:**
- Backend y Frontend no se comunican
- Relaciones JPA incorrectas
- Endpoints no funcionan según especificación
- Páginas no cargan o tienen errores críticos

---

##  Tecnologías

**Backend:** Spring Boot | Java | Gradle | H2 Database  
**Frontend:** Angular 19+ | TypeScript | Standalone Components
