import {
  Button,
  Card,
  CardActions,
  CardContent,
  CardMedia,
  Typography,
} from "@mui/material";
import { useNavigate } from "react-router-dom";

import React from "react";

interface PropsType {
  image: string;
  title: string;
  deckIndex: number;
}

export default function DeckDetailsCard({image, title, deckIndex} : PropsType) {
  const navigate = useNavigate();
  return (
    <Card elevation={9} sx={{ minWidth: 375, margin: "15px" }}>
      <CardMedia image={image} sx={{ height: "5em" }} />
      <CardContent sx={{ textAlign: "center" }}>
        <Typography variant="h5">{title}</Typography>
      </CardContent>
      <CardActions >
        <Button sx={{margin: "auto", width: "100%"}} onClick={() => navigate("/deckdetails/" + deckIndex)}  variant="text">Details</Button>
      </CardActions>
    </Card>
  );
}
