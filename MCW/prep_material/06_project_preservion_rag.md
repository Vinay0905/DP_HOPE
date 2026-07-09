# 🎙️ Multilingual RAG Voice Assistant — PreserVion (SIH Shortlist Top 16)

## 1. High-Level Summary (The "Elevator Pitch")
> **How to explain this to a non-domain interviewer:**
> "Imagine a customer enters a large store or a government office and wants to find something, but they only speak their local dialect, and the information is in English. 
> We built **PreserVion**, an AI voice assistant that talks to them in their local language (supporting 10 Indian languages). It listens to their speech, translates it, searches a private database of store layouts or catalog documents to find the correct answer (**Retrieval-Augmented Generation / RAG**), and speaks the answer back in their language. It can even negotiate pricing! We made sure the AI only gave factual answers from the database, preventing it from hallucinating or making things up."

---

## 2. In-Depth Technical Breakdown

### Key Concepts Explained Simpler:
*   **Retrieval-Augmented Generation (RAG):** Standard LLMs (like ChatGPT) can answer general questions but don't know your private files or catalog. RAG works in three steps:
    1.  *Retrieve*: When a user asks a question, we search our private database for matching documents.
    2.  *Augment*: We paste those documents alongside the user's question.
    3.  *Generate*: We send this combined text to the LLM. The LLM acts as a 'reader' and drafts an answer *only* using the provided documents.
*   **Vector Embeddings:** To search the database, we convert sentences into a list of numbers (embeddings) that represent their meaning. This allows us to search by concept (e.g., searching for "running shoes" will match "jogging sneakers" because their numerical vectors are close).
*   **Speech-to-Text (STT) & Text-to-Speech (TTS):** STT converts the customer's spoken words into written text. TTS converts the AI's written response back into a natural-sounding voice.

### The System Pipeline:
1.  **Audio Input:** User speaks in their native language (e.g., Telugu, Hindi, Tamil).
2.  **STT & Translation:** Used whisper models or local APIs to transcribe and translate the audio to English text.
3.  **Vector Search:** Queried a vector database (like Chroma or FAISS) using similarity search to pull relevant documentation.
4.  **RAG Generation:** Passed the documents and translated query to a fast LLM (like LLaMA-3 or Gemini) to generate a response.
5.  **Translation & TTS:** Translated the English response back to the user's language and synthesized it to audio.

---

## 3. "Why This? Why Not That?" (The Crucial Interview Questions)

### Q1. Why use RAG instead of fine-tuning the LLM on your private documents?
*   **Fine-Tuning Limitations:** Fine-tuning actually updates the neural network's weights. This has several drawbacks:
    *   *No Factual Guarantees*: Fine-tuned models can still hallucinate and combine facts in incorrect ways.
    *   *High Cost & Slow Updates*: If a product price or room location changes, you must re-train or fine-tune the model again, which is expensive and slow.
    *   *Lack of Traceability*: You cannot prove *which* document the LLM got its answer from.
*   **RAG Advantages (The Winner):** 
    *   *Instant Updates*: If a price changes, you just update the text file in the database. No retraining needed.
    *   *No Hallucinations*: You can instruct the LLM: *"If you do not find the answer in the retrieved text, say 'I don't know'."*
    *   *Traceability*: You can cite the exact source document to the user.

### Q2. How did you handle the latency of doing STT + Translation + RAG + TTS in a voice loop?
*   **The Latency Problem:** Running all these steps sequentially can take 5+ seconds, which makes a voice conversation feel awkward and laggy.
*   **Our Solutions:**
    *   *Streaming*: Instead of waiting for the LLM to finish writing the whole paragraph, we streamed the text output word-by-word into the translation and TTS modules.
    *   *Quantized Models*: Used 4-bit quantized local models running on consumer hardware to speed up inference times.
    *   *Fast Vector Search*: Used FAISS (Facebook AI Similarity Search) which runs search in microseconds using index indexing.

### Q3. Why use Vector Search instead of keyword search (like Ctrl+F / SQL LIKE)?
*   **Keyword Search Limitation:** If a customer asks, *"Do you have anything for a headache?"* and the document says *"Ibuprofen cures migraines,"* a keyword search fails because the words "headache" and "migraine/Ibuprofen" do not match.
*   **Vector Search Advantage:** It maps words into a high-dimensional vector space where semantic synonyms (like "headache" and "migraine") are mathematically close to each other. This allows the AI to understand user *intent* rather than just spelling.

---

## 4. MulticoreWare Connection
*   In-vehicle assistants, robotics, and interactive human-machine interfaces are major industrial tech spaces.
*   Understanding the math behind search, RAG pipelines, and optimization (latency reduction) shows you can solve real-world complex AI integration problems.
