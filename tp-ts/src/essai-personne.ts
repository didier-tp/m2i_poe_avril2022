import { additionner, Personne } from "./personne";

let somme = additionner(5,6);
console.log("somme="+somme);
//somme = add(3,4); //impossible d'importer et appeler add()
                    //car la fonction add() n'a pas été exportée .
//console.log("somme="+somme);

try{
    let p1 : Personne ;
    p1 = new Personne(1,"jean","Bon",33);
    p1.incrementerAge(); //nouvel age 34
    console.log(`prenom de p1=${p1.prenom}`)
    console.log(JSON.stringify(p1));
}catch(ex){
    console.log("exception:" + ex);
}

let p2 : Personne ;
p2 = new Personne();
try{
    p2.age=-44;
}catch(ex){
    console.log("exception:" + ex);
}
p2.age=44;
p2.prenom="axelle"; p2.nom="Aire"
p2.incrementerAge(); //nouvel age 45
console.log(JSON.stringify(p2));