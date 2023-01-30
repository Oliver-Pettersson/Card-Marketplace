import { LogoutOutlined } from "@mui/icons-material";
import {
  AppBar,
  Box,
  Button,
  Container,
  Toolbar,
  Typography,
} from "@mui/material";
import React from "react";
import { useLocation, useNavigate } from "react-router-dom";
import { useAuth } from "../../../contexts/AuthenticationContext";
import { useData } from "../../../contexts/DataContext";

export default function Navbar() {
  const pages = [
    { name: "Home", path: "/" },
    { name: "Decks", path: "/decks" },
    { name: "Inventory", path: "/inventory" },
    { name: "Market", path: "/market" },
  ];
  const { isProcessingAuthentication, logout } = useAuth();
  const navigate = useNavigate();
  const { user } = useData();
  const path = useLocation().pathname;
  const isAuth = path === "/login" || path === "/signup";

  return isAuth || isProcessingAuthentication ? (
    <></>
  ) : (
    <AppBar sx={{ backgroundColor: "white", color: "black" }} position="static">
      <Container maxWidth="xl">
        <Toolbar disableGutters>
          <Typography
            variant="h6"
            noWrap
            component="a"
            href="/"
            sx={{
              mr: 2,
              display: { xs: "none", md: "flex" },
              fontFamily: "monospace",
              fontWeight: 700,
              letterSpacing: ".3rem",
              color: "inherit",
              textDecoration: "none",
            }}
          >
            CARD MARKETPLACE
          </Typography>

          <Box
            sx={{
              flexGrow: 1,
              display: { md: "flex" },
              justifyContent: { xs: "center", md: "initial" },
            }}
          >
            {pages.map((page) => (
              <Button
                key={page.name}
                onClick={() => navigate(page.path)}
                sx={{
                  my: 2,
                  color: "black",
                  display: "block",
                  margin: { xs: "auto", md: "0" },
                }}
              >
                {page.name}
              </Button>
            ))}
            <div
              style={{
                display: "flex",
                right: 0,
                top: 0,
                bottom: 0,
                position: "absolute",
              }}
            >
              <Typography
                sx={{
                  margin: "auto",
                  marginRight: "25px",
                  height: "1em",
                  display: "inline-block",
                  verticalAlign: "middle",
                  lineHight: "normal",
                }}
                variant="body2"
              >
                {user.coins} Coins
              </Typography>
              <Button
                startIcon={<LogoutOutlined />}
                onClick={() => logout()}
                sx={{
                  my: 1.25,
                  color: "black",
                }}
              >
                Logout
              </Button>
            </div>
          </Box>
        </Toolbar>
      </Container>
    </AppBar>
  );
}
