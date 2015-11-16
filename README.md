##ELF
* what is elf?

```
	名字来源于DOTA的小精灵
	希望有小精灵那样灵活
```
## 工程介绍
```
项目分为 接口/实现/部署 三个层
在每个层里面又有不同模块, 各个模块直接低耦合, 易插拔.
部署层不关心实现, 依赖接口, 最大程度降低耦合.
部署层可以轻易将重的模块单独输出部署.
```

- elf文件夹，根目录
    + elf-core 根工程，提供最基础的依赖管理
        * elf-user 用户模块, 用户注册/登陆以及账户管理
        * elf-session 会话管理模块, 用户登录后会话管理, 热数据缓存
    + elf-impl 实现的根工程，提供实现的依赖管理
        * elf-user-impl 用户服务的实现
		* elf-session-impl 会话管理模块的实现
	+ elf-common elf系统的一些常用类，包含工具类，异常定义等
    + elf-dist 此文件夹不是工程，是将所有编译出需要发布的单独部署的模块，统一的存放和管理
        * elf-servers 项目生成出来的各个服务集群
        * elf-clients elf所产出的接口依赖, 被服务调用方依赖的接口jar包
        * elf-webapis 所有的对外web服务放在一起，配置统一的web项目pom
            * elf-svr 目前基础服务只输出一个对外的web项目
            
## GET START
* maven clean install elf-core工程后，获得elf-svr.war包(elf-dist/elf-webapis/elf-svr/target/elf-svr.war).

* 由于部分测试用例依赖数据库环境，所以可以使用下面命令：(pwd=elf-core目录)

```
mvn clean install -Dmaven.test.skip=true
```
* 将elf-svr.war丢到tomcat/webapp下运行.
            
