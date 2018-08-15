export class Sous_Famille{

    public constructor(public id : number,public nom : string,public familleId : number){}

    public copyFrom(source : Sous_Famille){
        this.id = source.id;
        this.nom = source.nom;
        this.familleId = source.familleId;
    }
}