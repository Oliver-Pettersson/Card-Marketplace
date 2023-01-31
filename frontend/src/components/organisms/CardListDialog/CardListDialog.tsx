import {
  Button,
  Dialog,
  DialogActions,
  DialogContent,
  DialogTitle,
} from "@mui/material";
import React from "react";
import CardEntity from "../../../models/Card/CardEntity";
import { PlayCard } from "../../atoms/PlayCard/PlayCard";

interface PropsType {
  title: string;
  open: boolean;
  setOpen: React.Dispatch<React.SetStateAction<boolean>>;
  cards: CardEntity[];
}

export default function CardListDialog({
  open,
  setOpen,
  title,
  cards,
}: PropsType) {
  return (
    <Dialog open={open} fullWidth maxWidth="md">
      <DialogTitle>{title}</DialogTitle>
      <DialogContent>
        <div style={{ display: "flex", flexWrap: "wrap" }}>
          {cards.map((card) => (
            <PlayCard
              image={"images/" + card.image}
              name={card.name}
              energy={card.cardStats.energy}
              attack={card.cardStats.attack}
              health={card.cardStats.health}
            />
          ))}
        </div>
      </DialogContent>
      <DialogActions>
        <Button onClick={() => setOpen(false)}>Close</Button>
      </DialogActions>
    </Dialog>
  );
}
