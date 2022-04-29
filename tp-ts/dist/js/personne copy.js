"use strict";
//à faire en Tp : coder le début d'une classe Personne
class Personne {
    constructor(numero = 0, prenom = "?", nom = "?", age = 0) {
        this._age = 0;
        this.numero = numero;
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
    }
    get age() {
        return this._age;
    }
    set age(newAge) {
        if (newAge >= 0)
            this._age = newAge;
        else
            throw "age negatif invalide";
    }
    incrementerAge() {
        this._age++;
    }
}
try {
    let p1;
    p1 = new Personne(1, "jean", "Bon", -33);
    p1.incrementerAge(); //nouvel age 34
    console.log(`prenom de p1=${p1.prenom}`);
    console.log(JSON.stringify(p1));
}
catch (ex) {
    console.log("exception:" + ex);
}
let p2;
p2 = new Personne();
try {
    p2.age = -44;
}
catch (ex) {
    console.log("exception:" + ex);
}
p2.age = 44;
p2.prenom = "axelle";
p2.nom = "Aire";
p2.incrementerAge(); //nouvel age 45
console.log(JSON.stringify(p2));
//# sourceMappingURL=personne%20copy.js.map