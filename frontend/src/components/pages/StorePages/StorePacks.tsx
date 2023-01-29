import { useState } from "react";
import { CardType, PlayCard } from "../../atoms/PlayCard/PlayCard";

export function Store_Packs() {
  const [cards, setCards] = useState<CardType[]>([]);
  return (
    <div>
      <button onClick={genCardsTemp}>Load market</button>
      {cards.map((card: CardType) => {
        return (
          <PlayCard
            image={card.image}
            name={card.name}
            energy={card.energy}
            attack={card.attack}
            health={card.health}
          />
        );
      })}
    </div>
  );
  function genCardsTemp() {
    let cardsArray: CardType[] = [];
    for (let i = 0; i < 50; i++) {
      let card: CardType = {
        image:
          "https://staticg.sportskeeda.com/editor/2022/01/362a0-16430841451113-1920.jpg",
        name: "Name",
        energy: 5,
        attack: 5,
        health: 5,
      };
      cardsArray.push(card);
    }
    setCards(cardsArray);
  }
}
