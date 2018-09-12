export class Article{
    public constructor(public id:number,public nom:string,public sousFamille:number,public description:string,public ficheTechnique:string){}

    public copyFrom(source : Article){
        this.id = source.id;
        this.nom = source.nom;
        this.sousFamille = source.sousFamille;
        this.description = source.description;
        this.ficheTechnique = source.ficheTechnique;
    }
    public toJson() {
        return {
            id:this.id,
            nom:this.nom,
            sousFamille:this.sousFamille,
            description:this.description,
            ficheTechnique:this.ficheTechnique
        };
    }
}