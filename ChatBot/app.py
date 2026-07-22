import os

from dotenv import load_dotenv

from rich.console import Console
from rich.panel import Panel
from rich.markdown import Markdown
from rich.live import Live

from langchain_openai import ChatOpenAI

from langchain_core.messages import (
    HumanMessage,
    AIMessage,
    SystemMessage,
)

# ===================================================
# Load Environment
# ===================================================

load_dotenv()

NVIDIA_API_KEY = os.getenv("NVIDIA_API_KEY")

if not NVIDIA_API_KEY:
    raise ValueError("NVIDIA_API_KEY not found in .env")

# ===================================================
# Rich Console
# ===================================================

console = Console()

# ===================================================
# NVIDIA NIM
# ===================================================

llm = ChatOpenAI(
    api_key=NVIDIA_API_KEY,
    base_url="https://integrate.api.nvidia.com/v1",
    model="meta/llama-3.1-8b-instruct",
    temperature=0.7,
    streaming=True,
)

# ===================================================
# Conversation History
# ===================================================

history = [
    SystemMessage(
        content="""
You are an expert AI Assistant.

Always:

- Answer in Markdown.
- Use headings.
- Use bullet points.
- Use code blocks.
- Explain step-by-step.
"""
    )
]

# ===================================================
# Welcome Screen
# ===================================================

console.print(
    Panel.fit(
        "[bold cyan]🤖 Jarvis AI Chatbot[/bold cyan]\n\n"
        "Powered by Ritik Mind \n\n"
        "[green]Type your question[/green]\n"
        "[red]Type exit to quit[/red]",
        border_style="cyan",
        title="Welcome",
    )
)

# ===================================================
# Chat Loop
# ===================================================

while True:

    console.print()

    user = console.input("[bold green]You[/bold green] > ")

    if user.lower() in ["exit", "quit"]:
        console.print("\n👋 Goodbye!\n")
        break

    history.append(HumanMessage(content=user))

    full_response = ""

    try:

        with Live("", refresh_per_second=20) as live:

            for chunk in llm.stream(history):

                if chunk.content:

                    full_response += chunk.content

                    live.update(
                        Panel(
                            Markdown(full_response),
                            title="🤖 Assistant",
                            border_style="blue",
                        )
                    )

        history.append(AIMessage(content=full_response))

    except Exception as e:

        console.print(
            Panel(
                str(e),
                title="Error",
                border_style="red",
            )
        )
