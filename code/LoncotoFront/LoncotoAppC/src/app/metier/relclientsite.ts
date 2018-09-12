export class RelClientSite{

    public constructor(public clientId : number,public siteId:number){}

    public copyFrom(source : RelClientSite){
        this.clientId = source.clientId;
        this.siteId =this.siteId;
    }
}