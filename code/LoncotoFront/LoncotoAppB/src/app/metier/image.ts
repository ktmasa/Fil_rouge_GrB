export class Image{
    public constructor(public id:number,public url:string,public interventionId:number){}
    public copyFrom(soure : Image){
        this.id=soure.id;
        this.url =soure.url;
        this.interventionId=soure.interventionId;
    }
}