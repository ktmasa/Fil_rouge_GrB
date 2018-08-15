export class Famille{

    public constructor(public id : number, public nom : string){}

    public copyFrom(source : Famille){
        this.id = source.id;
        this.nom = source.nom;
    }
}