import React from 'react'
import DeckDetailsCard from '../../molecules/DeckDetailsCard/DeckDetailsCard'

export default function DeckList() {
    const decks = [1,1,1,1,1,1,1,1,1,1,1,1]
  return (
    <div style={{display: "flex", flexWrap: "wrap"}}>{decks.map((_deck) => <DeckDetailsCard />)}</div>
  )
}
