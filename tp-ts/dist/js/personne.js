"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Personne = exports.additionner = void 0;
function add(a, b) {
    return a + b;
}
function additionner(a, b) {
    console.log(`additionner appelé avec a=${a} et b=${b}`);
    return add(a, b);
}
exports.additionner = additionner;
class Personne {
    constructor(numero = 0, prenom = "?", nom = "?", _age = 0) {
        this.numero = numero;
        this.prenom = prenom;
        this.nom = nom;
        this._age = _age;
        this.age = _age;
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
exports.Personne = Personne;
//# sourceMappingURL=personne.js.map