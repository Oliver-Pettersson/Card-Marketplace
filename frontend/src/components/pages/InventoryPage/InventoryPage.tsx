import { useEffect, useState } from "react";
import { useData } from "../../../contexts/DataContext";
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
  const { cards } = useData();
  const [occurrenceMap, setOccurrenceMap] = useState(new Map());
  const refreshOccurenceMap = () => {
    const newMap = new Map()
    cards.forEach((card) => {
      console.log(card.name, newMap.has(card.name));
      
      if (newMap.has(card.name)) {
        newMap.set(card.name, newMap.get(card.name) + 1)
      }
      else {
        newMap.set(card.name, 1)
      }
    });
    setOccurrenceMap(newMap);
  }

  useEffect(() => {
    refreshOccurenceMap()
  }, [cards]);
  useEffect(() => {
    refreshOccurenceMap()
  }, [])
  console.log(occurrenceMap);

  return (
    <div>
      <div style={{ display: "flex", flexWrap: "wrap" }}>
        {cards.filter((card, index, self) => self.findIndex((search) => search.name === card.name) === index).map((card) => {
          return (
            <div>
              <FramedCardWithCount
                img={card.image}
                name={card.name}
                energy={card.energy}
                atk={card.attack}
                hp={card.health}
                count={occurrenceMap.get(card.name)}
              />
            </div>
          );
        })}
      </div>
    </div>
  );
}
