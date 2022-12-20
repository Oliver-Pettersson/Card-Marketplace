export interface CardType {
  img: string;
  name: string;
  energy: number;
  atk: number;
  hp: number;
}
export function Card(props: CardType) {
  return (
    <div style={frame}>
      <img style={img} src={props.img} />
      <div>{props.name}</div>
      <ul>
        <li>{props.energy} Energy</li>
        <li>{props.atk} ATK</li>
        <li>{props.hp} HP</li>
      </ul>
    </div>
  );
}

const frame = {
  width: "140px",
  "border-style": "solid",
  "border-width": "thick",
};
const img = {
  height: "250px",
  width: "140px",
};
