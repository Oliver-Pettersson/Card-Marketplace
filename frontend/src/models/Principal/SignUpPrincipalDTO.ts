import Principal from "./Principal"

export default interface SignUpPrincipalDTO extends Principal {
    password: string
}