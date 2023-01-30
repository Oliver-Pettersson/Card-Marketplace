import { useState } from "react";
import ApiService from "../../../services/ApiService";
import { CardType, PlayCard } from "../../atoms/PlayCard/PlayCard";

export function StorePacks() {
  const [cards, setCards] = useState<CardType[]>([]);
  return (
    <div>
      <img src="https://staticg.sportskeeda.com/editor/2022/01/362a0-16430841451113-1920.jpg" />
      <button onClick={buyPack}>Buy Pack</button>
    </div>
  );

  function buyPack() {
    ApiService.post("card-user/pack", {});
  }
}
