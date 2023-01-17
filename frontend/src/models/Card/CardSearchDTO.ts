import CardEntity from "./CardEntity";

export default interface CardSearchDTO extends Omit<CardEntity, "image" | "creationTimestamp"> {
    
}