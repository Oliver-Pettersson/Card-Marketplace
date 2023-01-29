import { useState } from "react";
import ApiService from "../../../services/ApiService";
import { CardType } from "../../atoms/PlayCard/PlayCard";
import { FramedCardWithCount } from "../../molecules/FramedCardWithCount/FramedCardWithCount";

export interface CardData extends CardType {
  count: number;
  image: string;
  energy: number;
  attack: number;
  health: number;
}

export function InventoryPage() {
  const [cards, setCards] = useState<CardData[]>([]);
  return (
    <div>
      <button onClick={getCards}>Load market</button>
      <div style={flex}>
        {cards.map((card: CardData) => {
          return (
            <div>
              <FramedCardWithCount
                img={card.image}
                name={card.name}
                energy={card.energy}
                atk={card.attack}
                hp={card.health}
                count={card.count}
              />
            </div>
          );
        })}
      </div>
    </div>
  );
  function getCards(): void {
    let cardsArray: CardType[] = [];
    //get cards

    ApiService.get("card-user").then((res) => {
      console.log(res);
    });
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
    //filter cards
    let cardMap = new Map<String, CardData>();
    cardsArray.forEach((card) => {
      if (cardMap.has(card.name)) {
        let cardObject: CardData = {
          count: cardMap.get(card.name)!.count + 1,
          name: card.name,
          attack: card.attack,
          health: card.health,
          image: card.image,
          energy: card.energy,
        };
        cardMap.set(card.name, cardObject);
      } else {
        let cardObject: CardData = {
          count: 1,
          name: card.name,
          attack: card.attack,
          health: card.health,
          image: card.image,
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
