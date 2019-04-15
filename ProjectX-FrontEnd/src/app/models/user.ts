import {user_type} from './user_type';

export class user {
  constructor(
    public userId: number,
    public displayName: string,
    public email: string,
    public gender: number,
    public dob: string,
    public providerId: string,
    public typeId: user_type
  ) { }
}
