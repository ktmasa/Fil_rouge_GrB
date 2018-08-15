
export class Client{
    public constructor(public id:number,public entreprise:string,public telephone:number,public mail:string,public siret:number){}

    public copyFrom(source : Client){
        this.id = source.id;
        this.entreprise = source.entreprise;
        this.telephone = source.telephone;
        this.mail = source.mail;
        this.siret = source.siret;    
    }
}