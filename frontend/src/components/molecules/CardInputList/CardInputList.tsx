import DeleteIcon from "@mui/icons-material/Delete";
import { Button, IconButton } from "@mui/material";
import { useEffect, useState } from "react";
import CardSearchBar from "../../atoms/CardSearchBar/CardSearchBar";

interface PropsType {
  setFormikFieldValue: (value: string[]) => void,
}

export default function CardInputList({setFormikFieldValue} : PropsType) {
  const defaultItem = {
    id: "",
    name: "",
    attack: 0,
    health: 0,
    energy: 0, 
  };
  const [cardList, setCardList] = useState([defaultItem]);
  useEffect(() => {
    setFormikFieldValue(cardList.map((card) => {return card.id}))
  }, [cardList])
  
  return (
    <div style={{ justifyContent: "center" }}>
      {cardList.map((row, index) => (
        <div style={{ display: "flex", justifyContent: "space-between" }}>
          <CardSearchBar
            sx={{ width: "70%" }}
            
            value={row}
            onSelection={(value) => {
              const newArray = [...cardList];
              newArray[index] = value
              setCardList(newArray);
            }}
          />
          {cardList.length > 1 && (
            <IconButton
              sx={{ marginTop: "16px" }}
              onClick={() => {
                const newArray = [...cardList];
                newArray.splice(index, 1);
                setCardList(newArray);
              }}
            >
              <DeleteIcon sx={{ color: "#63A4FF" }} />
            </IconButton>
          )}
        </div>
      ))}
      <Button
        sx={{ width: "100%" }}
        fullWidth
        onClick={() => setCardList([...cardList, defaultItem])}
      >
        + Add Ingredient
      </Button>
    </div>
  );
}