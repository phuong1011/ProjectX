import { track } from './track';
import { category } from './category';

export class album{
    constructor(
        public albumId: number,
        public albumName: string,
        public releaseDate: string,
        public imagePath: string,
        public category: category,
        public artist: any,
        public trackList: track[]
    ){ }
}