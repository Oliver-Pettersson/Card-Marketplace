import {
  Button,
  Card,
  CardActions,
  CardContent,
  CardMedia,
  Typography,
} from "@mui/material";
import React from "react";

export default function DeckDetailsCard() {
  return (
    <Card elevation={9} sx={{ minWidth: 375, margin: "15px" }}>
      <CardMedia image="images/placeholder-image.png" sx={{ height: "5em" }} />
      <CardContent sx={{ textAlign: "center" }}>
        <Typography variant="h5">Placeholder</Typography>
      </CardContent>
      <CardActions >
        <Button sx={{margin: "auto", width: "100%"}} variant="text">Details</Button>
      </CardActions>
    </Card>
  );
}
