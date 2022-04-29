let a :number;
a=6;
console.log("a="+a);

var tableau : number[] = [];
tableau.push(20);
tableau.push(30);
tableau.push(40);

//en exo:
//boucle for pour calculer la moyenne
let somme = 0;
for(let val of tableau){
    somme +=val;
}

let moyenne = somme / tableau.length;

//+ affichage avec quote inverses:
console.log(`moyenne =${moyenne}`);