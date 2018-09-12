export class Salle{
    public constructor(public id:number,public nom:string,public etage:number){}

    public copyFrom(source : Salle){
        this.id = source.id;
        this.nom = source.nom;
        this.etage = source.etage;
    }

    public toJson() {
        return {
            id: this.id,
            nom:this.nom,
            etage:this.etage
        };
    }
}