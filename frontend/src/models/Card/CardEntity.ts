import CardStats from "../CardStats/CardStats";

export default interface CardEntity {
  id: string;
  name: string;
  image: string;
  creationTimestamp: Date;
  cardStats: CardStats;
}
