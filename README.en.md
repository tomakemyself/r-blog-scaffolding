# r-blog-scaffolding

#### Introduction

Source scaffolding for a personal blog site,[r-blog](http://blog.rubinchu.com)based on this scaffolding construction, I hope it will be helpful to friends who have a personal blog quickly.  
 **Special note here:** this project is mostly based on the dbblog project extraction. Thanks to the dbblog project author Bobbi, the dbblog site address:[dbblog](https://github.com/llldddbbb/dbblog)

#### Software architecture

SpringBoot 2.x  
Vue 2.x  
ElementUI 
IView 
Shiro   
Redis   
Swagger   
Mybaits-Plus   
lombox   
druid   
jasypt   


#### Installation tutorial

##### Project folder description

* The front-end folder of this project is the front-end and back-end two portal front-end projects (portal is the foreground and admin is the background) 
* The back-end folder of this project is the back-end api project shelf source code. When the author develops based on this shelf, it is recommended to split into three projects

##### Installation notes

 **_Prompt:_** after running this project, the partners can import the project into the project, find all TODOs in the project, and modify them according to the prompts, which will greatly reduce the shelf modification time of the partners. All TODOs are the configuration information that I specially marked out for modification. To reduce your development time
*  **Environment required to run this project:** JDK、MySQL、Redis、NodeJS.Please install before commissioning  
*  **About modifying the backend api project:** paste the source code in the back-end folder into your own project. Find all TODOs in the IDE and modify the configuration as prompted. In the project, there is a database structure SQL script that supports the project. After the project environment is set up, the database and Redis environment need to be prepared in advance to be able to play happily in the local 
*  **About modifying the front-end project:** paste the source code under the front-end / portal folder into the partner's own project, find all TODOs in the IDE and modify the configuration as prompted. Before the project runs, you need to build a NodeJS operating environment first. It is recommended not to install a version that is too low. For the lower limit of the version, see the engines configuration item in package.json
*  **About modifying the background front-end project:** paste the source code under the front-end / admin folder into the partner's own project, find all TODOs in the IDE and modify the configuration as prompted. Before the project runs, you need to build a NodeJS operating environment first. It is recommended not to install a version that is too low. For the lower limit of the version, see the engines configuration item in package.json

#### Local debugging

1.  **Back-end api project:** after the partners have configured the environment according to the installation instructions above, they can start this project just like the usual SpringBoot project
2.  **Front-end projects:** after the friends have configured the environment according to the installation instructions above, execute cnpm install(cnpm needs to be installed in advance,[Installation tutorial for Windows](https://blog.csdn.net/weixin_38806135/article/details/88305885) [Installation tutorial for Mac](https://blog.csdn.net/cency_chen/article/details/87927107)).After the installation, execute npm start, wait for the project to come up, visit localhost:8081
3.  **Backend front-end project:** after the friends have configured the environment according to the installation instructions above, execute cnpm install(cnpm needs to be installed in advance,[Installation tutorial for Windows](https://blog.csdn.net/weixin_38806135/article/details/88305885) [Installation tutorial for Mac](https://blog.csdn.net/cency_chen/article/details/87927107)).After the installation, execute npm start, wait for the project to come up, visit localhost:8080.The initial account password is:admin/123456

#### Online deployment instructions

1.  **Deploy backend api projects:** the specific deployment details will not be mentioned (the small partners can deploy in their own way, such as jenkins deployment or manual package deployment). Here I have written the project startup script under the project's run folder. The small partners can Modify the jar package path in the script (if it is a war package deployment, please ignore this deployment instruction). After running the script, a pid.txt file and an api.log log file will be generated. You can check the running process ID and Project output log
2.  **Deploy front-end front-end projects:** it is recommended to use the npm build command to throw the compiled dist folder directly into the tomcat webapps for deployment（[tomcat port configuration](https://blog.csdn.net/mixika99/article/details/77651689)）
3.  **Deploy background front-end projects:** it is recommended to use the npm build command to throw the compiled dist folder directly into the tomcat webapps for deployment（[tomcat port configuration](https://blog.csdn.net/mixika99/article/details/77651689)）

#### Q&A

1.  Why use undertow as a web server? Is there anything he needs to pay attention to? 
Answer: Since I don't know much about it, but Tomcat as an old-fashioned web server, everyone is familiar with: he is too heavy. Undertow is relatively lightweight. In the process of using undertow, I have encountered the following problem: After uploading the file on the server, the uploaded file does not have read and write permissions, resulting in the uploaded picture not being displayed under the correct configuration of the resource server. The temporary solution is to grant read and write permissions after the code layer is manually uploaded. Anything wrong is welcome to come up with small partners, we discuss together.
2.  What should I pay attention to during nginx configuration?
Answer: I have stupidly added a request header to prevent cross-domains during the nginx configuration process. As a result, our api back-end project has dealt with cross-domain issues, causing the browser to report duplicate request header errors. So remind our friends that when our back-end project has dealt with cross-domain, don't configure cross-domain stuff in nginx configuration.

#### Version introduction

This version implements the functionality of the blog as no problem for daily use
The following points need to be optimized:
* Optimize the details of the query cache. This version only roughly deletes the cache query to ensure that the number of likes and views are consistent
* Integrated elasticsearch, integrated Redis, integrated RocketMQ into custom label auto-assembly to improve project query performance
