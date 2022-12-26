import React, { useState } from "react";
import CreateButton from "../../atoms/CreateButton/CreateButton";
import CreateDeckDialog from "../../organisms/CreateDeckDialog/CreateDeckDialog";
import DeckList from "../../organisms/DeckList/DeckList";

export default function DeckPage() {
  const [createDialogIsOpen, setCreateDialogIsOpen] = useState(false)
  return (
    <div style={{width: "100%", textAlign: "center"}}>
      <CreateButton onClick={() => setCreateDialogIsOpen(true)} />
      <DeckList />
      <CreateDeckDialog open={createDialogIsOpen} setOpen={setCreateDialogIsOpen}/>
    </div>
  );
}
