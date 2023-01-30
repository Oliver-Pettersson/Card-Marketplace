import { Button, Card, CardActions, CardContent, CardMedia, Typography } from "@mui/material";

interface Props {
  img: string;
  expansion: string;
  cost: number;
  buyPack: () => void;
}
export function Pack({cost, expansion, img, buyPack}: Props) {
  return (
    <Card elevation={9} sx={{ maxWidth: 175, minHeight: 250, margin: "15px" }}>
      <CardMedia image={img} sx={{ height: "10em" }} />
      <CardContent sx={{ textAlign: "center" }}>
        <Typography variant="h5">{expansion}</Typography>
        <div style={{ textAlign: "justify", margin: "auto", width: "fit-content"}}>
        <Typography variant="body2">{cost} coins</Typography>
        </div>
      </CardContent>
      <CardActions sx={{justifyContent: "center"}}>
        <Button onClick={buyPack}>Buy</Button>
      </CardActions>
    </Card>
  );
}
