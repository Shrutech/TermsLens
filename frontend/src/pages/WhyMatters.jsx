import "./WhyMatters.css";

export default function WhyMatters() {
  return (
    <div className="why-page">

      <section className="why-hero">

        <p className="why-eyebrow">
          WHY IT MATTERS
        </p>

        <h1>
          Every click on
          <br />
          “I Agree” is a decision.
        </h1>

        <p className="why-intro">
          Most people spend hours researching products but only seconds
          accepting the legal agreements that govern them. Hidden inside
          those documents can be clauses affecting your privacy, money,
          content ownership, and legal rights.
        </p>

      </section>

      <section className="story-grid">

        <div className="story-card reveal-card">
          <span className="story-number">01</span>
          <h2>Your Data Has Value</h2>
          <p>
            Terms often determine who can collect, store, analyze,
            sell, or share your information. What appears to be a simple
            signup can authorize years of data collection.
          </p>
        </div>

        <div className="story-card reveal-card">
          <span className="story-number">02</span>
          <h2>Your Rights Can Change</h2>
          <p>
            Some agreements allow unilateral updates without notice.
            The rules you accepted today may not be the same tomorrow.
          </p>
        </div>

        <div className="story-card reveal-card">
          <span className="story-number">03</span>
          <h2>Your Content May Not Stay Yours</h2>
          <p>
            Photos, posts, reviews, documents, and creative work can
            sometimes be licensed broadly, giving companies rights far
            beyond what users expect.
          </p>
        </div>

      </section>

      <section className="impact-section">

        <div className="impact-panel">
          <div className="impact-value">91%</div>
          <p className="impact-text">
            of users accept terms without reading them.
          </p>
        </div>

        <div className="impact-panel">
          <div className="impact-value">Thousands</div>
          <p className="impact-text">
            of words can hide a single clause that changes everything.
          </p>
        </div>

      </section>

      <section className="timeline-section">

        <h2>What happens when terms are ignored?</h2>

        <div className="timeline">

          <div className="timeline-item">
            <div className="timeline-dot"></div>
            <div>
              <h3>Sign Up</h3>
              <p>Users accept lengthy legal agreements.</p>
            </div>
          </div>

          <div className="timeline-item">
            <div className="timeline-dot"></div>
            <div>
              <h3>Data Collection</h3>
              <p>Information begins to accumulate.</p>
            </div>
          </div>

          <div className="timeline-item">
            <div className="timeline-dot"></div>
            <div>
              <h3>Unexpected Clause</h3>
              <p>A hidden condition eventually becomes relevant.</p>
            </div>
          </div>

          <div className="timeline-item">
            <div className="timeline-dot"></div>
            <div>
              <h3>Consequences</h3>
              <p>Loss of privacy, content ownership, refunds, or rights.</p>
            </div>
          </div>

        </div>

      </section>

      <section className="closing-panel">

        <h2>
          Understanding terms isn't paranoia.
          <br />
          It's informed consent.
        </h2>

        <p>
          TermLens exists to transform dense legal documents into clear,
          understandable insights so users can make confident decisions.
        </p>

      </section>

    </div>
  );
}