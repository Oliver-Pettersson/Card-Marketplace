import React, { createContext, useContext, useEffect, useState } from "react";
import CardEntity from "../models/Card/CardEntity";
import { useAuth } from "./AuthenticationContext";

type DataProviderProps = {
  children: React.ReactNode;
};

export type DataContextProps = {
  refreshcards: () => void;
  cards: CardEntity[];
};

const DataContext = createContext<DataContextProps>({} as DataContextProps);

export const useData = () => useContext(DataContext);

export const DataContextProvider = ({ children }: DataProviderProps) => {
  const [cards, setCards] = useState<CardEntity[]>([]);
  const { principal } = useAuth();

  const loadCards = () => {
    console.log("TODO: load cards from db");
    setCards([
      {
        id: "1",
        name: "Test",
        creationTimestamp: new Date(),
        image: "",
        health: 0,
        attack: 0,
        energy: 0,
      },
    ]);
  };

  useEffect(() => {
    if (principal) {
      loadCards();
    }
  }, [principal]);

  return (
    <DataContext.Provider
      value={{
        cards: cards,
        refreshcards: loadCards,
      }}
    >
      {children}
    </DataContext.Provider>
  );
};

export default DataContext;
