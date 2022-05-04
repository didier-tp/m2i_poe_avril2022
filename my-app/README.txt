TP
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
