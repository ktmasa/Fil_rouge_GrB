
export class Site{
    public constructor(public id:number,public nom:string,public adresse:string,public latitude:number,public longitude:number){}

    public copyFrom(source : Site){
        this.id = source.id;
        this.nom = source.nom;
        this.adresse = source.adresse;
        this.latitude = source.latitude;
        this.longitude = source.longitude;
    }

    public toJson() {
        return {
            id: this.id,
            nom:this.nom,
            adresse:this.adresse,
            latitude:this.latitude,
            longitude:this.longitude
        };
    }
}