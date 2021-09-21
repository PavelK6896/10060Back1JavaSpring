
export interface LoginRequestDto{
    username: string
    password: string
}

export interface LoginResponseDto{
    name: string
    token: string
}


export interface RefreshRequestDto{
    refresh: string
    username: string
}
