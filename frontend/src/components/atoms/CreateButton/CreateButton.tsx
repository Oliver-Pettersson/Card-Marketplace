import AddIcon from "@mui/icons-material/Add";
import { Button } from "@mui/material";

export default function CreateButton() {
  return (
    <Button
      color="primary"
      variant="contained"
      size="large"
      sx={{ width: "10vmax", height: "5vmax", margin: "10px" }}
      startIcon={<AddIcon />}
    >
      Create
    </Button>
  );
}
