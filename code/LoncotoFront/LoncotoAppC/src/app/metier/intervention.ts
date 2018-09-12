import { Site } from "./Site";
import { Materiel } from "./materiel";
import { Article } from "./article";
import { Client } from "./client";
import { Salle } from "./salle";
import { Etage } from "./etage";
import { Batiment } from "./batiment";

export class Intervention{
    public constructor(public id:number,
        public datePlanification:Date,
        public dateRealisation:Date,
        public descriptionPanne:string,
        public status:string,
        public commentaireIntervenant:string,
        public intervenant:number,
        public materiel:number,
        public sites?:Site,
        public materiels?: Materiel,
        public articles?: Article,
        public clients?: Client,
        public salles?: Salle,
        public etages?: Etage,
        public batiments?: Batiment
    ){}

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