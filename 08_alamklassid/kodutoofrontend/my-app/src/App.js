//import logo from './logo.svg';
import { useEffect, useRef, useState } from 'react';
import './App.css';

function App() {
  const [kogus, setKogus] = useState(0); // HTMLs esinevad muutujad peavad olema useState sees
  const [tootajad, setTootajad] = useState([]);
  const nimiRef = useRef();
  const tooRef = useRef();
  const lisapalkRef = useRef();
  const [tookohad, setTookohad] = useState([])
  

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

  useEffect(() => {
    fetch("http://localhost:8080/tookohad")
      .then(response => response.json())
      .then(json => {
        setTookohad(json);
        //setToiduained(json);
      })
  }, []);

  function kustuta(primaarivoti) {
    fetch("http://localhost:8080/tootajad/" + primaarivoti, {"method": "DELETE"})
      .then(response => response.json()) 
      .then(json => {
        setKogus(json.length);
        setTootajad(json);
      })
  }

  function kustutaTK(primaarivoti) {
    fetch("http://localhost:8080/tookohad/" + primaarivoti, {"method": "DELETE"})
      .then(response => response.json()) 
      .then(json => {
        setTookohad(json);
      })
  }

  function lisa() {
    // document.getElemenyById("sad").value -> guugeldada see vs useRef
    if (nimiRef.current.value.trim() === "") {
      return;
    }
    const tootaja = {
      "nimi": nimiRef.current.value,
      "tootajapalk": {"tookoht": tooRef.current.value},
      "lisapalk": lisapalkRef.current.value,
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

  const tkNimiRef = useRef();
  const palkRef = useRef();
  function lisaTK(){
    const lisatavTK = {
      "tookoht": tkNimiRef.current.value,
      "baaspalk": palkRef.current.value
    }
    fetch("http://localhost:8080/tookohad", {
      "method": "POST", 
      "body": JSON.stringify(lisatavTK), 
      "headers": {"Content-Type": "application/json"}
    })
      .then(response => response.json()) 
      .then(json => {
        setTookohad(json);
    })
  }

  return (
    <div className="App">
      Ettevõttes on {kogus} töötajat
      <br /><br />
      <label>Töökoha nimi</label> <br/>
      <input ref={tkNimiRef} type="text"></input><br/>
      <label>Töökoha palk</label> <br/>
      <input ref={palkRef} type="text"></input><br/>
      <button onClick={() => lisaTK()}>Sisesta</button> <br />
      {tookohad.map(tk => <div>{tk.tookoht} | Baaspalk: {tk.baaspalk} <button onClick={() => kustutaTK(tk.id)}>x</button> </div> )}
      <hr />
      <label>Töötaja nimi</label> <br/>
      <input ref={nimiRef} type="text" /> <br />
      <label>Töökoht</label> <br/>
      <input ref={tooRef} type="text" /> <br />
      <label>Lisapalk</label> <br/>
      <input ref={lisapalkRef} type="text" /> <br />
      <button onClick={() => lisa()}>Sisesta</button> <br />

      {tootajad.map(t => <div>{t.nimi} | {t.tootajapalk.tookoht} | Kogupalk: {t.lisapalk + t.tootajapalk.baaspalk} <button onClick={() => kustuta(t.id)}>x</button> </div> )}
      <hr />
      
    </div>
  );
}

export default App;