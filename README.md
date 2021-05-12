# spring-security-role-based-auth-service
Implement Role base authorization

## Controlling Services
### API-endpoints
```
POST - http://localhost:8080/users/create @ResponseBody(#ref User)
```
### #Ref - User.json
```
{
    "username" : "Neeraj",
    "password" : "password",
    "active" : true
}

```
# DB - MySQL - Configurations are present in application.properties
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url = jdbc:mysql://localhost:3306/groupmanager
spring.datasource.username = root
spring.datasource.password = AppUsr123
spring.jpa.show-sql = true
spring.jpa.hibernate.ddl-auto = update
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect


# Flow:
Create the User with "/users/create" and update the any 1 user as ADMIN:
update user set roles = 'ROLE_ADMIN' where id = 1;

Create few Accounts with "/account/create". Accounts will be created in Pending Status.
It can be approved by the User which has "ROLE_ADMIN" and "ROLE_MODERATOR".

