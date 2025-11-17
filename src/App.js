import React, { useState } from "react";
import axios from "axios";
import "./App.css";

function App() {
  const [symptom, setSymptom] = useState("");
  const [symptomsList, setSymptomsList] = useState([]);
  const [result, setResult] = useState("");

  const addSymptom = () => {
    if (symptom.trim() !== "") {
      setSymptomsList([...symptomsList, symptom.trim()]);
      setSymptom("");
    }
  };

  const removeSymptom = (index) => {
    const newList = symptomsList.filter((_, i) => i !== index);
    setSymptomsList(newList);
  };

  const analyzeSymptoms = async () => {
    if (symptomsList.length === 0) {
      alert("कृपया किमान एक तरी symptom add करा.");
      return;
    }

    try {
      const response = await axios.post("http://localhost:8080/api/health/check", {
        symptoms: symptomsList
      });
      setResult(response.data);
    } catch (error) {
      console.error(error);
      setResult("Server error. Try again");
    }
  };

  return (
    <div className="container">
      <h1 className="title">Health Symptom Checker</h1>

      <div className="input-group">
        <input
          className="input"
          type="text"
          placeholder="Symptom type ..."
          value={symptom}
          onChange={(e) => setSymptom(e.target.value)}
        />
        <button className="button add" onClick={addSymptom}>
          Add Symptom
        </button>
      </div>

      <div className="symptoms-list">
        {symptomsList.map((s, index) => (
          <div key={index} className="symptom-chip">
            {s} <span className="remove" onClick={() => removeSymptom(index)}>×</span>
          </div>
        ))}
      </div>

      <button className="button analyze" onClick={analyzeSymptoms}>
        Analyze Symptoms
      </button>

      {result && (
        <div className="result-card">
          <h2>Result:</h2>
          <p>{result}</p>
        </div>
      )}
    </div>
  );
}

export default App;
