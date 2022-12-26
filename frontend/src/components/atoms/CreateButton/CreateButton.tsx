import AddIcon from "@mui/icons-material/Add";
import { Button, ButtonProps } from "@mui/material";

export default function CreateButton(props: ButtonProps) {
  return (
    <Button
      color="primary"
      variant="contained"
      size="large"
      sx={{ width: "95%", height: "5vmax", marginTop: "10px" }}
      startIcon={<AddIcon />}
      {...props}
    >
      Create
    </Button>
  );
}
