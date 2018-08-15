export class Etage{
    public constructor(public id : number, public numero : number,public batimentId : number){}
    
    public coptFrom(source : Etage){
        this.id = source.id;
        this.numero = source.numero;
        this.batimentId = source.batimentId;
    }


}