# spring cloud kubernetes demo
## 1. 项目介绍
一个集成了[spirng-cloud-kubernetes](https://docs.spring.io/spring-cloud-kubernetes/docs/current/reference/html/#why-do-you-need-spring-cloud-kubernetes)的学习项目，包含了spring cloud kubernetes的各种组件的使用方式，以及一些常用的配置方式。
其中使用了google cloud code插件，通过编写skaffold.yaml、Dockerfile、k8s.yaml实现在本地一键启动debug模式。

## 2. 项目特性
> 1. 基于kubernetes的服务发现
> 2. 基于kubernetes的配置中心

## 2. 环境准备
> 1. kubernetes集群
> 2. JDK17
> 3. Maven3.x
> 4. VS Code
> 5. VS Code Google Cloud Code插件（用于本地一键启动DEBUG）

## 3. 启动项目
1. 分配权限
```` bash
kubectl apply -f role.yaml
````
2. 编译工程
```` bash
mvn clean package
````

3. debug模式启动kubernetes-provider
![启动provider](./docs/imgs/debug-start.png)

4. debug模式启动kubernetes-consumer
![启动consumer](./docs/imgs/debug-start.png)

5. 访问consumer接口
````bash
curl http://127.0.0.1:20000/services/k8s-provider
````
如果返回了provider的信息，则表示启动成功。