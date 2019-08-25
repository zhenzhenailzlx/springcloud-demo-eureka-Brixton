示例eureka服务器（例如，使用spring-cloud-starter-eureka-server设置类路径）：
1.pom文件添加依赖
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-eureka-server</artifactId>
</dependency>

2.使用@EnableEurekaServer注解
@SpringBootApplication
@EnableEurekaServer
public class Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }

}

3.访问
http://localhost:8761

4.注册地址
http://localhost:8761/eureka/


5.新建git项目
git init
git add 。
git commit -m "init project"
git remote add origin https://github.com/zhenzhenailzlx/springcloud-demo-eureka-Brixton.git
git push -u origin master