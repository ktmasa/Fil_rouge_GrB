
export class Intervenant{
    public constructor(public id:number,public nom:string,public prenom:string,public telephone:number,public mail:string,public specialite:number,public cvId:number){}

    public copyFrom(source : Intervenant){
        this.id = source.id;
        this.nom = source.nom;
        this.prenom = source.prenom;
        this.telephone = source.telephone;
        this.mail = source.mail;
        //La specialite correspond à l'ID de la table specialite = 1 intervenant peut avoir plusieur spe et une spe peut etre attribuer a plusieurs employeur
        //Une spe est une specialite au niveau sous_famille/famille à definir!
        this.specialite = source.specialite;
        this.cvId = source.cvId;    
    }
}