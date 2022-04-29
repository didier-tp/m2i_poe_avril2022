"use strict";
//à faire en Tp : coder le début d'une classe Personne
Object.defineProperty(exports, "__esModule", { value: true });
exports.Personne = void 0;
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