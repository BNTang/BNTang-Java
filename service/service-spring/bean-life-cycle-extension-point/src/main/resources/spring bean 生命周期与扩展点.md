> 注意：如下介绍的方法都是 spring 自动 call 的

# 初始化与销毁

- @PostConstruct：初始化
- @PreDestroy：销毁

# Bean 初始化之后与销毁之后执行的方法

> 以下两个都是接口需要 implement

- InitializingBean：初始化之后
- DisposableBean：销毁之后

# BeanNameWare 接口

- BeanNameAware：setBeanName 的时机 call

# BeanFactoryAware 与 ApplicationContextAware

- BeanFactoryAware: setBeanFactory
- ApplicationContextAware: setApplicationContext