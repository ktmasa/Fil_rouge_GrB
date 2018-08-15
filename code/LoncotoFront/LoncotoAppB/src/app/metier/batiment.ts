export class Batiment{
    public constructor(public id:number,public nom:string,public siteId:number){}

    public copyFrom(source : Batiment){
        this.id = source.id;
        this.nom = source.nom;
        this.siteId = source.siteId;
    }
}