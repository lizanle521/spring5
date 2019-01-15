Spring Boot lets you externalize your configuration so that you can work with 
the same application code in different environments. You can use properties files, 
YAML files, environment variables, and command-line arguments to externalize configuration. 
Property values can be injected directly into your beans by using the @Value annotation,
 accessed through Spring’s Environment abstraction, or be bound to structured objects 
 through @ConfigurationProperties.

Spring Boot uses a very particular PropertySource order that is designed to allow 
sensible overriding of values. Properties are considered in the following order:
### 配置优先级 

1. Devtools global settings properties on your home directory (~/.spring-boot-devtools.properties when devtools is active).
2. @TestPropertySource annotations on your tests.
3. @SpringBootTest#properties annotation attribute on your tests.
4. Command line arguments.
5. Properties from SPRING_APPLICATION_JSON (inline JSON embedded in an environment variable or system property).
6. ServletConfig init parameters.
7. ServletContext init parameters.
8. JNDI attributes from java:comp/env.
9. Java System properties (System.getProperties()).
10. OS environment variables.
11. A RandomValuePropertySource that has properties only in random.*.
12. Profile-specific application properties outside of your packaged jar (application-{profile}.properties and YAML variants).
13. Profile-specific application properties packaged inside your jar (application-{profile}.properties and YAML variants).
14. Application properties outside of your packaged jar (application.properties and YAML variants).
15. Application properties packaged inside your jar (application.properties and YAML variants).
16. @PropertySource annotations on your @Configuration classes.
17. Default properties (specified by setting SpringApplication.setDefaultProperties).

#### dev-tools 配合自动编译实现热部署
- “File” -> “Settings” -> “Build,Execution,Deplyment” -> “Compiler”，选中打勾 “Build project automatically” 。
- 组合键：“command + shift + a” ，选择 “Registry” ，选中打勾 “compiler.automake.allow.when.app.running” 。

### 配置文件起作用的地方 

SpringApplication loads properties from application.properties 
files in the following locations and adds them to the Spring Environment:

1. A /config subdirectory of the current directory
2. The current directory
3. A classpath /config package
4. The classpath root