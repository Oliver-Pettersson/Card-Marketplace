import { useEffect, useState } from "react";
import { Pack, PackProps } from "../../molecules/Pack";

export function StorePacks() {
  const [packs, setPacks] = useState<PackProps[]>([]);
  useEffect(() => {
    genPacksTemp();
  });
  return (
    <div>
      <div style={flex}>
        {packs.map((pack: PackProps) => {
          return (
            <div style={flex}>
              <Pack
                img={pack.img}
                expansion={pack.expansion}
                cost={pack.cost}
              />
            </div>
          );
        })}
      </div>
    </div>
  );

  function genPacksTemp() {
    let packsArray: PackProps[] = [];
    for (let i = 0; i < 50; i++) {
      let pack: PackProps = {
        img: "https://staticg.sportskeeda.com/editor/2022/01/362a0-16430841451113-1920.jpg",
        expansion: "Expansion name",
        cost: 500,
      };
      packsArray.push(pack);
    }
    setPacks(packsArray);
  }
}

const flex: React.CSSProperties = {
  margin: "auto",
  display: "grid",
  gridTemplateColumns: "auto auto auto auto auto auto auto",
  marginBottom: "3vh",
};
