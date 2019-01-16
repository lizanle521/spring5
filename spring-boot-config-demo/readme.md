### 命令行属性
spring boot 将会把命令行参数（以--开始的参数，譬如--server.port=8080）转换成属性对，
并添加到 Enviroment对象中。命令行参数优先级是最高的。

如果你不想把命令行参数添加到 Enviroment对象中，那么请用如下方式：
SpringApplication.setAddCommandLineProperties(false)；

### 配置随机属性
类 RandomValuePropertySource 用于获取的配置随机属性,属性文件可以这么写：
```
my.secret=${random.value}
my.number=${random.int}
my.bignumber=${random.long}
my.uuid=${random.uuid}
my.number.less.than.ten=${random.int(10)}
my.number.in.range=${random.int[1024,65536]}
```