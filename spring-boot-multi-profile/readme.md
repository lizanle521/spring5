### 属性相似绑定
For example, consider the following @ConfigurationProperties class:
```java
@ConfigurationProperties(prefix="acme.my-project.person")
public class OwnerProperties {

	private String firstName;

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
```
In the preceding example, the following properties names can all be used:

| Property | Note |
| --------|--------|
|acme.my-project.person.first-name | Kebab case, which is recommended for use in .properties and .yml files.
|acme.myProject.person.firstName   |  Standard camel case syntax.
| acme.my_project.person.first_name | Underscore notation, which is an alternative format for use in .properties and .yml files. 
| ACME_MYPROJECT_PERSON_FIRSTNAME | Upper case format, which is recommended when using system environment variables.

- The prefix value for the annotation must be in kebab case (lowercase and separated by -, such as acme.my-project.person).


When binding to Map properties, if the key contains anything other than lowercase alpha-numeric characters or -, 
you need to use the bracket notation so that the original value is preserved. If the key is not surrounded by [],
 any characters that are not alpha-numeric or - are removed. For example, consider binding the following properties to a Map:
 ```yml
 acme:
  map:
    "[/key1]": value1
    "[/key2]": value2
    /key3: value3
 ```
 
 The properties above will bind to a Map with /key1, /key2 and key3 as the keys in the map.
 
 
 ####  Map List属性注入的不同点
 List 注入的时候在有多个注入点的时候，只会用一个 注入结果
 Map在注入的时候可以合并不同的注入点
 
 ###  ConfigurationProperties  和 Value 注解的区别
 
 @ConfigurationProperties vs. @Value
 
 The @Value annotation is a core container feature, and it does not provide the same features as type-safe configuration properties. The following table summarizes the features that are supported by @ConfigurationProperties and @Value:
 
 
 | Feature |	@ConfigurationProperties	|@Value
 | -----------| -------------| -------------|
 |Relaxed binding |Yes   |No
| Meta-data support |Yes  | No
|SpEL evaluation  | No  | Yes
 
 If you define a set of configuration keys for your own components, we recommend you group them in a POJO 
 annotated with @ConfigurationProperties. You should also be aware that, since @Value does not support relaxed binding,
  it is not a good candidate if you need to provide the value by using environment variables.
 
 Finally, while you can write a SpEL expression in @Value, such expressions are not processed from application property files.