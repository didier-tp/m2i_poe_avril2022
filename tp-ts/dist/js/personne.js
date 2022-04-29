"use strict";
//à faire en Tp : coder le début d'une classe Personne
class Personne {
    constructor(numero = 0, prenom = "?", nom = "?", age = 0) {
        this.numero = numero;
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
    }
    incrementerAge() {
        this.age++;
    }
}
let p1;
p1 = new Personne(1, "jean", "Bon", 33);
p1.incrementerAge(); //nouvel age 34
console.log(`prenom de p1=${p1.prenom}`);
console.log(JSON.stringify(p1));
let p2;
p2 = new Personne();
p2.age = 44;
p2.prenom = "axelle";
p2.nom = "Aire";
p2.incrementerAge(); //nouvel age 45
console.log(JSON.stringify(p2));
//# sourceMappingURL=personne.js.map