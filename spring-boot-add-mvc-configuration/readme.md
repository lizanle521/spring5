### spring-boot 自动配置 mvc
spring boot 提供的自动配置在大多数情况下都工作的很好
自动配置提供了以下默认的特性：
1. ContentNegotiatingViewResolver 和 BeanNameViewResolver
2. 支持对静态资源的访问，包括对 webjars 的支持
3. 自动注册converter,genericconverter,formatter等bean
4. 支持HttpMessageConverter
5. 自动注册messageCodeResolver
6. 静态index.html
7. 自定义的favicon
8. 自动使用configurableWebBindingInitializer这个bean

如果你想保持mvc的特性并且添加一些额外的特性（interceptors,formatters,view controllers）,
可以添加一个WebMvcConfigurer 的子类，带有 Configuration 注解，不能有EnableWebMvc注解

如果你想添加一些自定义的实例（譬如 RequestMappingHandlerMapping, RequestMappingHandlerAdapter, or ExceptionHandlerExceptionResolver)
你可以声明一个 WebMvcRegistrationsAdapter 去提供这些组建

如果你想完全控制 spring mvc , 那么你可以添加你自己的 @Configuration 的类 并配上 @EnableWebMvc注解
