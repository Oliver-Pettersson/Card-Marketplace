import { Card, CardMedia, CardContent, Typography, } from "@mui/material";

export interface CardType {
  image: string;
  name: string;
  energy: number;
  attack: number;
  health: number;
}

export function PlayCard({name, image, attack, energy, health}: CardType) {
  return (
    <Card elevation={9} sx={{ minWidth: 175, minHeight: 250, margin: "15px" }}>
      <CardMedia image={image} sx={{ height: "10em" }} />
      <CardContent sx={{ textAlign: "center" }}>
        <Typography variant="h5">{name}</Typography>
        <div style={{ textAlign: "justify", margin: "auto", width: "fit-content"}}>
        <Typography variant="body2">{energy} Energy</Typography>
        <Typography variant="body2">{attack} ATK</Typography>
        <Typography variant="body2">{health} HP</Typography>
        </div>
      </CardContent>
    </Card>
  );
}
