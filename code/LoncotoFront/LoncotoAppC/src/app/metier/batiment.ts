export class Batiment{
    public constructor(public id:number,public nom:string,public site:number){}

    public copyFrom(source : Batiment){
        this.id = source.id;
        this.nom = source.nom;
        this.site = source.site;
    }

    public toJson() {
        return {
            id:this.id,
            nom:this.nom,
            site:this.site
        };
    }
    

}