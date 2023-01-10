import { useState } from "react";
import { Card, CardType } from "../../atoms/Card";

export function Store_Packs() {
  const [cards, setCards] = useState<CardType[]>([]);
  return (
    <div>
      <button onClick={genCardsTemp}>Load market</button>
      {cards.map((card: CardType) => {
        return (
          <Card
            img={card.img}
            name={card.name}
            energy={card.energy}
            atk={card.atk}
            hp={card.hp}
          />
        );
      })}
    </div>
  );
  function genCardsTemp() {
    let cardsArray: CardType[] = [];
    for (let i = 0; i < 50; i++) {
      let card: CardType = {
        img: "https://staticg.sportskeeda.com/editor/2022/01/362a0-16430841451113-1920.jpg",
        name: "Name",
        energy: 5,
        atk: 5,
        hp: 5,
      };
      cardsArray.push(card);
    }
    setCards(cardsArray);
  }
}
