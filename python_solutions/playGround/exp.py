from openai import OpenAI

BASE_URL = "http://192.168.29.109:1234/v1"
API_KEY = "lm-studio"  # dummy value, required by the SDK

client = OpenAI(base_url=BASE_URL, api_key=API_KEY)

def get_model():
    models = client.models.list()
    if not models.data:
        raise RuntimeError("No model loaded in LM Studio. Load one first.")
    return models.data[0].id

def main():
    model = get_model()
    print(f"Using model: {model}")
    print("Type 'exit' to quit.\n")

    messages = [
        {"role": "system", "content": "You are a helpful terminal chatbot."}
    ]

    while True:
        user_input = input("You: ").strip()
        if user_input.lower() in {"exit", "quit"}:
            print("Bye!")
            break

        if not user_input:
            continue

        messages.append({"role": "user", "content": user_input})

        try:
            response = client.chat.completions.create(
                model=model,
                messages=messages,
                temperature=0.7,
                max_tokens=300,
            )
            reply = response.choices[0].message.content or ""
            print(f"Bot: {reply}\n")
            messages.append({"role": "assistant", "content": reply})
        except Exception as e:
            print(f"Error: {e}\n")

if __name__ == "__main__":
    main()
    