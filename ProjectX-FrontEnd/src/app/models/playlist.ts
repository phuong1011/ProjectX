import { track } from './track';
import { category } from './category';

export class playlist{
    constructor(
        public playlistId: number,
        public playlistName: string,
        public imagePath: string,
        public type: number,
        public category: category,
        public userId: string,
        public tracks: track[]
    ){ }
}