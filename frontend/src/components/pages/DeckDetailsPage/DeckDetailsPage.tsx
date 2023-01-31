import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { useData } from "../../../contexts/DataContext";
import Deck from "../../../models/Deck/Deck";
import { PlayCard } from "../../atoms/PlayCard/PlayCard";

export default function DeckDetailsPage() {
  const { deckIndex } = useParams();
  const { decks } = useData();
  const [displayedDeck, setDisplayDeck] = useState(
    deckIndex === undefined || decks.length < 1
      ? { name: "NOT FOUND", cards: [] }
      : decks[Number.parseInt(deckIndex)]
  );
  useEffect(() => {
    decks.length > 0 &&
      deckIndex !== undefined &&
      setDisplayDeck(decks[Number.parseInt(deckIndex)]);
  }, [decks]);

  return (
    <div style={{ display: "flex", flexWrap: "wrap" }}>
      {displayedDeck.cards.map(({ card }) => {
        console.log(card.image);
        return (
          <PlayCard
            name={card.name}
            image={"../images/" +card.image}
            attack={card.cardStats.attack}
            health={card.cardStats.health}
            energy={card.cardStats.energy}
          />
        );
      })}
    </div>
  );
}
