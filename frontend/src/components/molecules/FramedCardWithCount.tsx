import { Card } from "../atoms/Card";
interface Props {
  imgage: string;
  name: string;
  attack: number;
  health: number;
  energy: number;
  count: number;
}

export function FramedCardWithCount(props: Props) {
  return (
    <div style={frame}>
      <div style={center}>
        <Card
          img={props.imgage}
          name={props.name}
          atk={props.attack}
          hp={props.health}
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
