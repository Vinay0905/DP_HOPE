# 🏡 Housing Regression MLE — End-to-End MLOps Ecosystem

## 1. High-Level Summary (The "Elevator Pitch")
> **How to explain this to a non-domain interviewer:**
> "Usually, Machine Learning models are just scripts on a laptop. I built **Housing Regression MLE**, a complete production-grade MLOps system that predicts housing prices. 
> It automates data ingestion, processes raw data into features, trains an optimized **XGBoost** model using **Optuna** for Bayesian parameter tuning, tracks every experiment in **MLflow**, and stores the trained models in **Supabase**. Finally, it's containerized with **Docker** and deployed on **Google Cloud Run** with a **FastAPI** backend and an interactive **Streamlit** dashboard, featuring auto-scaling to zero to save costs."

---

## 2. In-Depth Technical Breakdown (Code Specifics)

### System Pipelines (`src/`):
1.  **Feature Pipeline (`src/feature_pipeline/`):**
    *   *Loading & Preprocessing (`load.py`, `preprocess.py`)*: Cleans raw real estate records and structures them.
    *   *Feature Engineering (`feature_engineering.py`)*: 
        *   **Date Features**: Extracts `year`, `quarter`, and `month` from the raw `date` column.
        *   **Frequency Encoding**: Encodes high-cardinality `zipcode` based on occurrences in the training set (saved as `models/freq_encoder.pkl`).
        *   **Target Encoding**: Replaces `city_full` with the mean target value (`price`) using `category_encoders.TargetEncoder` (saved as `models/target_encoder.pkl`).
        *   **Data Leakage Prevention**: Drops raw categorical and leak-prone columns (`date`, `city_full`, `city`, `zipcode`, `median_sale_price`) once encoded.
2.  **Training & Tuning Pipeline (`src/training_pipeline/`):**
    *   Trains **XGBoost** regressor.
    *   Uses **Optuna** to run Bayesian Optimization (TPE sampler) to tune hyperparameters.
    *   Logs params, metrics, and models to **MLflow**. Saves serialized model artifacts and encoders to **Supabase Storage**.
3.  **Inference Pipeline (`src/inference_pipeline/`):**
    *   Loads models/encoders dynamically from Supabase at runtime to serve predictions.
4.  **API & Dashboard (`src/api/`, `app.py`):**
    *   *FastAPI backend*: High-performance asynchronous endpoint (`/health`, `/predict`) returning JSON responses.
    *   *Streamlit frontend*: Sleek user interface for inputting house details and visualizing pricing predictions.
5.  **Environment Management**:
    *   Managed using `uv` (a modern Rust-based Python package installer), ensuring rapid, reproducible dependency tree syncs via `uv.lock`.

---

## 3. "Why This? Why Not That?" (The Crucial Interview Questions)

### Q1. Why did you split the data chronologically instead of a random train/test split?
*   **The Leakage Problem:** Real estate prices change over time due to inflation and market trends. If we use a random split (e.g., `train_test_split` from scikit-learn), the model might train on data from 2026 and test on data from 2024. In the real world, we cannot predict the past using the future; this creates **temporal data leakage**, artificially inflating test accuracy.
*   **The Chronological Split Solution:** We strictly split data by time (e.g., training on historical data and validating on the most recent months). This simulates the actual deployment scenario, proving the model can generalize to future housing markets.

### Q2. Why did you use Target Encoding for `city_full` instead of One-Hot Encoding?
*   **One-Hot Encoding Limitation:** One-hot encoding creates a binary column ($0$ or $1$) for every unique city. If there are 500 unique cities, it adds 500 columns to the dataset. For decision trees, this high dimensionality leads to sparse matrices, increases memory usage, and slows down training.
*   **Target Encoding Advantage:** Target encoding replaces each city string with the average house price of that city in the training set. It captures the entire categorical relationship in a **single numerical column**, saving memory and accelerating XGBoost tree splits. We prevent target leakage by fitting the encoder *only* on the training set and transforming the validation set.

### Q3. Why use `uv` and Docker for environment management?
*   **`uv` vs. Standard `pip`:** `pip` resolves dependencies sequentially, which is slow and prone to package version conflicts. `uv` is written in Rust and resolves dependencies in parallel, completing setup in seconds. It also guarantees deterministic environments through a lockfile (`uv.lock`).
*   **Docker vs. Bare Metal:** Deploying a Python app directly on a server often breaks due to "works on my machine" issues (different OS versions, missing system libraries). Docker bundles the exact OS, Python runtime, and libraries into a static image, ensuring identical behavior in local testing and production GCP environments.

---

## 4. MulticoreWare Connection
*   MulticoreWare designs enterprise software pipelines. Your use of a modular architecture (`feature_pipeline`, `training_pipeline`, `inference_pipeline`) shows strong software engineering discipline.
*   Your containerization (Docker) and deployment optimization (GCP Cloud Run auto-scaling) demonstrate that you build code with system resources, performance, and scaling in mind.
