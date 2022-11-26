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

- postProcessBeanFactory：BeanFactory call after call this method（调用时机：当 BeanFactory 创建完之后自动调用此方法）

# InstantiationAwareBeanPostProcessor

> 对象实例化的时候进行 call

- postProcessBeforeInstantiation: 实例化之前 call
- postProcessAfterInstantiation: 实例化之后 call
- postProcessProperties：当属性处理完之后会传入进来

> 最终结果

```text
1. call BNTangFactoryBeanPostProcessor constructor
2. call BeanFactoryPostProcessor of postProcessBeanFactory
3. call BNTangBeanPostProcessor constructor
4. call BNTangInstantiationAwareBeanPostProcessor constructor
5. call InstantiationAwareBeanPostProcessor of postProcessBeforeInstantiation
6. call BNTangBean no parameter constructor start！
7. call InstantiationAwareBeanPostProcessor of postProcessAfterInstantiation
8. call InstantiationAwareBeanPostProcessor of postProcessProperties
9. call BeanNameAware setBeanName BNTangBean
10. call BeanFactoryAware interface setBeanFactory
11. call ApplicationContextAware interface of setApplicationContext
12. call BeanPostProcessor of BeforeInitialization!
13. call myInit method attribute config init method！
14. call InitializingBean interface afterPropertiesSet
15. call BeanPostProcessor of AfterInitialization!
16. call myDestroy method attribute config init method！
17. call DisposableBean interface destroy
```