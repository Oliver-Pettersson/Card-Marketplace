import React from "react";
import Deck from "../../../models/Deck/Deck";
import DeckDetailsCard from "../../molecules/DeckDetailsCard/DeckDetailsCard";

interface PropsType {
  decks: Deck[];
}

export default function DeckList({ decks }: PropsType) {
  return (
    <div style={{ display: "flex", flexWrap: "wrap" }}>
      {decks.map((deck, index) => (
        <DeckDetailsCard title={deck.name} image={deck.cards[0].card.image} deckIndex={index} />
      ))}
    </div>
  );
}
