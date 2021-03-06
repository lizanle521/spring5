A SpringApplication attempts to create the right type of ApplicationContext on your behalf. 
The algorithm used to determine a WebApplicationType is fairly simple:

- If Spring MVC is present, an AnnotationConfigServletWebServerApplicationContext is used
- If Spring MVC is not present and Spring WebFlux is present, 
an AnnotationConfigReactiveWebServerApplicationContext is used
- Otherwise, AnnotationConfigApplicationContext is used

This means that if you are using Spring MVC and the new WebClient from Spring WebFlux in the 
same application, Spring MVC will be used by default. 
You can override that easily by calling setWebApplicationType(WebApplicationType).

It is also possible to take complete control of the ApplicationContext type that 
is used by calling setApplicationContextClass(…​).

#### Tip
```It is often desirable to call setWebApplicationType(WebApplicationType.NONE) 
when using SpringApplication within a JUnit test.
```
