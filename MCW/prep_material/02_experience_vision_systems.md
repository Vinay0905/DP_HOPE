# 👁️ Vision Systems Intern — Spheruler Solutions (Mar 2025 – May 2025)

## 1. High-Level Summary (The "Elevator Pitch")
> **How to explain this to a non-domain interviewer:**
> "If you attach a camera to a helicopter or a drone and want to use it to aim a laser or a sensor at a target miles away, the camera and the laser pointer must be perfectly aligned. If they are misaligned by even a fraction of a millimeter, they will miss by meters over long distances. This alignment is called **boresight alignment**. 
> To align them, we first need to know exactly how the camera's lens distorts the image (its **intrinsic parameters**) and where the camera is physically mounted relative to the laser (its **extrinsic parameters**). I worked on the software that calibrates these parameters, reducing the targeting error by 3 times (from 0.15 to 0.05 reprojection pixels)."

---

## 2. In-Depth Technical Breakdown

### Key Concepts Explained Simpler:
*   **Camera Calibration:** A camera sensor is flat, but a camera lens is curved. This lens bends light, causing distortion (e.g., straight lines look curved at the edges). Calibration is the mathematical process of finding the numbers that let us "undo" this lens distortion.
*   **Intrinsic Parameters:** Internal characteristics of the camera itself. Examples: Focal length ($f_x, f_y$), optical center ($c_x, c_y$), and radial/tangential distortion coefficients. These do not change when the camera moves.
*   **Extrinsic Parameters:** External position characteristics. They describe the rotation ($R$) and translation ($T$) of the camera relative to a world coordinate system (e.g., the base of the vehicle it is mounted on).
*   **Reprojection Error:** Think of this as the 'reality check'. We take a 3D point in the real world, map it mathematically to where it should appear on our 2D camera image, and compare it to where it *actually* appears in the picture. The distance between the predicted spot and the actual spot (in pixels) is the reprojection error. Lower is better.

### What You Actually Did (The Calibration Process):
1.  **Pattern Capture:** Captured multiple high-resolution images of a calibration target (like a chessboard or CharuCo board) from different angles.
2.  **Corner Detection:** Used OpenCV's corner detection algorithms (like `findChessboardCorners` or CharuCo detection) to find the 2D coordinates of the grid intersections.
3.  **Optimization:** Fed these 2D image coordinates and their corresponding 3D physical coordinates into the **Levenberg-Marquardt optimizer** (`calibrateCamera` in OpenCV) to solve for the intrinsic matrix ($K$) and distortion coefficients.
4.  **Error Reduction:** The initial error was 0.15 pixels because of bad pattern detection in low-light and poor angle diversity. I optimized the process by:
    *   Implementing **sub-pixel corner refinement** (`cornerSubPix`), which uses image intensity gradients to locate corners with fractional-pixel accuracy.
    *   Filtering out bad frames where the board was at extreme, highly distorted angles.
    *   Swapping the standard chessboard for a **CharuCo board** (chessboard + ArUco markers), which allows calibration even if the board is partially blocked or out of frame.
    *   This reduced the reprojection error to **0.05 pixels**, a 3× improvement in calibration quality.

---

## 3. "Why This? Why Not That?" (The Crucial Interview Questions)

### Q1. Why use a CharuCo board instead of a standard Chessboard or ArUco board?
*   **Standard Chessboard Limitations:** If even a single corner of a standard chessboard is blocked by a shadow, out of the frame, or blurry, the entire image becomes useless for calibration because the grid finder cannot establish the coordinate system.
*   **ArUco Board Limitations:** ArUco markers are single square codes. While robust to occlusion, their corner detection is not as mathematically precise as the checkerboard intersections.
*   **CharuCo Board (The Winner):** It combines the robustness of ArUco (if part of the board is blocked, we can still identify which checkers are visible because of the local ArUco markers) with the high mathematical precision of chessboard corner detection. This meant we could capture data at extreme angles near the lens edges where distortion is highest, without losing the frame.

### Q2. Why does sub-pixel refinement (`cornerSubPix`) matter so much?
*   **The Problem:** Normal corner detection finds corners at discrete pixel coordinates (e.g., $(340, 210)$). But a corner might actually be at $(340.23, 209.87)$. Over multiple frames and distance projection, these rounding errors accumulate, raising our reprojection error.
*   **The Solution:** `cornerSubPix` uses the mathematical properties of corners. At a perfect corner, the dot product of the image gradient and the vector from the corner to the neighborhood is zero. By running an iterative search based on this mathematical constraint, we get sub-pixel coordinates, drastically increasing precision.

### Q3. Why did you optimize for Reprojection Error? Are there other metrics?
*   **Why Reprojection Error:** It is the standard metric because it directly represents how well our mathematical camera model matches physical reality in terms of pixels. A lower reprojection error guarantees that a pixel coordinate on the screen translates accurately to a physical vector in the real world.
*   **Other Metrics:** We also monitored the **variance of the focal length** across multiple calibration runs. If the reprojection error is low but the estimated focal length varies widely between test runs, the calibration is unstable (overfitted).

---

## 4. MulticoreWare Connection
*   MulticoreWare works extensively in the **automotive (ADAS) and autonomous systems** space, where multi-camera calibration is a critical prerequisite for depth estimation, lane detection, and sensor fusion.
*   Your experience with intrinsic/extrinsic parameters, camera matrices, and OpenCV optimization translates directly to their core CV and robotics workflows.
