"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const personne_1 = require("./personne");
try {
    let p1;
    p1 = new personne_1.Personne(1, "jean", "Bon", 33);
    p1.incrementerAge(); //nouvel age 34
    console.log(`prenom de p1=${p1.prenom}`);
    console.log(JSON.stringify(p1));
}
catch (ex) {
    console.log("exception:" + ex);
}
let p2;
p2 = new personne_1.Personne();
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
//# sourceMappingURL=essai-personne.js.map