### BACKEND
The microservice was developed in Java 11 with Spring Boot and to save information I use a no relational database - MongoDB

## Resources
*Java 11
*Spring Boot
*AWS
*MongoDB Cloud


### Getting started

Clone Project to a path of your computer, then open with ide, I use Intellij IDEA or Spring Tools Suite,
but i love IntelliJ IDEA because I can work Backend and Frontend in a single ide.

Then execute maven update for download the dependencies.

## Testing
the swagger documentation is
http://itretailmscliente-env.g3aeth4psa.us-east-1.elasticbeanstalk.com/itretail/swagger-ui.html#/client-controller/

For Testing the Microservice is deployed in AWS and this is the endpoint, copy in postman the next
for new Client

body request

 {
        "nombres": "juan jose",
        "apellidoPaterno": "velasco",
        "apellidoMaterno": "del rio",
        "edad":17,
        "fechaDeNacimiento": "1998-12-10"
}

### FRONTEND


 
