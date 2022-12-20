import React from "react";
import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import LoginPage from "./components/pages/LoginPage/LoginPage";
import HomePage from "./components/pages/HomePage/HomePage";
import SignUpPage from "./components/pages/SignUpPage/SignUpPage";
import { AuthenticationContextProvider } from "./contexts/AuthenticationContext";
import { SnackbarContextProvider } from "./contexts/SnackbarContext";
import ProtectedRoute from "./components/atoms/ProtectedRoute/ProtectedRoute";

function App() {
  return (
    <BrowserRouter>
      <AuthenticationContextProvider>
        <SnackbarContextProvider>
          <Routes>
            <Route path="/login" element={<LoginPage />} />
            <Route path="/signup" element={<SignUpPage />} />
            <Route path="/" element={<ProtectedRoute />}>
              <Route path="/" element={<HomePage />} />
            </Route>
          </Routes>
        </SnackbarContextProvider>
      </AuthenticationContextProvider>
    </BrowserRouter>
  );
}

export default App;
