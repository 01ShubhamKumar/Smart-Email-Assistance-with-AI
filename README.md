# Smart-Email-Assistance-with-AI
A full-stack **AI-powered Smart Email Assistant** built using Spring Boot, Java, Google Gemini API, HTML and JS.   This project helps you automatically **analyze, summarize, and draft intelligent email replies

## 🚀 Features

- 🤖 **AI-Generated Email Replies** – Uses Gemini API to compose professional and context-aware responses.  
- 📨 **Smart Inbox Integration** – Chrome Extension to trigger AI assistance directly inside your email client.  
- ⚙️ **Spring Boot Backend** – RESTful API built in Java to handle email processing and model requests.  
- 🔒 **Secure Configuration** – Environment-based API key management and request validation.  
- 🧩 **Modular Architecture** – Easy to extend for different LLMs or front-end integrations

## 🧰 Tech Stack

| Component | Technology |
|------------|-------------|
| Backend | Spring Boot (Java 17+) |
| AI Model | Google Gemini API / Generative AI |
| Frontend | Chrome Extension (HTML, JS) |
| Build Tool | Maven / Gradle |


## ⚙️ How It Works

1. User highlights or selects an email in the inbox.  
2. Chrome Extension sends the content to the Spring Boot API.  
3. Backend sends a structured prompt to Gemini API.  
4. AI generates a smart reply or summary.  
5. Response is sent back to the extension for user review or auto-insert.
