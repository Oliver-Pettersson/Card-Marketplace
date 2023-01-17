export interface PackProps {
  img: string;
  expansion: string;
  cost: number;
}
export function Pack(props: PackProps) {
  return (
    <div style={frame}>
      <div style={center}>
        <img style={img} src={props.img} />
      </div>
      <div>
        <>
          <h5>{props.expansion}</h5>
          <h5>Costs: {props.cost} Coins</h5>
          <button>Buy</button>
        </>
      </div>
    </div>
  );
}

const frame = {
  width: "170px",
  "border-style": "solid",
  "border-width": "thick",
};

const center = {
  display: "flex",
  "justify-content": "center",
  "border-style": "solid",
  "border-width": "thick",
  margin: "10px",
};

const img = {
  height: "250px",
  width: "140px",
};
