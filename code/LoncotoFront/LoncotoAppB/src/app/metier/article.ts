export class Article{
    public constructor(public id:number,public nom:string,public sousFamilleId:number,public description:string,public ficheTechnique:string){}

    public copyFrom(source : Article){
        this.id = source.id;
        this.nom = source.nom;
        this.sousFamilleId = source.sousFamilleId;
        this.description = source.description;
        this.ficheTechnique = source.ficheTechnique;
    }
}