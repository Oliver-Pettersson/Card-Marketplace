import CardEntity from "../Card/CardEntity";

export default interface Deck {
    name: string,
    cards: {id: string, card: CardEntity}[]
}