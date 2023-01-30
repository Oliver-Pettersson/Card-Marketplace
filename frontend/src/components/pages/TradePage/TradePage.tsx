import { useEffect, useState } from "react";
import CardSearchBar from "../../atoms/CardSearchBar/CardSearchBar";
import CardSearchDTO from "../../../models/Card/CardSearchDTO";
import { TradeableCard } from "../../molecules/TradeableCard/TradeableCard";
import { PlayCard } from "../../atoms/PlayCard/PlayCard";
import CardEntity from "../../../models/Card/CardEntity";
export interface PackProps {
  img: string;
  expansion: string;
  cost: number;
}
export function TradePage() {
  const [inventoryCards, setInventoryCards] = useState();
  const [communityCards, setcommunityCards] = useState();
  const [selectedInventoryCard, selectInventoryCard] =
    useState<CardSearchDTO>();
  const [selectedCommunityCard, selectCommunityCard] =
    useState<CardSearchDTO>();

  useEffect(() => {
    //todo
    //Get inventory cards
    //Get community cards
  });

  return (
    <div>
      <PlayCard
        atk={selectedInventoryCard?.attack}
        hp={selectedInventoryCard?.health}
        name={selectedInventoryCard?.name}
        energy={selectedInventoryCard?.energy}
      />
      <CardSearchBar
        options={inventoryCards}
        onSelection={(value) => {
          selectInventoryCard(value);
        }}
      />

      <PlayCard
        atk={selectedCommunityCard?.attack}
        hp={selectedCommunityCard?.health}
        name={selectedCommunityCard?.name}
        energy={selectedCommunityCard?.energy}
      />
      <CardSearchBar
        options={communityCards}
        onSelection={(value) => {
          selectCommunityCard(value);
        }}
      />

      <button>Request/Initiate Trade</button>
    </div>
  );
}
