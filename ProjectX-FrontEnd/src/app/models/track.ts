export class track{
    constructor(
        public trackId: number,
        public trackName: string,
        public duration: string,
        public audioPath: string,
        public size: number,
        public description: string,
        public userUploadId: string
    ){ }
}