import React, { createContext, useContext, useEffect, useState } from "react";
import CardDTO from "../models/Card/CardDTO";
import Deck from "../models/Deck/Deck";
import User from "../models/User/User";
import CardService from "../services/CardService";
import UserService from "../services/UserService";
import { useAuth } from "./AuthenticationContext";

type DataProviderProps = {
  children: React.ReactNode;
};

export type DataContextProps = {
  refreshCards: () => void;
  cards: CardDTO[];
  refreshDecks: () => void;
  decks: Deck[]
  refreshUser: () => void;
  user: User
};

const DataContext = createContext<DataContextProps>({} as DataContextProps);

export const useData = () => useContext(DataContext);

export const DataContextProvider = ({ children }: DataProviderProps) => {
  const [cards, setCards] = useState<CardDTO[]>([]);
  const [decks, setDecks] = useState<Deck[]>([]);
  const [user, setUser] = useState<User>({coins: 0, username: ""})
  const { principal } = useAuth();

  const loadDecks = async () => {
    const {decks} = (await UserService().getSelf())
    console.log(decks);
    setDecks(decks)
  }

  const loadUser =async () => {
    const data = (await UserService().getSelf())
    setUser(data);
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
      loadUser();
    }
  }, [principal]);

  return (
    <DataContext.Provider
      value={{
        decks: decks,
        cards: cards,
        user: user,
        refreshCards: loadCards,
        refreshDecks: loadDecks,
        refreshUser: loadUser
      }}
    >
      {children}
    </DataContext.Provider>
  );
};

export default DataContext;
