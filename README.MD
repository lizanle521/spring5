# dxy框架redis spring boot starter

提供redis功能的spring boot快速启动jar，开箱即用！

功能点：
- RedisUtils Redis缓存工具类
    - 该工具类主要包含常用的缓存操作,事物和pipleline相关建议直接用RedisUtils.execute()
- RedisLockUtils Redis分布式锁工具类
    - 采用lua脚本加锁和解锁
    - 支持可重入锁
    - 解锁增加是否当前线程加锁验证

## 如何开始
1.引入dxy-framework-redis-starter包

```xml
<dependency>
    <groupId>com.lzl.framework</groupId>
    <artifactId>dxy-framework-redis-starter</artifactId>
    <version>x.y.z</version>
</dependency>
```

2.配置方式

配置方式提供3中模式，该配置dxy.redis.enabled=true必须要开启状态。

- Redis单节点模式
```yaml
com:  
  dxy:
    redis:
      enabled: true #是否开启-必填
      host: localhost #节点地址-必填
      port: 6379 #节点端口-必填
      ssl: false #是否开启ssl链接，默认false
      password: ****** #密码，默认无 
      database: 0 #数据库索引，默认是0
      timeout: 1000 #连接超时时间，模式1000ms
      pool:
        max-active: 10 #连接池最大连接数，默认是10（使用负值表示没有限制）
        max-wait: -1 #连接池最大阻塞等待时间,默认-1（使用负值表示没有限制）
        max-idle: 3 #连接池中的最大空闲连接，默认是3
        min-idle: 0 #连接池中的最小空闲连接，默认是0
```

- Redis哨兵模式
```yaml
com:  
  dxy:
    redis:
      enabled: true #是否开启-必填
      ssl: false #是否开启ssl链接，默认false
      password: ****** #密码，默认无
      database: 0 #数据库索引，默认是0
      timeout: 1000 #连接超时时间，模式1000ms
      pool:
        max-active: 10 #连接池最大连接数，默认是10（使用负值表示没有限制）
        max-wait: -1 #连接池最大阻塞等待时间,默认-1（使用负值表示没有限制）
        max-idle: 3 #连接池中的最大空闲连接，默认是3
        min-idle: 0 #连接池中的最小空闲连接，默认是0
      sentinel:
        master: myster #哨兵master名称
        nodes: 192.168.1.1:6379,192.168.2.1:6379 #哨兵节点
```

- Redis集群模式
```yaml
com:  
  dxy:
    redis:
      enabled: true #是否开启-必填
      ssl: false #是否开启ssl链接，默认false
      password: ****** #密码，默认无
      database: 0 #数据库索引，默认是0
      timeout: 1000 #连接超时时间，模式1000ms
      pool:
        max-active: 10 #连接池最大连接数，默认是10（使用负值表示没有限制）
        max-wait: -1 #连接池最大阻塞等待时间,默认-1（使用负值表示没有限制）
        max-idle: 3 #连接池中的最大空闲连接，默认是3
        min-idle: 0 #连接池中的最小空闲连接，默认是0
      cluster:
        nodes: 
          - 192.168.1.1:6379 #集群节点
          - 192.168.2.1:6379 #集群节点
        maxRedirects: 3 #重定向最大数
```

3.使用方法
```
  #缓存操作类,更多方法见RedisUtils.java
  RedisUtils.put("a","a");
  RedisUtils.get("a",String.class);

  #Redis分布式锁工具类,res为true表示成功获取锁
  boolean res = RedisLockUtils.lock("lockTest");//默认锁时间为60s
  OR
  boolean res = RedisLockUtils.lock("lockTest1",30);//单位为秒
  try{
    //do something....
  }finally{
    //最好每次手动释放锁
    RedisLockUtils.unlock("lockTest");
  }
  
  或者可以直接使用RedisTemplate，直接注入即可
  @Autowired
  private RedisTemplate redisTemplate;
```