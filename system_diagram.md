# Plagiarism Detection System Architecture

## Pipeline Overview

<div style="text-align: center;">

              ┌────────────────────┐
              │   Raw Submissions  │ ← **Input**: 200-1000 codes
              │   (200–1000 codes) │
              └─────────┬──────────┘
                        │
                        ▼
      ┌────────────────────────────────┐
      │  **Canonicalization Layer**    │ ← **Normalize** comments, IDs, AST
      │  - Remove comments              │
      │  - Normalize formatting         │
      │  - Rename identifiers           │
      │  - AST normalization            │
      └─────────┬──────────────────────┘
                │
                ▼
    ┌───────────────────────────────────────┐
    │ **Level 1–3 Filter** (Fast)          │ ← **Hash-based filtering**
    │ - Hashing / Token hashing              │   (eliminates 80-90% trivial cases)
    │ - Exact & near-exact matches           │
    └─────────┬─────────────────────────────┘
            │ (non-trivial only)
            ▼
    ┌───────────────────────────────────────┐
    │ **GraphCodeBERT Embedding**           │ ← **Semantic representation**
    │ Code → Semantic Vector (768-d)         │
    └─────────┬─────────────────────────────┘
            │
            ▼
    ┌───────────────────────────────────────┐
    │ **Vector Search / Clustering**        │ ← **Find similar solutions**
    │ - Top-K neighbors                     │
    │ - DBSCAN / threshold grouping          │
    └─────────┬─────────────────────────────┘
            │
            ▼
    ┌───────────────────────────────────────┐
    │ **Suspicious Clusters**               │ ← **Group similar submissions**
    │ (High intra-cluster similarity)       │
    └─────────┬─────────────────────────────┘
            │
            ▼
    ┌───────────────────────────────────────┐
    │ **PLBART Explanation Layer**          │ ← **Human-readable analysis**
    │ - Semantic reasoning                   │
    │ - Human-readable comparison            │
    └─────────┬─────────────────────────────┘
            │
            ▼
    ┌───────────────────────────────────────┐
    │ **Final Decision Engine**             │ ← **Output**: Scores + Reports
    │ - Similarity score                     │
    │ - Likely plagiarism level (1–12)       │
    │ - Explanation report                   │
    └───────────────────────────────────────┘
</div>