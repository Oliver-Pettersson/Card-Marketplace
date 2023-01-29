import { useState } from "react";
import { CardType } from "../../atoms/PlayCard/PlayCard";
import { BuyableCard } from "../../molecules/BuyableCard/BuyableCard";

export function Store_Cards() {
  const [cards, setCards] = useState<CardType[]>([]);
  return (
    <div>
      <button onClick={genCardsTemp}>Load market</button>
      <div style={flex}>
        {cards.map((card: CardType) => {
          return (
            <div style={flex}>
              <BuyableCard
                stock={5}
                cost={5}
                cardImg={card.image}
                cardName={card.name}
                cardEnergy={card.energy}
                cardAtk={card.attack}
                cardHp={card.health}
              />
            </div>
          );
        })}
      </div>
    </div>
  );
  function genCardsTemp() {
    let cardsArray: CardType[] = [];
    for (let i = 0; i < 50; i++) {
      let card: CardType = {
        image: "https://staticg.sportskeeda.com/editor/2022/01/362a0-16430841451113-1920.jpg",
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

const flex: React.CSSProperties = {
  margin: "auto",
  display: "grid",
  gridTemplateColumns: "auto auto auto auto auto auto auto",
  marginBottom: "3vh",
};
