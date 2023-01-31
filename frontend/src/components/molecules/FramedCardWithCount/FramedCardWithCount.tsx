import { Paper } from "@mui/material";
import { PlayCard } from "../../atoms/PlayCard/PlayCard";
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
    <Paper sx={{margin: 5}}>
        <PlayCard
          
          image={props.img}
          name={props.name}
          attack={props.atk}
          health={props.hp}
          energy={props.energy}
        />
      <div>
        <h5>Count: {props.count}</h5>
      </div>
    </Paper>
  );
}
