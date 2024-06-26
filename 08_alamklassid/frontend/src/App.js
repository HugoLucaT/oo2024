//import logo from './logo.svg';
import { useEffect, useRef, useState } from 'react';
import './App.css';

function App() {
  const [kogus, setKogus] = useState(0); // HTMLs esinevad muutujad peavad olema useState sees
  const [toiduained, setToiduained] = useState([]);
  const nimiRef = useRef();
  const valkRef = useRef();
  const rasvRef = useRef();
  const sysivesikRef = useRef();

  const [toidukomponendid, setToidukomponendid] = useState([])

  // Reacti hookid: use eesliidesega, neid peab importima. Reacti erikood
  // Springis annotatsioonid: @RestController, @GetMapping. neid peab importima. Springi erikood.

  // uef -> JS: onLoad()
  useEffect(() => {
    fetch("http://localhost:8080/api/toiduained")
      .then(response => response.json()) // koos metadataga (headerid, staatuskood, OK)
      .then(json => {
        setKogus(json.length);
        setToiduained(json);
      }) // body
  }, []);

  useEffect(() => {
    fetch("http://localhost:8080/toidukomponendid")
      .then(response => response.json())
      .then(json => {
        setToidukomponendid(json);
        //setToiduained(json);
      })
  }, []);

  function kustuta(primaarivoti) {
    fetch("http://localhost:8080/api/toiduained/" + primaarivoti, {"method": "DELETE"})
      .then(response => response.json()) 
      .then(json => {
        setKogus(json.length);
        setToiduained(json);
      })
  }

  function kustutaTK(primaarivoti) {
    fetch("http://localhost:8080/toidukomponendid/" + primaarivoti, {"method": "DELETE"})
      .then(response => response.json()) 
      .then(json => {
        setToidukomponendid(json);
      })
  }

  function lisa() {
    // document.getElemenyById("sad").value -> guugeldada see vs useRef
    if (nimiRef.current.value.trim() === "") {
      return;
    }
    const toiduaine = {
      "nimetus": nimiRef.current.value,
      "valk": valkRef.current.value,
      "rasv": rasvRef.current.value,
      "sysivesik": sysivesikRef.current.value
    }
    fetch("http://localhost:8080/api/toiduained", 
    {
      "method": "POST", 
      "body": JSON.stringify(toiduaine), 
      "headers": {"Content-Type": "application/json"}
    })
      .then(response => response.json()) 
      .then(json => {
        setKogus(json.length);
        setToiduained(json);
      })
  }

  const taNimiRef = useRef();
  const kogusRef = useRef();

  function lisaTK(){
    const lisatavTK = {
      "toiduaine": {"nimetus": taNimiRef.current.value},
      "kogus": kogusRef.current.value
    }
    fetch("http://localhost:8080/toidukomponendid", {
      "method": "POST", 
      "body": JSON.stringify(lisatavTK), 
      "headers": {"Content-Type": "application/json"}
    })
      .then(response => response.json()) 
      .then(json => {
        setToidukomponendid(json);
    })
  }

  return (
    <div className="App">
      Mul on {kogus} toiduainet
      <br /><br />
      
      <label>Toiduaine nimi</label> <br/>
      <input ref={nimiRef} type="text" /> <br />
      <label>Toiduaine valk</label> <br/>
      <input ref={valkRef} type="text" /> <br />
      <label>Toiduaine rasv</label> <br/>
      <input ref={rasvRef} type="text" /> <br />
      <label>Toiduaine süsivesik</label> <br/>
      <input ref={sysivesikRef} type="text" /> <br />
      <button onClick={() => lisa()}>Sisesta</button> <br />
      <br />

      {toiduained.map(t => <div>{t.nimetus} | {t.valk} | {t.rasv} | {t.sysivesik} <button onClick={() => kustuta(t.nimetus)}>x</button> </div> )}
      <hr />
      <label>Toiduaine nimi</label> <br/>
      <input ref={taNimiRef} type="text"></input><br/>
      <label>Toiduaine kogus</label> <br/>
      <input ref={kogusRef} type="text"></input><br/>
      <button onClick={() => lisaTK()}>Sisesta</button> <br />
      {toidukomponendid.map(tk => <div>{tk.toiduaine.nimetus} | {tk.kogus} <button onClick={() => kustutaTK(tk.id)}>x</button> </div> )}
    </div>
  );
}

export default App;