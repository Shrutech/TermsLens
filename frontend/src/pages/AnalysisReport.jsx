import "./AnalysisReport.css";
import { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";

export default function AnalysisReport() {
  const location = useLocation();

  const data = location.state?.report;
  console.log("LOCATION:", location);
  console.log("REPORT DATA:", data);
  if (!data) {
    return (
      <div className="report-page">
        <h2>No analysis data found.</h2>
      </div>
    );
  }
  const [progress, setProgress] = useState(0);

  useEffect(() => {
    setTimeout(() => setProgress(data.riskScore), 300);
  }, []);

  return (
    <div className="report-page">
      <div className="report-container">
        {/* HEADER */}
        <div className="report-header">
          <p className="eyebrow">ANALYSIS REPORT</p>
          <h1>Before You Agree :— Terms of Service</h1>
        </div>

        {/* TOP SECTION */}
        <div className="top-grid">
          {/* LEFT SIDE */}
          <div className="card summary-card">
            <div className="left-top">
              <div className="circle-box">
                <svg viewBox="0 0 36 36" className="circle">
                  <path
                    className="circle-bg"
                    d="
    M18 2.0845
    a 15.9155 15.9155 0 0 1 0 31.831
    a 15.9155 15.9155 0 0 1 0 -31.831
  "
                  />

                  <path
                    className="circle-progress"
                    strokeDasharray={`${progress}, 100`}
                    d="
    M18 2.0845
    a 15.9155 15.9155 0 0 1 0 31.831
    a 15.9155 15.9155 0 0 1 0 -31.831
  "
                  />
                </svg>

                <div className="circle-center">
                  <div className="score">{data.riskScore}</div>
                  <div className="label">RISK SCORE</div>
                </div>
              </div>

              <div className="summary-box">
                <h3>SUMMARY</h3>

                <p>{data.summary}</p>

                <div className="recommendation-box">
                  <span>Recommendation:</span>
                  <strong>{data.recommendation}</strong>
                </div>
              </div>
            </div>
          </div>

          {/* RIGHT SIDE - ONLY CARD */}
          <div className="card redflags">
            <h3>RED FLAGS</h3>

            {data.redFlags.map((f, i) => (
              <div key={i} className="flag-card">
                <span className="red-dot"></span>
                <span className="flag-text">{f}</span>
              </div>
            ))}
          </div>
        </div>

        {/* SCENARIOS */}
        <div className="grid-3">
          <div className="card">
            <h3>BEST CASE</h3>
            <p>{data.bestCaseScenario}</p>
          </div>

          <div className="card">
            <h3>REALISTIC</h3>
            <p>{data.realisticScenario}</p>
          </div>

          <div className="card">
            <h3>WORST CASE</h3>
            <p>{data.worstCaseScenario}</p>
          </div>
        </div>

        {/* RISKS - SUB CARD SYSTEM */}
        <div className="risk-section">
          <h2 className="section-title">CRITICAL RISK ANALYSIS</h2>

          <div className="risk-cards">
            {data.mainRisks.map((r, i) => (
              <div key={i} className="risk-card">
                <div className="risk-eyebrow">Risk {i + 1}</div>
                <div className="risk-body">
                  {r.includes(":") ? r.split(":")[1] : r}
                </div>
              </div>
            ))}
          </div>
        </div>

        {/* BREAKDOWN */}
        <div className="grid-2">
          <div className="card">
            <h3>RISK BREAKDOWN</h3>

            {Object.entries(data.riskBreakdown).map(([k, v], i) => (
              <div key={i} className="row">
                <span>{k}</span>
                <div className="bar">
                  <div className="fill" style={{ width: `${v}%` }} />
                </div>
                <span>{v}%</span>
              </div>
            ))}
          </div>

          <div className="card">
            <h3>NUTRITION LABEL</h3>

            {Object.entries(data.nutritionLabel).map(([k, v], i) => (
              <div key={i} className="row">
                <span>{k}</span>
                <div className="bar">
                  <div className="fill orange" style={{ width: `${v}%` }} />
                </div>
                <span>{v}%</span>
              </div>
            ))}
          </div>
        </div>

        {/* EXEC */}
        <div className="verdict-section">
          <div className="verdict-flip-card">
            <div className="verdict-flip-inner">
              <div className="verdict-front">
                <h2>VERDICT</h2>
                <p>Hover to reveal</p>
              </div>

              <div className="verdict-back">
                <div className="verdict-result">
                  {data.riskScore < 30
                    ? "SAFE TO ACCEPT"
                    : data.riskScore < 60
                      ? "PROCEED WITH CAUTION"
                      : "HIGH RISK — REVIEW CAREFULLY"}
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
