export class Materiel{
    public constructor(public id :number,public serialNumber:number,public clientId:number,public salleId:number,public articleId:number){}
    public copyFrom(source : Materiel){
        this.id = source.id;
        this.serialNumber = source.serialNumber;
        this.clientId=source.clientId;
        this.salleId=source.salleId;
        this.articleId=source.articleId;
    }
}