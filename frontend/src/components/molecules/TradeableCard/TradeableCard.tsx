import { PlayCard } from "../../atoms/PlayCard/PlayCard";
interface Props {
  cardImg: string;
  cardName: string;
  cardAtk: number;
  cardHp: number;
  cardEnergy: number;
  stock: number;
  request: string;
}

export function TradeableCard(props: Props) {
  return (
    <div style={frame}>
      <div style={center}>
        <PlayCard
          image={props.cardImg}
          name={props.cardName}
          attack={props.cardAtk}
          health={props.cardHp}
          energy={props.cardEnergy}
        />
      </div>
      <div>
        <h5>Wants Card:</h5>
        {props.request}
        <button>Trade</button>
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
  display: "flex",
  "justify-content": "center",
};
