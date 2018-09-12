export class Materiel{
    public constructor(public id :number,public serialNumber:string,public client:number,public salle:number,public article:number){}
    
    public copyFrom(source : Materiel){
        this.id = source.id;
        this.serialNumber = source.serialNumber;
        this.client=source.client;
        this.salle=source.salle;
        this.article=source.article;
    }

    public toJson() {
        return {
            id: this.id,
            serialNumber: this.serialNumber,
            client:this.client,
            salle:this.salle,
            article:this.article
        };
    }
}