import { PlayCard } from "../../atoms/Card/PlayCard";
interface Props {
  cardImg?: string;
  cardName?: string;
  cardAtk?: number;
  cardHp?: number;
  cardEnergy?: number;
  stock: number;
  cost: number;
}

export function BuyableCard(props: Props) {
  return (
    <div style={frame}>
      <div style={center}>
        <PlayCard
          img={props.cardImg}
          name={props.cardName}
          atk={props.cardAtk}
          hp={props.cardHp}
          energy={props.cardEnergy}
        />
      </div>
      <div>
        <h5 style={smallMargin}>Stock: {props.stock}</h5>
        <h5 style={smallMargin}>Costs: {props.cost} Coins</h5>
        <button>Buy</button>
      </div>
    </div>
  );
}

const frame = {
  width: "170px",
  "border-style": "solid",
  "border-width": "thick",
};

const center = {
  padding: "20px",
  "padding-bottom": "0px",
  display: "flex",
  "justify-content": "center",
};

const smallMargin = {
  margin: "2px",
};
