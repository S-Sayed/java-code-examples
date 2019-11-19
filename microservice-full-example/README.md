# To Run (you have to have angular and maven installed on your machine)

Go to the path of your workspace that contains this project, then

# 1- Start eureka server 
    - run the below command 
        mvn spring-boot:run -Dserver.port=8761
    
    - after starting, you can check if eureka server is up and ruuning 
        http://localhost:8761/
    
# 2- Start gateway/proxy server
    - run the below command 
        mvn spring-boot:run -Dserver.port=8762
    
    - after starting, you can check if the api gateway is registered in eureka server or not
        http://localhost:8761/
    
# 3- Start employee service
    - run the below command 
        mvn spring-boot:run -Dserver.port=8081
    
    - you can run any number of instances of this service (for example, run this service 3 times on different port to check the load balancing)
        mvn spring-boot:run -Dserver.port=8081
        mvn spring-boot:run -Dserver.port=8082
        mvn spring-boot:run -Dserver.port=8083
    
    - after starting, you can check if the employee-service is registered in eureka server or not
        http://localhost:8761/
    
    - hit the below URL to ensure that the service is working fine 
        - using api gateway URL
            http://localhost:8762/api/employee-service/employees 
            
        - using the microservice service URL 
            http://localhost:8081/employees
    
# 4- Start angular employee-ui project  
    - run the below command 
        ng serve -o
    
    - then the angular will open your porject in the browser using http://localhost:4200/ 
