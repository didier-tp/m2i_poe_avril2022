//à faire en Tp : coder le début d'une classe Personne

class Personne {
   numero : number;
   prenom : string;
   nom: string;
   age : number;

   constructor(numero : number = 0, prenom : string ="?",  nom: string = "?", age : number=0){
       this.numero = numero; this.prenom = prenom; this.nom= nom; this.age=age;
   }

    incrementerAge() :void {
        this.age++;
    } 
}

let p1 : Personne ;
p1 = new Personne(1,"jean","Bon",33);
p1.incrementerAge(); //nouvel age 34
console.log(`prenom de p1=${p1.prenom}`)
console.log(JSON.stringify(p1));

let p2 : Personne ;
p2 = new Personne();
p2.age=44;
p2.prenom="axelle"; p2.nom="Aire"
p2.incrementerAge(); //nouvel age 45
console.log(JSON.stringify(p2));