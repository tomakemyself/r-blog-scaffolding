# r-blog-scaffolding

#### 介绍

一个个人博客网站的源码脚手架，[r-blog](http://blog.rubinchu.com)基于此脚手架搭建，希望对有快速搭建个人博客的小伙伴有所帮助   
 **在此特别说明：** 本项目大部分基于dbblog项目抽离，特此感谢dbblog项目作者Bobbi，dbblog站点地址：[dbblog](https://github.com/llldddbbb/dbblog)

#### 软件架构

SpringBoot 2.x 后台基本框架  
Vue 2.x 前端基本框架  
ElementUI：后台管理页面UI库  
IView：前端UI库  
Shiro 鉴权层  
Redis 缓存层  
Swagger 文档  
Mybaits-Plus 好用的mybatis框架  
lombox getter setter插件  
druid 数据库连接池  
jasypt 加密  


#### 安装教程

##### 项目文件夹说明

* 本项目front-end文件夹下为前台和后台的两个门户前端项目（portal为前台，admin为后台） 
* 本项目back-end文件夹下为后端api项目架子源码，作者基于此架子开发的时候，建议拆成三个项目

##### 安装说明

 **_提示：_** 运行此项目小伙伴可以将项目导入工程之后，查找工程中的所有TODO，并按照提示修改，会大大的减少小伙伴的架子修改时间，所有的TODO都是我特别标记出来要修改的配置信息，以减少大家的开发时间
*  **运行此项目需要的环境：** JDK、MySQL、Redis、NodeJS，请调试前自行安装   
*  **关于修改后端api项目：** 将back-end文件夹中的源码粘贴到小伙伴自己的项目中，在IDE中查找所有的TODO并按照提示修改配置。在项目中有支持项目的数据库结构sql脚本，在项目环境搭建好之后需要提前准备好数据库和Redis环境，方能在本地愉快的玩耍 
*  **关于修改前台前端项目：** 将front-end/portal文件夹下面的源码粘贴到小伙伴自己的项目中，在IDE中查找所有的TODO并按照提示修改配置。在项目运行之前，需要小伙伴首先搭建NodeJS的运行环境，建议不要装的版本过低，版本的下限参看package.json中的engines配置项
*  **关于修改后台前端项目：** 将front-end/admin文件夹下面的源码粘贴到小伙伴自己的项目中，在IDE中查找所有的TODO并按照提示修改配置。在项目运行之前，需要小伙伴首先搭建NodeJS的运行环境，建议不要装的版本过低，版本的下限参看package.json中的engines配置项

#### 本地调试

1.   **后端api项目：** 小伙伴按照上面的安装说明配置好环境之后，就像启动平常的SpringBoot项目一样启动此项目即可
2.  **前台前端项目：** 小伙伴按照上面的安装说明配置好环境之后，执行cnpm install(需要提前安装cnpm，[安装教程Windows](https://blog.csdn.net/weixin_38806135/article/details/88305885) [安装教程Mac](https://blog.csdn.net/cency_chen/article/details/87927107))。安装完之后执行npm start，等待项目起来，访问localhost:8081即可
3.  **后台前端项目：** 小伙伴按照上面的安装说明配置好环境之后，执行cnpm install(需要提前安装cnpm，[安装教程Windows](https://blog.csdn.net/weixin_38806135/article/details/88305885) [安装教程Mac](https://blog.csdn.net/cency_chen/article/details/87927107))。安装完之后执行npm start，等待项目起来，访问localhost:8080即可。初始账户密码为：admin/123456

#### 线上部署说明

1.   **部署后端api项目：** 具体的部署细节就不说了（小伙伴可以自己喜欢的方式部署，比如jenkins部署或者手动传包部署），这里我已经在项目的run文件夹下面写好了项目的启动脚本，小伙伴们可以修改一下脚本里面的jar包路径（如果是war包部署请忽略本条部署说明），运行脚本之后，会生成一个pid.txt文件和一个api.log的日志文件，小伙伴可以查看运行的进程号和项目输出日志
2.   **部署前台前端项目：** 建议使用npm build命令，将编译好的dist文件夹直接扔到tomcat的webapps里面来部署（[tomcat端口配置](https://blog.csdn.net/mixika99/article/details/77651689)）
3.  **部署后台前端项目：** 建议使用npm build命令，将编译好的dist文件夹直接扔到tomcat的webapps里面来部署（[tomcat端口配置](https://blog.csdn.net/mixika99/article/details/77651689)）

#### Q&A

1.  为什么使用undertow作为web服务器？他有什么需要注意的点？  
答：由于本人了解的也不是很深入，但是Tomcat作为老牌的web服务器，大家都熟悉的一点是：他太重了。undertow比较轻量级。在使用undertow的过程中，我曾遇到的问题是：在服务器上上传了文件之后，上传的文件是没有读写权限的，导致上传的图片在资源服务器配置的正确的情况下显示不出来，暂时的解决方案是在代码层手动上传之后赋予读写权限。有不对的地方欢迎小伙伴提出来，我们共同讨论。
2.  nginx配置的过程中需要注意什么？  
答：我在nginx配置过程中曾经傻缺一样的加上了防止跨域的请求头，结果我们的api后端项目已经处理了跨域问题，导致浏览器报错重复的请求头错误。所以提示小伙伴们在我们的后端项目已经处理了跨域的时候，nginx配置就别配置跨域的东西了。

#### 版本介绍

此版本实现了博客的功能，作为日常使用没有什么问题   
下版本需要优化的点：
* 优化查询缓存的细节，此版本只是粗略的删除了缓存查询以保证点赞数和查看数一致
* 集成elasticsearch、集成Redis、集成RocketMQ改成自定义标签自动装配以提升项目的查询性能
