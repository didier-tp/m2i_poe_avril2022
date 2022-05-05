Tp jeudi:
_________
dans src/app/common/service
générer un nouveau service login (LoginService)
au sein de cette classe il faudra ajouter:
  - constructeur qui injecte HttpClient 
  - postLogin$(login ) : Observable<LoginResponse)
  ....
dans src/app/common/data
coder une nouvelle classe LoginResponse

URL à appeler en mode post:
http://localhost:8282/login-api/public/auth

exemple de données correctes :
{ "username" : "admin1" , "password" : "pwdadmin1" , "roles" : "admin" }

exemple de bonne réponse:
{
    "username": "admin1",
    "status": true,
    "message": "successful login",
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWJqZWN0IjoiYWRtaW4xIiwicm9sZXMiOiJhZG1pbiIsImlhdCI6MTY1MTc1MzA3MCwiZXhwIjoxNjUxNzYwMjcwLCJpc3MiOiJodHRwOi8vd3d3Lm15Y29tcGFueSJ9.NznbDXhKCVsEixibigJLfUzjT-_AnjiSXO0X7xHhO80",
    "roles": "admin"
}
exemple de mauvaise réponse:
{
    "username": "admin1",
    "status": false,
    "message": "login failed (wrong password)",
    "token": null,
    "roles": null
}

dans la methode onLogin() de LoginComponent
appeler la methode  postLogin$ et
via un .subscribe(...)
construire un message "successful login" ou autre




TP mercredi:
dans src/app/common/service
générer un nouveau service session (SessionService)
au sein de cette classe il faudra mémoriser:
  - username 
  - connecte:booleen
  ....

injecter SessionService dans LoginComponent
et améliorer le code de onLogin()
...

injecter SessionService dans FooterComponent
et afficher dans le .html du Footer
un message de type "utilisateur connecté: toto"

....

=======================
npm install --save-dev eslint @typescript-eslint/parser @typescript-eslint/eslint-plugin
et
https://marketplace.visualstudio.com/items?itemName=dbaeumer.vscode-eslint
et
npx eslint --init
