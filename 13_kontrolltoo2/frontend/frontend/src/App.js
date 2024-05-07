import { useEffect, useRef, useState } from 'react';
import './App.css';

function App() {
  const [kaubandusKeskused, setKaubandusKeskused] = useState([]);
  const [poed, setPoed] = useState([]);
  const nimiRef = useRef();
  const avaRef = useRef();
  const suleRef = useRef();
  const kulaRef = useRef();
  const kaubRef = useRef();
  

  // Reacti hookid: use eesliidesega, neid peab importima. Reacti erikood
  // Springis annotatsioonid: @RestController, @GetMapping. neid peab importima. Springi erikood.

  // uef -> JS: onLoad()
  useEffect(() => {
    fetch("http://localhost:8080/poed")
      .then(response => response.json()) // koos metadataga (headerid, staatuskood, OK)
      .then(json => {
        setPoed(json);
      }) // body
  }, []);

  useEffect(() => {
    fetch("http://localhost:8080/kaubanduskeskus")
      .then(response => response.json())
      .then(json => {
        setKaubandusKeskused(json);
      }) // body
  }, []);

  function kustuta(primaarivoti) {
    fetch("http://localhost:8080/poed/" + primaarivoti, {"method": "DELETE"})
      .then(response => response.json()) 
      .then(json => {
        setPoed(json);
      })
  }

  function lisa() {
    // document.getElemenyById("sad").value -> guugeldada see vs useRef
    if (nimiRef.current.value.trim() === "") {
      return;
    }
    const pood = {
      "nimetus": nimiRef.current.value,
      "avatud": avaRef.current.value,
      "suletud": suleRef.current.value,
      "kulastanud": kulaRef.current.value,
      "kaubandusKeskus": {"nimetus": kaubRef.current.value}
    }
    fetch("http://localhost:8080/poed", 
    {
      "method": "POST", 
      "body": JSON.stringify(pood), 
      "headers": {"Content-Type": "application/json"}
    })
      .then(response => response.json()) 
      .then(json => {
        setPoed(json);
      })
  }

  return (
    <div className="App">
      <h2>Kaubanduskeskused</h2>

      {kaubandusKeskused.map(k => <div>{k.nimetus} </div>)}
      <hr />
      <h3>Poed</h3>
      <label>Poe nimi</label> <br/>
      <input ref={nimiRef} type="text" /> <br />
      <label>Poe avamise aeg</label> <br/>
      <input ref={avaRef} type="text" /> <br />
      <label>Poe sulgemise aeg</label> <br/>
      <input ref={suleRef} type="text" /> <br />
      <label>Külastatune arv</label> <br/>
      <input ref={kulaRef} type="text" /> <br />
      <label>Kaubanduskeskus (Sama nimi, mis üleval)</label> <br/>
      <input ref={kaubRef} type="text" /> <br />
      <button onClick={() => lisa()}>Sisesta</button> <br />
      <br />

      {poed.map(p => <div>{p.kaubandusKeskus.nimetus}: {p.nimetus} | {p.avatud} | {p.suletud} | {p.kulastanud} <button onClick={() => kustuta(p.id)}>x</button> </div> )}
    </div>
  );
}

export default App;
