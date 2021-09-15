
export interface LoginRequest{
    login: string
    password: string
}

export interface LoginResponse{
    name: string
    token: string
}
