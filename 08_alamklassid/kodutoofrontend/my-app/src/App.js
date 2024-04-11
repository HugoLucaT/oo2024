//import logo from './logo.svg';
import { useEffect, useRef, useState } from 'react';
import './App.css';

function App() {
  const [kogus, setKogus] = useState(0); // HTMLs esinevad muutujad peavad olema useState sees
  const [tootajad, setTootajad] = useState([]);
  const nimiRef = useRef();
  const tooRef = useRef();
  const palkRef = useRef();
  

  // Reacti hookid: use eesliidesega, neid peab importima. Reacti erikood
  // Springis annotatsioonid: @RestController, @GetMapping. neid peab importima. Springi erikood.

  // uef -> JS: onLoad()
  useEffect(() => {
    fetch("http://localhost:8080/tootajad")
      .then(response => response.json()) // koos metadataga (headerid, staatuskood, OK)
      .then(json => {
        setKogus(json.length);
        setTootajad(json);
      }) // body
  }, []);

  function kustuta(primaarivoti) {
    fetch("http://localhost:8080/tootajad/" + primaarivoti, {"method": "DELETE"})
      .then(response => response.json()) 
      .then(json => {
        setKogus(json.length);
        setTootajad(json);
      })
  }

  function lisa() {
    // document.getElemenyById("sad").value -> guugeldada see vs useRef
    if (nimiRef.current.value.trim() === "") {
      return;
    }
    const tootaja = {
      "nimi": nimiRef.current.value,
      "tookoht": tooRef.current.value,
      "palk": palkRef.current.value,
    }
    fetch("http://localhost:8080/tootajad", 
    {
      "method": "POST", 
      "body": JSON.stringify(tootaja), 
      "headers": {"Content-Type": "application/json"}
    })
      .then(response => response.json()) 
      .then(json => {
        setKogus(json.length);
        setTootajad(json);
      })
  }

  return (
    <div className="App">
      Ettevõttes on {kogus} töötajat
      <br /><br />
      
      <label>Töötaja nimi</label> <br/>
      <input ref={nimiRef} type="text" /> <br />
      <label>Töökoht</label> <br/>
      <input ref={tooRef} type="text" /> <br />
      <label>Palk</label> <br/>
      <input ref={palkRef} type="text" /> <br />
      <button onClick={() => lisa()}>Sisesta</button> <br />
      <br />

      {tootajad.map(t => <div>{t.nimi} <button onClick={() => kustuta(t.nimi)}>x</button> </div> )}
    </div>
  );
}

export default App;