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
      <button onClick={getCards}>Show my cards</button>
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
  function getCards() {
    let cardMap = new Map<String, CardData>();

    ApiService.get("card-user/").then((res) => {
      console.log(res);
      res.data.forEach((card: CardData) => {
        if (cardMap.has(card.name)) {
          console.log("set as new");
          let cardObject: CardData = {
            count: cardMap.get(card.name)!.count + 1,
            name: card.name,
            attack: card.attack,
            health: card.health,
            image:
              "https://i.pinimg.com/736x/3c/b2/ea/3cb2ea34484f58497417471eee262c0e--dragon-artwork-blue-eyes-white-dragon.jpg",
            energy: card.energy,
          };
          cardMap.set(card.name, cardObject);
        } else {
          console.log("add");
          let cardObject: CardData = {
            count: 1,
            name: card.name,
            attack: card.attack,
            health: card.health,
            image:
              "https://i.pinimg.com/736x/3c/b2/ea/3cb2ea34484f58497417471eee262c0e--dragon-artwork-blue-eyes-white-dragon.jpg",
            energy: card.energy,
          };
          cardMap.set(card.name, cardObject);
        }
      });
      const filteredData: CardData[] = [...cardMap.values()];
      console.log(filteredData);
      setCards(filteredData);
    });
  }
}

const flex: React.CSSProperties = {
  margin: "auto",
  display: "grid",
  gridTemplateColumns: "auto auto auto auto auto auto auto",
  marginBottom: "3vh",
};
