# 🐟 Fish-Detection-YOLOv8 — Real-Time Aquatic Object Detection

## 1. High-Level Summary (The "Elevator Pitch")
> **How to explain this to a non-domain interviewer:**
> "If you take a camera underwater, images are green-tinted, dark, and blurry due to suspended particles and muddy water. Standard object detection fails because objects are obscured.
> **Fish-Detection-YOLOv8** is a computer vision project designed to detect and classify **26 different classes of fish and marine life** (like surgeonfishes, snappers, groupers, and sharks) in real time from video feeds. 
> To run on edge hardware (like underwater drones or webcams), I trained a custom **YOLOv8** model using a dataset hosted on Roboflow, and wrote an efficient inference engine using **OpenCV** and **FastAPI** to capture, process, and plot predictions on the fly at 30+ FPS."

---

## 2. In-Depth Technical Breakdown (Code Specifics)

### Core Components:
1.  **Dataset & Model Config (`data.yaml`):**
    *   *Dataset source*: Sourced from Roboflow (workspace: `roboflow-gw7yv`, project: `fish-yzfml`, version 1).
    *   *Classes (26 categories)*: Surgeonfishes, Triggerfishes, Jacks, Spadefishes, Wrasse, Snappers, Angelfishes, Damselfishes, Parrotfishes, Tunas, Groupers, Sharks, Moorish Idols, etc.
    *   *Model Variant*: Trained on **YOLOv8n** (Nano version, `yolov8n.pt` weights) to balance speed and accuracy on low-power devices.
2.  **Inference Engine (`fish.py`):**
    *   Uses **OpenCV** (`cv2.VideoCapture(0)`) to open a real-time webcam/camera stream.
    *   Runs frame-by-frame inference:
        ```python
        results = model(frame) # YOLOv8 model inference
        annotated_frame = results[0].plot() # Draws bounding boxes and class labels
        cv2.imshow("Fish Detection", annotated_frame) # Renders output window
        ```
    *   Includes keyboard listening (`cv2.waitKey(1) & 0xFF == ord('q')`) to release the camera resource and close OpenCV windows cleanly.
3.  **API Deployment (`api.py`):**
    *   FastAPI backend exposing a root endpoint (`/`) and a `/health` check endpoint, preparing the model to be hosted as a prediction web service.

---

## 3. "Why This? Why Not That?" (The Crucial Interview Questions)

### Q1. Why did you choose YOLOv8n (Nano) over YOLOv8x (Extra Large)?
*   **YOLOv8x Limitation:** The Extra Large variant has 68 million parameters and requires a high-end desktop GPU to run at real-time speeds. If you deploy it on an edge device (like a Raspberry Pi or an underwater drone's Nvidia Jetson Nano), the frame rate drops to $< 5$ FPS, which is useless for real-time tracking of moving fish.
*   **YOLOv8n Advantage:** The Nano variant has only 3.2 million parameters. It is highly optimized for speed and runs at 30+ FPS even on a standard CPU, while retaining sufficient accuracy for distinct fish species. For edge deployment, **inference latency** is more critical than a minor increase in mean Average Precision (mAP).

### Q2. How does YOLOv8's "Anchor-Free" design differ from YOLOv5's Anchor-Based design?
*   **Anchor-Based (YOLOv5):** Uses predefined bounding boxes (anchors) of fixed sizes. The model predicts the offset from these anchors. If the fish swims very close to the camera or has a long, unusual shape that doesn't match any anchor box, detection accuracy drops.
*   **Anchor-Free (YOLOv8):** Predicts the center of the object directly, along with the distance from the center to the four edges of the box. This makes the model faster (less post-processing like Non-Maximum Suppression) and much better at generalizing to objects of arbitrary shapes and sizes (e.g., long eels vs. round puffers).

### Q3. Why did you use Roboflow for dataset management?
*   **Version Control & Formats:** Roboflow allows us to version our dataset. If we add new images or augment existing ones (e.g., adding brightness or contrast adjustments), we can export a new version instantly. It also handles auto-formatting, outputting the exact `data.yaml` and annotation folder structure required by the Ultralytics training engine, saving hours of manual data-formatting script writing.

---

## 4. MulticoreWare Connection
*   MulticoreWare works on **embedded computer vision** and **real-time video analytics**. They specialize in accelerating video decoding pipelines (like x265) and neural network inference (OpenCV, ONNX, TensorRT).
*   Your project shows that you know how to build a complete real-time video analytics pipeline using OpenCV, and how to choose and configure models (like YOLOv8n) with deployment performance in mind.
