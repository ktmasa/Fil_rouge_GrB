export class Etage{
    public constructor(public id : number, public numero : number,public batiment : number){}
    
    public coptFrom(source : Etage){
        this.id = source.id;
        this.numero = source.numero;
        this.batiment = source.batiment;
    }

    public toJson() {
        return {
            id: this.id,
            numero:this.numero,
            batiment:this.batiment
        };
    }


}