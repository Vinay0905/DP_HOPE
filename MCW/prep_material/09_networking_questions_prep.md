# 🌐 Computer Networking Interview Guide

This guide condenses the core computer networking concepts from the reference PDF, explained in plain language for engineering interviews.

---

## 1. Network Architectures & Models

### Q1. What is the OSI Model? Explain the 7 Layers Simply.
The OSI (Open Systems Interconnection) model is a conceptual framework that standardizes how different computer systems communicate over a network. It splits communication into 7 distinct layers:

1.  **Physical Layer (Bit Level):** Transmits raw, unstructured data bits over a physical medium (copper wires, fiber optics, radio waves).
2.  **Data Link Layer (Frame Level):** Packages bits into **frames** and handles node-to-node delivery. Detects and corrects physical layer errors. (Protocols: Ethernet, Wi-Fi).
3.  **Network Layer (Packet Level):** Responsible for routing packets across different networks. It translates physical addresses to logical IP addresses. (Protocols: IP, ICMP).
4.  **Transport Layer (Segment Level):** Ensures reliable end-to-end data transfer, flow control, and error recovery. (Protocols: TCP, UDP).
5.  **Session Layer (Dialogue Level):** Establishes, manages, and terminates connections (sessions) between local and remote applications.
6.  **Presentation Layer (Syntax Level):** Formats, encrypts, and compresses data so the receiver can understand it. (e.g., converting ASCII to UTF-8, SSL/TLS encryption).
7.  **Application Layer (User Level):** The layer where user applications interact with the network. (Protocols: HTTP, HTTPS, FTP, DNS, SMTP).

---

## 2. Protocols & Network Operation

### Q2. TCP vs. UDP (With Real-World Examples)
| Feature | TCP (Transmission Control Protocol) | UDP (User Datagram Protocol) |
| :--- | :--- | :--- |
| **Connection** | **Connection-oriented**: Requires a 3-way handshake (`SYN` -> `SYN-ACK` -> `ACK`) before sending data. | **Connectionless**: Sends packets immediately without checking if the receiver is ready. |
| **Reliability** | **Guaranteed**: If a packet is lost, it is retransmitted. Packets arrive in order. | **Best-effort**: Packets can be lost, duplicated, or arrive out of order. |
| **Speed** | Slower (due to error checks and handshake overhead). | Faster (minimal header size, no handshakes, no error checking). |
| **Flow Control** | Yes (prevents sender from overwhelming receiver). | No. |
| **Real-world Use** | Web browsing (HTTP), email, file transfer (FTP) where losing data is unacceptable. | Video streaming, online gaming, VoIP calls (Zoom) where speed is prioritized over minor packet losses. |

### Q3. What is DNS (Domain Name System)?
*   **Definition:** DNS acts as the "phonebook of the Internet." Humans access information online through domain names (like `google.com`), but computers communicate using numerical IP addresses (like `142.250.190.46`). DNS translates domain names to IP addresses.
*   **Process:** When you search for a website:
    1.  Your browser checks its local cache.
    2.  If not found, it queries a **DNS Resolver** (usually run by your ISP).
    3.  The resolver queries **Root Nameservers**, which point to the **TLD (Top-Level Domain) Nameservers** (like `.com` servers).
    4.  The TLD server points to the **Authoritative Nameserver** for the domain, which returns the IP address.

### Q4. What happens when you type a URL (like `google.com`) in your browser?
This is a classic question that tests your end-to-end understanding of networking:
1.  **DNS Lookup:** The browser translates `google.com` to an IP address using DNS.
2.  **TCP Connection:** The browser initiates a **TCP 3-way handshake** to establish a connection with Google’s server at that IP.
3.  **TLS Handshake:** Secure encryption keys are negotiated (HTTPS setup).
4.  **HTTP Request:** The browser sends an `HTTP GET` request asking for the webpage.
5.  **Server Response:** The server processes the request and sends back the HTML, CSS, and JS files.
6.  **Rendering:** The browser parses the files and renders the website on your screen.

---

## 3. Topologies & Network Hardware

### Q5. Explain the differences between a Hub, a Switch, and a Router.
*   **Hub (Layer 1 - Physical):** A dumb device. When it receives a packet of data, it blindly duplicates it and broadcasts it to *all* connected devices, wasting bandwidth and posing security risks.
*   **Switch (Layer 2 - Data Link):** A smart device. It learns the MAC addresses of connected devices. When it receives a packet, it forwards it *only* to the specific target device.
*   **Router (Layer 3 - Network):** Connects different networks together (e.g., connecting your home local network to the public Internet). It routes packets between networks based on IP addresses.

### Q6. Mesh Topology vs. Star Topology (Q2 from PDF)
*   **Star Topology:** All devices connect to a central Hub or Switch. 
    *   *Pros*: Easy to install, cheap. If one cable fails, only that device is disconnected.
    *   *Cons*: If the central switch fails, the entire network goes down.
*   **Mesh Topology (Fully Connected):** Every device is directly connected to every other device.
    *   *Pros*: Extremely robust. If one link fails, data takes another path. No single point of failure.
    *   *Cons*: Extremely expensive due to bulk wiring and requires many I/O ports. Used primarily in critical networks (like military or backbone networks).
