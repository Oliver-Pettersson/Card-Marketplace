import { PlayCard } from "../../atoms/Card/PlayCard";
interface Props {
  img: string;
  name: string;
  atk: number;
  hp: number;
  energy: number;
  count: number;
}

export function FramedCardWithCount(props: Props) {
  return (
    <div style={frame}>
      <div style={center}>
        <PlayCard
          img={props.img}
          name={props.name}
          atk={props.atk}
          hp={props.hp}
          energy={props.energy}
        />
      </div>
      <div>
        <h5 style={smallMargin}>Count: {props.count}</h5>
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
