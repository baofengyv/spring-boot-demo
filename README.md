# Spring Boot Demo

大家好，我把我日常使用中用到的一些情况整理到这里，做个备忘也供大家参考。

# JDK

使用JDK 1.8

# 权限控制

用户角色记录到session中

用户可以有多个角色

需要权限控制时，使用自定义的@AuthRole注解配置在controller中

# 事务

使用 @Transactional 注解，添加到service中的方法上

# 统一的异常处理

在service中随时抛出自定义异常，被捕获后会封装成统一的msg返回

# 使用Mybatis 和 Mybatis generator


# 使用 http 代理服务器 
nohup java -Dhttps.proxySet=true -Dhttp.keepAlive=false -Dhttps.proxyHost=1.1.1.1 -Dhttps.proxyPort=3128 -jar xrdb-0.jar &


# @RequestMapping
使用@RequestMapping注解表示接收所有方法 GET POST PUT ...

# 返回对象json格式时，跳过null属性
参见 Msg.java