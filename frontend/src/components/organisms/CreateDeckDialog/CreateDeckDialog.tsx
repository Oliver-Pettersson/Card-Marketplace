import { Button, Dialog, DialogActions, DialogContent, DialogTitle } from "@mui/material";
import { Form, Formik } from "formik";
import React from "react";
import { useData } from "../../../contexts/DataContext";
import DeckService from "../../../services/DeckService";
import MuiTextField from "../../atoms/MuiTextField/MuiTextField";
import CardInputList from "../../molecules/CardInputList/CardInputList";

interface PropsType {
  open: boolean;
  setOpen: React.Dispatch<React.SetStateAction<boolean>>;
}

export default function CreateDeckDialog({ open, setOpen }: PropsType) {
  const {refreshDecks} = useData()
  return (
    <Dialog open={open} fullWidth maxWidth="sm">
        <div style={{minWidth: "100%"}}>
      <Formik
        initialValues={{ name: "", cards: [] }}
        onSubmit={async (values) => {
          console.log(values);
          try {
          await DeckService().create(values)
          refreshDecks()
          setOpen(false)}
          catch (exception) {
            console.log(exception);
            
          }
        }}
      >
        {({ handleChange, setFieldValue }) => (
          <Form style={{minWidth: "100%"}}>
            <DialogTitle>Create Deck</DialogTitle>
            <DialogContent sx={{minWidth: "60%"}}>
              <MuiTextField
                placeholder="name"
                name="name"
                onChange={handleChange}
              />
              <CardInputList setFormikFieldValue={(value) => setFieldValue("cards", value)} />
            </DialogContent>
            <DialogActions>
              <Button onClick={() => setOpen(false)}>Cancel</Button>
              <Button type="submit">Submit</Button>
            </DialogActions>
          </Form>
        )}
      </Formik>
      </div>
    </Dialog>
  );
}
