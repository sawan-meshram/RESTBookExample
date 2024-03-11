# RESTBookExample

This project is to demonstrate REST API using Spring Boot.

In this project, I have build API for methods such as `GET, POST, DELETE`, and `PUT`. 

Also, successfully demonstrate the `ResponseEntity` and `HttpStatus` classes to send response on client side.

The API examples is given on the following the table:

| HTTP Method 	| URI 				| Description 			| Valid HTTP Status Codes		|
| :-----------:	| :--------------- 	| :---------------------| :----------------------------	|
| POST 			| /books			| Create a book			| 201							|
| GET			| /books/{bookId}	| Read a book			| 200							|
| PUT			| /books/{bookId}	| Update a book			| 200							|
| DELETE		| /books/{bookId}	| Delete a book			| 204							|
| GET			| /books			| Retrieve all books	| 200, 204, 206					|


### Used Annotation
- @SpringBootApplication
- @RestController
- @Autowired
- @Component
- @GetMapping
- @PostMapping
- @DeleteMapping
- @PutMapping
- @PathVariable
- @RequestBody

### Examples

- **GET** `/books`

	![GET](/images/get_example.png)

- **POST** `/books`

	![POST](/images/post_example.png)

- **GET** `/books/{bookId}`

	![GET](/images/get_by_id_example.png)

- **DELETE** `/books/{bookId}`

	![DELETE](/images/delete_example.png)

- **PUT** `/books/{bookId}`

	![PUT](/images/put_example.png)

