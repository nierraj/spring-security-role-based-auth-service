# spring-security-role-based-auth-service
Implement Role base authorization

## Controlling Services
### API-endpoints
```
POST - http://localhost:8080/users/create @ResponseBody(#ref User)
```
### User.json
```
{
    "username" : "Neeraj",
    "password" : "password",
    "active" : true
}
```
```
## DB - MySQL - Configurations are present in application.properties

## Flow:
Create the User with "/users/create" and update the any 1 user as ADMIN:
update user set roles = 'ROLE_ADMIN' where id = 1;

Create few Accounts with "/account/create". Accounts will be created in Pending Status.
It can be approved by the User which has "ROLE_ADMIN" and "ROLE_MODERATOR".
```

```
I have added Swagger 3: http://localhost:8080/swagger-ui/
You can use Swagger UI to get the API details.
```
