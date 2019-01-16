### spring 替代  web.xml的方式
- WebApplicationInitializer 这个接口的实现类 替代了web.xml，通过实现 WebApplicationInitializer,
可以在里边添加 servlet ,listener 
- spring 提供了一个默认实现 SpringServletContainerInitializer,通过 spi机制去加载
- spi机制要打包才能起作用
