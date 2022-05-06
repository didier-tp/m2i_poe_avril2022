app.use(function(req, res, next) {
  res.header("Access-Control-Allow-Origin", "*");
  res.header("Access-Control-Allow-Methods", "POST, GET, PUT, PATCH, DELETE"); //default: GET, ...
  res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
   if(req.method === 'OPTIONS'){
        res.header('Access-Control-Allow-Methods', 'POST, GET, PUT, PATCH, DELETE'); //to give access to all the methods provided
        return res.status(200).json({});
    }
  next();
});

==========================

NB: les autorisations CORS (coté serveur) ne sont pas toujours nécessaires.
On peut s'en passer avec un serveur intermédiaire (reverse-proxy ou api-gateway).
Ex:  ng serve --proxy-config proxy.conf.json (page 125 environ)