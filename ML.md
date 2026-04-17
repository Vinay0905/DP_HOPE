# Semantic Code Plagiarism Detection System

## Overview
This system detects code plagiarism by combining
deterministic program analysis with modern AI models.
It is designed for scalable evaluation of 200–1000
submissions per problem on coding platforms.

---

## Key Idea
Plagiarism detection is treated as a **clustering problem**,
not a pairwise comparison problem.

Submissions with unusually high semantic similarity
relative to peers are flagged for further analysis.

---

## Plagiarism Levels
The system supports 12 plagiarism levels, ranging from
exact copies to deep semantic rewrites, including:
- Identifier renaming
- Statement reordering
- Control structure replacement
- Algebraic equivalence

---

## Architecture
1. Canonicalize code (AST-based normalization)
2. Fast filtering for trivial plagiarism (Levels 1–3)
3. Semantic embedding using GraphCodeBERT
4. Vector clustering for similarity detection
5. Deep explanation using PLBART
6. Final decision with score + explanation

---

## Models Used

### GraphCodeBERT
- Purpose: Retrieval & similarity detection
- Strengths:
  - Robust to renaming and reordering
  - Captures structural semantics
- Used for:
  - Levels 4–7
  - Candidate generation for deeper analysis

### PLBART
- Purpose: Explanation & semantic reasoning
- Strengths:
  - Natural language explanations
  - Code-to-code reasoning
- Used for:
  - Levels 8–12
  - Human-readable reports

---

## Scalability
- Embedding: O(N)
- Retrieval: O(N log N)
- Explanation: Only for flagged clusters

The system avoids quadratic comparisons.

---

## Output
Each flagged case includes:
- Similarity score
- Likely plagiarism level
- Natural-language explanation
- Supporting evidence

---

## Important Notes
- High similarity alone does not imply plagiarism
- Context and peer distribution matter
- Final decisions should support human review

---

## Future Extensions
- Execution trace comparison
- Cross-language plagiarism
- Model fine-tuning on domain-specific datasets
