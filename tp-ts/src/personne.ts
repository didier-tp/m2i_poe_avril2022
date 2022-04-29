function add(a:number,b:number):number{
    return a+b;
}

export function additionner(a:number,b:number):number{
    console.log(`additionner appelé avec a=${a} et b=${b}`);
    return add(a,b);
}

export class Personne {

   public get age(){
       return this._age;
   }

   public set age(newAge : number){
       if(newAge>=0)  this._age = newAge;
       else throw "age negatif invalide";
   }

   constructor(public numero : number = 0,
               public prenom : string ="?",
               public nom: string = "?", 
               private _age : number=0){
        this.age=_age;
   }

    incrementerAge() :void {
        this._age++;
    } 
}

