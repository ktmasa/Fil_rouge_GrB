import{ Site } from "./Site"

export class Client{
    public constructor(public id:number,public entreprise:string,public telephone:number,public mail:string,public siret:string, public sites?:Array<Site>,public clients?: Array<Client>){}

    public copyFrom(source : Client){
        this.id = source.id;
        this.entreprise = source.entreprise;
        this.telephone = source.telephone;
        this.mail = source.mail;
        this.siret = source.siret; 
        this.sites = source.sites;   
    }

    public toJson() {
        return {
            id: this.id,
            entreprise:this.entreprise,
            telephone:this.telephone,
            mail:this.mail,
            siret:this.siret
        };
    }
}