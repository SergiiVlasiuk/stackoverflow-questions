## GraphQL curl request

```
curl -X POST http://localhost:8085/graphql \
    -H "Content-Type: application/json" \
    -d '{"query":"query {\n  bookById(id: \"book-1\"){\n    id\n    name\n    pageCount\n    productionDate\n    authors {\n      id\n      firstName\n      lastName\n    }\n  }\n}"}'
```

## GraphQL answer
```
{"data":{"bookById":{"id":"book-1","name":"Harry Potter and the Philosopher's Stone","pageCount":223,"productionDate":"2017-01-13","authors":[{"id":"author-1","firstName":"Joanne","lastName":"Rowling"}]}}}
```

# The issue

I can't use custom `LocalDate` in the `graphqls` (line 11).
The `ScalarConfiguration` seems like useless. It loads `runtimeWiringConfigurer`, but `dateScalar` doesn't help with type registering. 

