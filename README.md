# micro-storage-springboot
A REST API connected to a H2 database with its own CRUD operations, URL, and HTTP methods.
Resouce Paths.
- POST: http://localhost:8003/api/storage/retrieve
- POST: http://localhost:8003/api/storage/create

JSON Body:

    {
        "name": "Romo Paz Karla",
        "location": "Guadalajara,Jalisco",
        "date": "12/01/2024",
        "managerName": "Karla Romo Paz",
        "listaIdProductos": [
            2,
            3,
            5
         ]
    }

- PUT: http://localhost:8003/api/storage

JSON Body (same as the previous one but including the idManager field):

- DELETE: http://localhost:8003/storage/remove
