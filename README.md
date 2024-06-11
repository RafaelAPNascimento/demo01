# Getting Started Spring WebFlux

### Reference Documentation


Create a reactive API with the following services:

    GET /square/{input}         // specify a range and on values outside that range the API should return an error (400)

    GET /table/{input}          // return the input table as stream, set an artifical delay before every multiplication (200)

    POST /multiply              // return the multiplication of the numbers inside the body, use a DTO      (201)


Return all results in a Response dto with resulf field and a dateTime