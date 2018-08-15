
export class Site{
    public constructor(public id:number,public nom:string,public adresse:string,public latitude:number,public longitude:number){}

    public copyFrom(source : Site){
        this.id = source.id;
        this.nom = source.nom;
        this.adresse = source.adresse;
        this.latitude = source.latitude;
        this.longitude = source.longitude;
    }
}