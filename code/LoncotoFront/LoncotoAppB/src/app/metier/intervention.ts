export class Intervention{
    public constructor(public id:number,public datePlanification:Date,public dateRealisation:Date,public descriptionPanne:string,public status:string,public commentaireIntervenant:string,public intervenantId:number,public materielId:number){}

    public copyFrom(source : Intervention){
        this.id=source.id;
        this.datePlanification=source.datePlanification;
        this.dateRealisation=source.dateRealisation;
        this.descriptionPanne=source.descriptionPanne;
        this.status=source.status;
        this.commentaireIntervenant=source.commentaireIntervenant;
        this.intervenantId = source.intervenantId;
        this.materielId = source.materielId;
    }
}