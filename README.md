# spring-security-role-based-auth-service
Implement Role base authorization

## Controlling Services
### API-endpoints
```
POST - http://http://localhost:8080/users/create @ResponseBody(#ref User)
```
### #Ref - User.json
```
{
    "username" : "Neeraj",
    "password" : "password",
    "active" : true
}

```