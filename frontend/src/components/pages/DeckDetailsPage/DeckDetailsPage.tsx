import React from "react";
import { useParams } from "react-router-dom";
import { useData } from "../../../contexts/DataContext";
import Deck from "../../../models/Deck/Deck";
import { PlayCard } from "../../atoms/PlayCard/PlayCard";

export default function DeckDetailsPage() {
  const { deckIndex } = useParams();
  const { decks } = useData();
  const displayedDeck: Deck =
    deckIndex === undefined
      ? { name: "NOT FOUND", cards: [] }
      : decks[Number.parseInt(deckIndex)];

  return (
    <div style={{ display: "flex", flexWrap: "wrap" }}>
      {displayedDeck.cards.map(({ card }) => (
        <PlayCard
          name={card.name}
          image={card.image}
          attack={card.cardStats.attack}
          health={card.cardStats.health}
          energy={card.cardStats.energy}
        />
      ))}
    </div>
  );
}
