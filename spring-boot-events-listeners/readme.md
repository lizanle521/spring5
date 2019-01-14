In addition to the usual Spring Framework events, such as ContextRefreshedEvent, a SpringApplication sends some additional
 application events.

[Note]
Some events are actually triggered before the ApplicationContext is created, so you cannot register a listener on those as a @Bean.
 You can register them with the SpringApplication.addListeners(…​) method or the SpringApplicationBuilder.listeners(…​) method.
If you want those listeners to be registered automatically, regardless of the way the application is created, 
you can add a META-INF/spring.factories file to your project and reference your listener(s) by using the 
org.springframework.context.ApplicationListener key, as shown in the following example:
org.springframework.context.ApplicationListener=com.example.project.MyListener
Application events are sent in the following order, as your application runs:

An ApplicationStartingEvent is sent at the start of a run but before any processing, except for the registration of listeners and initializers.
An ApplicationEnvironmentPreparedEvent is sent when the Environment to be used in the context is known but before the context is created.
An ApplicationPreparedEvent is sent just before the refresh is started but after bean definitions have been loaded.
An ApplicationStartedEvent is sent after the context has been refreshed but before any application and command-line runners have been called.
An ApplicationReadyEvent is sent after any application and command-line runners have been called. It indicates that the application is ready to service requests.
An ApplicationFailedEvent is sent if there is an exception on startup.
[Tip]
You often need not use application events, but it can be handy to know that they exist. Internally, Spring Boot uses events to handle a variety of tasks.
Application events are sent by using Spring Framework’s event publishing mechanism. Part of this mechanism ensures that an event published to the listeners in a child context is also published to the listeners in any ancestor contexts. As a result of this, if your application uses a hierarchy of SpringApplication instances, a listener may receive multiple instances of the same type of application event.

To allow your listener to distinguish between an event for its context and an event for a descendant context, it should request that its application context is injected and then compare the injected context with the context of the event. The context can be injected by implementing ApplicationContextAware or, if the listener is a bean, by using @Autowired.