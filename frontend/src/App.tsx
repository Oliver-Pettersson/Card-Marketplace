import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import Navbar from "./components/atoms/Navbar/Navbar";
import ProtectedRoute from "./components/atoms/ProtectedRoute/ProtectedRoute";
import DeckDetailsPage from "./components/pages/DeckDetailsPage/DeckDetailsPage";
import DeckPage from "./components/pages/DeckPage/DeckPage";
import HomePage from "./components/pages/HomePage/HomePage";
import { InventoryPage } from "./components/pages/InventoryPage/InventoryPage";
import LoginPage from "./components/pages/LoginPage/LoginPage";
import MarketPage from "./components/pages/MarketPage/MarketPage";
import SignUpPage from "./components/pages/SignUpPage/SignUpPage";
import { AuthenticationContextProvider } from "./contexts/AuthenticationContext";
import { DataContextProvider } from "./contexts/DataContext";
import { SnackbarContextProvider } from "./contexts/SnackbarContext";

function App() {
  return (
    <BrowserRouter>
      <AuthenticationContextProvider>
        <DataContextProvider>
        <SnackbarContextProvider>
          <Navbar />
          <Routes>
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
            <Route path="/market" element={<ProtectedRoute />}>
              <Route path="/market" element={<MarketPage />} />
            </Route>
            <Route path="/deckdetails/:deckIndex" element={<ProtectedRoute />}>
              <Route path="/deckdetails/:deckIndex" element={<DeckDetailsPage />} />
            </Route>
          </Routes>
        </SnackbarContextProvider>
        </DataContextProvider>
      </AuthenticationContextProvider>
    </BrowserRouter>
  );
}

export default App;
