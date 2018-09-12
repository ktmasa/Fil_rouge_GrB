export class Sous_Famille{

    public constructor(public id : number,public nom : string,public famille : number){}

    public copyFrom(source : Sous_Famille){
        this.id = source.id;
        this.nom = source.nom;
        this.famille = source.famille;
    }

    public toJson() {
        return {
            id: this.id,
            nom:this.nom,
            famille:this.famille
        };
    }
}