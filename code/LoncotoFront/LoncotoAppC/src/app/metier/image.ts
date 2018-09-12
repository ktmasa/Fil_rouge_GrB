export class Image{
    public constructor(public id:number,public storageName:string, public fileName:string, public contentType:string,public intervention:number){}
    public copyFrom(source : Image){
        this.id=source.id;
        this.storageName=source.storageName;
        this.fileName=source.fileName;
        this.contentType=source.contentType;
        this.intervention=source.intervention;
    }

    public toJson() {
        return {
            id: this.id,
            storageName:this.storageName,
            fileName:this.fileName,
            contentType:this.contentType,
            intervention:this.intervention
        };
    }
}