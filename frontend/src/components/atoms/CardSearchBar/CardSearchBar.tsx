import { SxProps, TextFieldProps } from "@mui/material";
import Autocomplete from "@mui/material/Autocomplete";
import Box from "@mui/material/Box";
import Typography from "@mui/material/Typography";
import { useData } from "../../../contexts/DataContext";
import CardEntity from "../../../models/Card/CardEntity";
import CardSearchDTO from "../../../models/Card/CardSearchDTO";
import MuiTextField from "../../atoms/MuiTextField/MuiTextField";
interface PropsType {
  onSelection: (value: CardSearchDTO) => void;
  textFieldProps?: TextFieldProps;
  sx?: SxProps;
  value?: CardSearchDTO;
  options?: CardEntity[]
}

export default function CardSearchBar({
  onSelection,
  textFieldProps,
  sx,
  value,
  options
}: PropsType) {
  const {cards} = useData()  

  return (
    <Autocomplete
    value={value}
      sx={sx}
      onChange={(event, value) => value && onSelection(value)}
      options={options || cards}
      disablePortal
      autoHighlight
      isOptionEqualToValue={(option, value) => option.id === value.id}
      getOptionLabel={(option) => option.name}
      renderOption={(props, option) => (
        <Box
          component="li"
          sx={{
            width: "100%",
          }}
          {...props}
        >
          <div
            style={{
              width: "100%",
              display: "table",
              tableLayout: "fixed",
            }}
          >
            <div
              style={{
                justifyContent: "center",
                textAlign: "center",
                display: "table-caption",
              }}
            >
              <Typography variant="h4">{option.name}</Typography>
            </div>
            <div style={{ display: "table-row" }}>
              <Typography
                sx={{ display: "table-cell", textAlign: "center" }}
                variant="body2"
              >
                Attack: {option.attack}
              </Typography>
              <Typography
                sx={{ display: "table-cell", textAlign: "center" }}
                variant="body2"
              >
                Health: {option.health}
              </Typography>
              <Typography
                sx={{ display: "table-cell", textAlign: "center" }}
                variant="body2"
              >
                Energy: {option.energy}
              </Typography>
            </div>
          </div>
        </Box>
      )}
      renderInput={(params) => (
        <MuiTextField
          {...params}
          label="Search for Card"
          {...textFieldProps}
        />
      )}
    />
  );
}