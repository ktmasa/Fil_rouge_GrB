export class Salle{
    public constructor(public id:number,public nom:string,public etageId:number){}

    public copyFrom(source : Salle){
        this.id = source.id;
        this.nom = source.nom;
        this.etageId = source.etageId;
    }
}