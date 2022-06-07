export class Recipe {
    public name:String;
    public description:String;
    public imageUrl:String;

    constructor(name: String, desc:String, imageUrl:String){
        this.name = name;
        this.description = desc;
        this.imageUrl = imageUrl;
    }
}