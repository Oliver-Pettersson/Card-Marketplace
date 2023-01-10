import { useState } from "react";
import { Card, CardType } from "../../atoms/Card";
import { FramedCardWithCount } from "../../molecules/FramedCardWithCount";

export interface CardData extends CardType {
  count: number;
  img: string;
  energy: number;
  atk: number;
  hp: number;
}

export function Inventory() {
  const [cards, setCards] = useState<CardData[]>([]);
  return (
    <div>
      <p>[Cash:5000]</p>
      <button onClick={genCardsTemp}>Load market</button>
      <div style={flex}>
        {cards.map((card: CardData) => {
          return (
            <div>
              <FramedCardWithCount
                img={card.img}
                name={card.name}
                energy={card.energy}
                atk={card.atk}
                hp={card.hp}
                count={card.count}
              />
            </div>
          );
        })}
      </div>
    </div>
  );
  function genCardsTemp() {
    let cardsArray: CardType[] = [];
    //get cards
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
    //filter cards
    let cardMap = new Map<String, CardData>();
    cardsArray.forEach((card) => {
      if (cardMap.has(card.name)) {
        let cardObject: CardData = {
          count: cardMap.get(card.name)!.count + 1,
          name: card.name,
          atk: card.atk,
          hp: card.hp,
          img: card.img,
          energy: card.energy,
        };
        cardMap.set(card.name, cardObject);
      } else {
        let cardObject: CardData = {
          count: 1,
          name: card.name,
          atk: card.atk,
          hp: card.hp,
          img: card.img,
          energy: card.energy,
        };
        cardMap.set(card.name, cardObject);
      }
    });
    const filteredData: CardData[] = [...cardMap.values()];
    setCards(filteredData);
  }
}

const flex: React.CSSProperties = {
  margin: "auto",
  display: "grid",
  gridTemplateColumns: "auto auto auto auto auto auto auto",
  marginBottom: "3vh",
};
