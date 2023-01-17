import React from "react";
import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import LoginPage from "./components/pages/LoginPage/LoginPage";
import HomePage from "./components/pages/HomePage/HomePage";
import SignUpPage from "./components/pages/SignUpPage/SignUpPage";
import { AuthenticationContextProvider } from "./contexts/AuthenticationContext";
import { SnackbarContextProvider } from "./contexts/SnackbarContext";
import ProtectedRoute from "./components/atoms/ProtectedRoute/ProtectedRoute";
import Navbar from "./components/atoms/Navbar/Navbar";
import DeckPage from "./components/pages/DeckPage/DeckPage";
import { DataContextProvider } from "./contexts/DataContext";
import { InventoryPage } from "./components/pages/InventoryPage/InventoryPage";
import { StoreCards } from "./components/pages/StorePages/StoreCards";
import { StorePacks } from "./components/pages/StorePages/StorePacks";

function App() {
  return (
    <BrowserRouter>
      <AuthenticationContextProvider>
        <DataContextProvider>
          <SnackbarContextProvider>
            <Navbar />
            <Routes>
              <Route path="/shop/packs" element={<StorePacks />} />
              <Route path="/shop/cards" element={<StoreCards />} />
              <Route path="/login" element={<LoginPage />} />
              <Route path="/signup" element={<SignUpPage />} />
              <Route path="/" element={<ProtectedRoute />}>
                <Route path="/" element={<HomePage />} />
              </Route>
              <Route path="/decks" element={<ProtectedRoute />}>
                <Route path="/decks" element={<DeckPage />} />
              </Route>
              <Route path="/inventory" element={<ProtectedRoute />}>
                <Route path="/inventory" element={<InventoryPage />} />
              </Route>
            </Routes>
          </SnackbarContextProvider>
        </DataContextProvider>
      </AuthenticationContextProvider>
    </BrowserRouter>
  );
}

export default App;
