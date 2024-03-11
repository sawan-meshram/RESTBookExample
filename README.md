# RESTBookExample

This project is to demonstrate REST API using Spring Boot.

In this project, I have build API for methods such as `GET, POST, DELETE`, and `PUT`.

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

- `/books`

	![GET](/images/get_example.png)

- `/books`

	![POST](/images/post_example.png)

- `/books/{bookId}`

	![GET](/images/get_by_id_example.png)

- `/books/{bookId}`

	![DELETE](/images/delete_example.png)

- `/books/{bookId}`

	![PUT](/images/put_example.png)
