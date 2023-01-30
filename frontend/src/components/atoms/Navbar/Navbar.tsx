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

export default function Navbar() {
  const pages = [
    { name: "Home", path: "/" },
    { name: "Packs", path: "/shop/packs" },
    { name: "Cards", path: "/shop/cards" },
    { name: "Decks", path: "/decks" },
    { name: "Inventory", path: "/inventory" },
  ];
  const { isProcessingAuthentication, logout } = useAuth();
  const navigate = useNavigate();
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
            <Button
              startIcon={<LogoutOutlined />}
              onClick={() => logout()}
              sx={{
                my: 2,
                color: "black",
                right: 0,
                top: 0,
                bottom: 0,
                position: "absolute",
              }}
            >
              Logout
            </Button>
          </Box>
        </Toolbar>
      </Container>
    </AppBar>
  );
}
