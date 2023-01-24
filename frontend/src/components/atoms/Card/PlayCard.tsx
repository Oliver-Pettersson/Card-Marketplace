import { Card, CardMedia } from "@mui/material";

export interface CardType {
  id?: string;
  img?: string;
  name?: string;
  energy?: number;
  atk?: number;
  hp?: number;
}
export function PlayCard(props: CardType) {
  return (
    <Card style={frame}>
      <CardMedia sx={img} image={props.img} />
      <div>{props.name}</div>
      <ul>
        <li>{props.energy} Energy</li>
        <li>{props.atk} ATK</li>
        <li>{props.hp} HP</li>
      </ul>
    </Card>
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
  objectFit: "cover",
};
