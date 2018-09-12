export class Intervention{
    public constructor(public id:number,public datePlanification:Date,public dateRealisation:Date,public descriptionPanne:string,public status:string,public commentaireIntervenant:string,public intervenant:number,public materiel:number){}

    public copyFrom(source : Intervention){
        this.id=source.id;
        this.datePlanification=source.datePlanification;
        this.dateRealisation=source.dateRealisation;
        this.descriptionPanne=source.descriptionPanne;
        this.status=source.status;
        this.commentaireIntervenant=source.commentaireIntervenant;
        this.intervenant = source.intervenant;
        this.materiel = source.materiel;
    }

    public toJson() {
        return {
            id: this.id,
            datePlanification:this.datePlanification,
            dateRealisation:this.dateRealisation,
            descriptionPanne:this.descriptionPanne,
            status:this.status,
            commentaireIntervenant:this.commentaireIntervenant,
            intervenant:this.intervenant,
            materiel:this.materiel
        };
    }
}