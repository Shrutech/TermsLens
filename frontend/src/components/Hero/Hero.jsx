import "./Hero.css";
import { useState, useRef } from "react";
import { useNavigate } from "react-router-dom";
import { analyzeText, analyzeImage } from "../../services/analysisService";

export default function Hero() {
  const [mode, setMode] = useState("text");
  const [text, setText] = useState("");
  const fileRef = useRef(null);
  const navigate = useNavigate();
  const openFile = () => {
    fileRef.current?.click();
  };
  const [selectedFile, setSelectedFile] = useState(null);
  const [loading, setLoading] = useState(false);
  const handleAnalyze = async () => {
    try {
      setLoading(true);

      let result;

      if (mode === "text") {
        result = await analyzeText(text);
      } else {
        if (!selectedFile) {
          alert("Please upload an image");
          return;
        }

        result = await analyzeImage(selectedFile);
      }
      console.log("API RESULT:", result);
      navigate("/report", {
        state: {
          report: result,
        },
      });
    } catch (error) {
      console.error(error);
      alert("Analysis failed");
    } finally {
      setLoading(false);
    }
  };

  return (
    <section id="hero" className="hero-section">
      {/* LEFT */}
      <div className="hero-left">
        <p className="eyebrow">AI LEGAL FORENSICS</p>

        <h1>
          Clarity for the
          <br />
          fine print.
        </h1>

        <p className="lede">
          Upload any policy, contract, or privacy notice and get a precise,
          plain-language review with risks, urgent flags, and recommendations.
        </p>

        <div className="hero-actions">
          <button className="btn-outline" onClick={() => setMode("image")}>
            ⬆ Upload Image
          </button>

          <button className="btn-outline" onClick={() => setMode("text")}>
            📄 Paste Text
          </button>
        </div>

        <input
          type="file"
          ref={fileRef}
          style={{ display: "none" }}
          accept="image/*"
          onChange={(e) => {
            if (e.target.files[0]) {
              setSelectedFile(e.target.files[0]);
            }
          }}
        />
      </div>

      {/* RIGHT */}
      <div className="hero-right">
        <div className="card">
          <div className="card-label">
            {mode === "text" ? "PASTE AGREEMENT" : "UPLOAD IMAGE"}
          </div>

          {mode === "text" && (
            <textarea
              className="textarea"
              placeholder="Paste the full text of the Terms & Conditions here..."
              value={text}
              onChange={(e) => setText(e.target.value)}
            />
          )}

          {mode === "image" && (
            <div
              className="image-upload-box"
              onClick={() => {
                if (!selectedFile) {
                  openFile();
                }
              }}
            >
              {selectedFile ? (
                <>
                  <img
                    src={URL.createObjectURL(selectedFile)}
                    alt="preview"
                    className="preview-image"
                  />
                  <p>{selectedFile.name}</p>
                </>
              ) : (
                "Click here to upload image"
              )}
            </div>
          )}

          <div className="card-footer">
            <div className="status">
              <span className="dot"></span>
              READY FOR INPUT
            </div>

            <div className="footer-actions">
              {mode === "image" && selectedFile && (
                <button
                  className="analyze-btn secondary-btn"
                  onClick={openFile}
                >
                  Change Image
                </button>
              )}

              <button
                className="analyze-btn"
                onClick={handleAnalyze}
                disabled={loading}
              >
                {loading ? "Analyzing..." : "Analyze →"}
              </button>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
}
