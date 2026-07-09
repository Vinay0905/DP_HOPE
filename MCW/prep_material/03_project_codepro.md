# 🕵️‍♂️ Plagiarism Detection System — CODEPRO

## 1. High-Level Summary (The "Elevator Pitch")
> **How to explain this to a non-domain interviewer:**
> "When students submit coding assignments, some try to cheat by doing 'lazy plagiarism'—changing variable names, adding comments, or swapping spaces. Standard text comparison fails here.
> **CodePro** is a tool written in Python that strips away these superficial changes (comments, spaces, variable names) to get the core logic of the code (normalization). It then cuts the code into small pieces (k-grams), converts these pieces into unique numbers using a fast math trick (Rabin-Karp rolling hashing with base 101 and modulus $10^9+9$), and selects a smart subset of these numbers (Winnowing algorithm) to create a 'fingerprint' of the submission. We then compare these fingerprints using Jaccard Similarity. It's like comparing the DNA of two programs rather than just their appearance."

---

## 2. In-Depth Technical Breakdown (Code Specifics)

### Key Concepts Explained Simpler:
*   **Normalization (`utils/normalize.py`):** Exposes the structural skeleton of the code:
    1.  *Comment Removal*: Uses regex to strip Python comments (`#`) and C/C++/Java comments (`//` and `/* */`).
    2.  *Whitespace Normalization*: Collapses multiple spaces and newlines.
    3.  *Tokenization*: Uses `re.findall` to extract identifiers, numbers, operators, and punctuation.
    4.  *Identifier Mapping*: Replaces custom variable/function names sequentially with `VAR0`, `VAR1`, `VAR2`, etc.
    5.  *Type/Literal Replacement*: Maps standard type keywords (like `int`, `str`, `double`) to `TYPE` and numbers to `NUM`.
    6.  *Keyword Preservation*: Keeps language keywords (like `if`, `for`, `while`, `return`) in lowercase.
*   **Rabin-Karp Rolling Hash (`utils/winnow.py`):** Computes hashes of sliding k-grams.
    *   *Base & Modulus*: Uses a base of $101$ and a modulus of $10^9 + 9$.
    *   *Rolling Formula*: To move the window right by 1 character, it removes the leftmost character and adds the rightmost in $O(1)$ constant time:
        $$H_{\text{new}} = ((H_{\text{old}} - \text{char}_{\text{removed}} \cdot b^{k-1}) \cdot b + \text{char}_{\text{added}}) \pmod m$$
*   **Winnowing (`utils/winnow.py`):** Slides a window of size $w$ over the list of hashes and selects the minimum hash value (and its position) in each window. Deduplicates using a Python `set`.
*   **Jaccard Similarity:** Compares two fingerprint sets:
    $$\text{Similarity} = \frac{|A \cap B|}{|A \cup B|}$$

### Project Architecture:
*   **Backend (`app.py` & `api/`):** A modular Python pipeline that loads files from CSV, fingerprints them, computes pairwise similarities, and logs results.
*   **Infrastructure:** Containerized using **Docker** (`Dockerfile.api`, `Dockerfile.ui`, `docker-compose.yml`) for separate API and UI microservices.

---

## 3. "Why This? Why Not That?" (The Crucial Interview Questions)

### Q1. Why did you use Rabin-Karp hashing instead of standard hashing (like MD5 or SHA-256)?
*   **Standard Hash Limitation:** If we want to check all substrings of length $k$, calculating a standard hash like MD5 for every substring of a file of size $N$ requires re-reading $k$ characters each time, taking $O(N \cdot k)$ time. This is extremely slow.
*   **Rabin-Karp Rolling Hash Advantage:** Rabin-Karp uses a polynomial rolling hash. When the window slides, the new hash is computed in $O(1)$ constant time using the previous hash value. Thus, hashing the entire file takes only $O(N)$ linear time.

### Q2. Why did you use the Winnowing algorithm instead of just comparing all k-gram hashes?
*   **Storage and Speed:** A file of 1,000 characters has about 1,000 k-grams. Comparing every single hash results in $O(N^2)$ comparisons for plagiarism checks, which is too slow.
*   **Winnowing Guarantee:** Winnowing reduces the number of hashes we store (by a factor of $w/2$ on average) while providing a mathematical guarantee: **if two files share a substring of length $\ge w + k - 1$, they are guaranteed to match on at least one fingerprint.** It discards noise while preserving the critical matches.

### Q3. How does your normalization handle different programming languages?
*   **Unified Normalization:** The system implements a unified regex-based tokenizer that handles common characteristics of C-like languages (Python, C++, Java, JS). It maps keywords and types to unified lists (`KEYWORDS`, `TYPES`), making it multi-language compatible.
*   **Alternative (AST):** A more advanced method is comparing Abstract Syntax Trees (ASTs), which builds a syntax tree of the code. While more robust to structural changes (like converting a `for` to a `while` loop), AST parsing is language-specific, requires a compiler front-end for every supported language, and is computationally slower than rolling hashes.

---

## 4. MulticoreWare Connection
*   MulticoreWare works heavily on **compilers** (LLVM front-ends and back-ends). Code normalization, lexical analysis (tokenization), and string matching are fundamental compiler design concepts.
*   Your project shows strong capabilities in **data structures and algorithms (DSA)**, rolling hash functions, and optimization.
