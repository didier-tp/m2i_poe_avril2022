export class LoginResponse {
    constructor(
        public username : string ="username",
        public status : boolean =false,
        public message : string ="ok or not",
        public token : string | null =null,
        public roles : string | null =null 
    ){}
}