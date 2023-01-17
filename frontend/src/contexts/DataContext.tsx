import React, { createContext, useContext, useEffect, useState } from "react";
import CardEntity from "../models/Card/CardEntity";
import Deck from "../models/Deck/Deck";
import CardService from "../services/CardService";
import UserService from "../services/UserService";
import { useAuth } from "./AuthenticationContext";

type DataProviderProps = {
  children: React.ReactNode;
};

export type DataContextProps = {
  refreshCards: () => void;
  cards: CardEntity[];
  refreshDecks: () => void;
  decks: Deck[]
};

const DataContext = createContext<DataContextProps>({} as DataContextProps);

export const useData = () => useContext(DataContext);

export const DataContextProvider = ({ children }: DataProviderProps) => {
  const [cards, setCards] = useState<CardEntity[]>([]);
  const [decks, setDecks] = useState<Deck[]>([])
  const { principal } = useAuth();

  const loadDecks = async () => {
    setDecks((await UserService().getSelf()).decks)
  }

  const loadCards = async () => {
    const value = (await CardService().getAll())
    console.log("TODO: load cards from db", value);

    setCards(value);
  };

  useEffect(() => {
    if (principal) {
      loadCards();
      loadDecks();
    }
  }, [principal]);

  return (
    <DataContext.Provider
      value={{
        decks: decks,
        cards: cards,
        refreshCards: loadCards,
        refreshDecks: loadDecks
      }}
    >
      {children}
    </DataContext.Provider>
  );
};

export default DataContext;
