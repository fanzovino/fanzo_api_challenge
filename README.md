
# Desafío Técnico - DECRYPTO

Este repositorio brinda una API REST con las operaciones CRUD
necesarias para gestionar el recurso Comitente, Mercado, País, y su
relacionamiento.

# Empezando
Requisitos previos:
Java JDK 11 o posterior
Apache Maven 3.5.0 o posterior
Postman

# Clonar el repositorio:
Clone el repositorio a un directorio local

```bash
  git clone https://https://github.com/fanzovino/fanzo_api_challenge.git
```


# Ejecutar la aplicación:
Desde CMD o PowerShell ubicar el directorio
```bash
cd fanzo_api_challenge
mvn spring-boot:run
```



# API ENDPOINT 
(Se puede encontrar en las clases de controlador)


## API Reference

#### GET-Comitentes: Obtener todos los Comitentes

```http
  GET /api/comitente
```

####  GET-Comitente: Obtener Un comitente en particular

```http
  GET /api/comitente/${id}
```

| Parametro | Tipo     | Descripción                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to fetch |

####  POST-Comitente: Obtener Un comitente en particular

```http
  POST /api/comitente
```


            
    {   "nombre": "Comitente Nombre1",
        "mercado": [
                    { "codigo": "M001",
                      "descripcion": "Descripcion Mercado 1",
                      "pais": "ARGENTINA"
                    },
                    { "codigo": "M002",
                      "descripcion": "Descripcion Mercado 2",
                      "pais": "URUGUAY"
                    }
         ]
     }

#### GET-Mercados: Obtener todos los Mercados

```http
  GET /api/mercado
```

####  GET-Mercados: Obtener Un mercado en particular

```http
  GET /api/mercado/${id}
```

| Parametro | Tipo     | Descripción                       |

| :-------- | :------- | :-------------------------------- |

| `id`      | `string` | **Required**. Id of item to fetch |

####  POST-Mercados: Obtener Un mercado en particular

```http
  POST /api/mercado
```

    { "codigo": "M001", 
      "descripcion": "Descripción del Mercado 1", 
      "pais": "ARGENTINA", 
      "comitentes": [
            { "id": 1, 
              "nombre": "C001" } 
          ] 
    }


# Tecnologías utilizadas
Spring Boot
Spring Data
JPA
H2 DBA




