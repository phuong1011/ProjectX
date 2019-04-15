import {user} from './user';

export class artist {
  constructor(
    public artistId: number,
    public artistName: string,
    public bio: string,
    public customUrl: string,
    public backgroundPath: string,
    public userId: user
  ) { }
}
