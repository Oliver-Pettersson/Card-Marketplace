import { Typography } from "@mui/material";
import PackSection from "../../organisms/PackSection/PackSection";
import { StorePacks } from "./StorePacks";

export default function MarketPage() {
  return (
    <>
      <Typography variant="h3">Boosterpacks</Typography>
      <PackSection />
      <Typography variant="h3">Trading Market</Typography>
      <StorePacks />
      <Typography variant="h3">Community Market</Typography>
    </>
  );
}
