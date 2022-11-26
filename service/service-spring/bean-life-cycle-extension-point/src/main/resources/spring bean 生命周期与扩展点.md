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

# Bean 扩展点

在所有 Bean 初始之前跟之后执行，也就是 Bean 的前置和后置处理器, implements BeanPostProcessor interface Override postProcessBeforeInitialization、postProcessAfterInitialization method

- postProcessBeforeInitialization：前置处理器
- postProcessAfterInitialization：后置处理器

# BeanFactoryPostProcessor 后置处理器

implements BeanFactoryPostProcessor interfaces Override postProcessBeanFactory method

- postProcessBeanFactory

# InstantiationAwareBeanPostProcessor