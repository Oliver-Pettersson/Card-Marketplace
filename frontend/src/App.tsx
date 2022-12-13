import React from "react";
import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import LoginPage from "./components/pages/LoginPage/LoginPage";
import HomePage from "./components/pages/HomePage/HomePage";
import RegisterPage from "./components/pages/RegisterPage/RegisterPage";
import { AuthenticationContextProvider } from "./contexts/AuthenticationContext";
import { SnackbarContextProvider } from "./contexts/SnackbarContext";

function App() {
  return (
    <BrowserRouter>
      <AuthenticationContextProvider>
        <SnackbarContextProvider>
          <Routes>
            <Route path="/login" element={<LoginPage />} />
            <Route path="/register" element={<RegisterPage />} />
            <Route path="/" element={<HomePage />} />
          </Routes>
        </SnackbarContextProvider>
      </AuthenticationContextProvider>
    </BrowserRouter>
  );
}

export default App;
