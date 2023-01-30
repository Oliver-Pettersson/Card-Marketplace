import React, { useState } from "react";
import { useData } from "../../../contexts/DataContext";
import CardService from "../../../services/CardService";
import { Pack } from "../../molecules/Pack/Pack";
import CardListDialog from "../CardListDialog/CardListDialog";

export default function PackSection() {
  const [receivedCards, setReceivedCards] = useState([]);
  const [dialogIsOpen, setDialogIsOpen] = useState(false);
  const {refreshUser} = useData()
  const buyPack = () => {
    CardService()
      .getPack()
      .then((data) => {
        console.log(data);
        setReceivedCards(data.map(({card} : any) => card));
        setDialogIsOpen(true);
        refreshUser();
      });
  };
  return (
    <div>
      <Pack buyPack={buyPack} img={""} expansion={"Expansion V1"} cost={100} />
      <CardListDialog
        open={dialogIsOpen}
        setOpen={setDialogIsOpen}
        title={"Received Cards"}
        cards={receivedCards}
      />
    </div>
  );
}
