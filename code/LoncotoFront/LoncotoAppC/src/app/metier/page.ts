export class Page<T>{
    constructor(public content: T[],
        public number: number,
        public numberOfElement: number,
        public size: number,
        public totalElements: number,
        public totalPages: number,
        public firts: boolean,
        public last: boolean,
        public sort: any) { }



public static emptyPage<T>() : Page<T>{
    return new Page<T>([],0,0,4,0,1,true,true,{});
}

}