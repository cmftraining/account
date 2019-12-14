# 账户管理应用

## 提示：
* 创建程序
	* 使用 Spring Boot Starter 创建项目
		* https://start.spring.io 
		* Starter：Web、JPA、JDBC、H2）
	* 在pom.xml中增加设置
		* assertJ
		* swagger2/swagger-ui
	* 编辑 application.yml(见程序)
	* Enable Swagger UI
	     
		```
		@EnableSwagger2
		@SpringBootApplication
		public class CustomerApplication {
			public static void main(String[] args) {
				SpringApplication.run(CustomerApplication.class, args);
			}	
		}
		```
	* 编写程序
	* 运行
		* 方法1:
		
			```
			mvn spring-boot:run
			```
			
		* 方法2：
		
			```
			mvn clean package
			java -jar target/gs-rest-service-0.1.0.jar
			```
		* 方法3： run CustomerApplication in IDE

		* h2 console: http://localhost:8080/h2 
			* JDBC URL : jdbc:h2:./h2-dev
			* id: sa
			* password: 空白
			
		* 服务器启动后在浏览器中运行: http://localhost:8080/swagger-ui.html

* 组件测试
	* 增加专门用于组件测试案例的目录integrationtest
	* 组件测试案例命名：XxxIT.java
	* 通过Run Configuration，使用Pattern方式配置2个Run(All in directory总是运行所有测试?)：
		* Unit Test （Pattern：.*Test）
		* Integration Test （.*IT）
	* pom.xml配置：
		* 通过 build-helper-maven-plugin 将 integrationtest 中的测试源码和资源加入Maven
		* 通过 maven-surefire-plugin 配置是否可忽略单元测试（默认不忽略）
		* 通过 maven-failsafe-plugin 配置组件测试
	* 运行组件测试
		* 运行单元测试和组件测试：``` mvn verify ```
		* 只运行组件测试：```mvn verify -DskipUnitTest=true ```
		
