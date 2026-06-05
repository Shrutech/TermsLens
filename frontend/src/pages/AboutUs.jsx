import "./AboutUs.css";

export default function AboutUs() {
  return (
    <div className="about-page">
      <section className="about-hero">
        <p className="about-eyebrow">ABOUT TERMLENS</p>
      </section>

      <section className="mission-section">
        <div className="mission-card">
          <h2>Our Mission</h2>

          <p>
            We believe understanding your rights should never require a law
            degree. TermLens transforms lengthy agreements into clear insights,
            helping users identify risks, obligations, and important clauses
            before agreeing to them.
          </p>
        </div>

        <div className="mission-card">
          <h2>Why We Built It</h2>

          <p>
            Terms & Conditions are often intentionally dense, lengthy, and
            difficult to navigate. Important details about privacy, payments,
            ownership, and legal rights can easily be missed. We wanted a faster
            and more transparent way to uncover them.
          </p>
        </div>
      </section>

      <section className="values-section">
        <h2 className="section-heading">What drives us</h2>

        <div className="values-grid">
          <div className="value-card">
            <span>01</span>
            <h3>Transparency</h3>
            <p>Legal documents should be understandable, not intimidating.</p>
          </div>

          <div className="value-card">
            <span>02</span>
            <h3>Accessibility</h3>
            <p>
              Everyone deserves access to clear explanations of legal terms.
            </p>
          </div>

          <div className="value-card">
            <span>03</span>
            <h3>Trust</h3>
            <p>Users should know exactly what they are agreeing to.</p>
          </div>
        </div>
      </section>

      <section className="quote-section">
        <blockquote>
          “The most important agreements in our lives are often the least read.”
        </blockquote>
      </section>

      <section className="journey-section">
        <div className="journey-line"></div>

        <div className="journey-item">
          <div className="journey-dot"></div>

          <div>
            <h3>The Problem</h3>
            <p>Thousands of words. Hidden clauses. Little time.</p>
          </div>
        </div>

        <div className="journey-item">
          <div className="journey-dot"></div>

          <div>
            <h3>The Idea</h3>
            <p>Use AI to convert legal complexity into actionable clarity.</p>
          </div>
        </div>

        <div className="journey-item">
          <div className="journey-dot"></div>

          <div>
            <h3>The Goal</h3>
            <p>Help people make informed choices before clicking “I Agree”.</p>
          </div>
        </div>
      </section>

      <section className="closing-section">
        <h2>
          Clarity is a right,
          <br />
          not a privilege.
        </h2>

        <p>
          We are building tools that help people understand agreements, protect
          their interests, and make better decisions online.
        </p>
      </section>

      <footer className="made-by">
        Made with <span className="heart">♥</span> by Shruti
      </footer>
    </div>
  );
}
