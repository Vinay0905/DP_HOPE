# Function to return precedence of operators
def prec(c):
    if c == '^':  # Exponent operator has highest precedence
        return 3
    elif c == '/' or c == '*':  # Multiplication and division have higher precedence than addition
        return 2
    elif c == '+' or c == '-':  # Addition and subtraction have lowest precedence
        return 1
    else:
        return -1

# Function to convert infix expression to postfix expression
def infixToPostfix(s):
    stack = []  # Stack to hold operators and parentheses
    result = ""  # String to hold the resulting postfix expression

    for c in s:
        # If the scanned character is an operand, add it to the result string
        if c.isalnum():
            result += c
        # If the scanned character is an ‘(‘, push it to the stack
        elif c == '(':
            stack.append('(')
        # If the scanned character is a ‘)’, pop from stack until an ‘(‘ is encountered
        elif c == ')':
            while stack and stack[-1] != '(':
                result += stack.pop()
            stack.pop()  # Pop the ‘(‘ from the stack
        # If an operator is scanned
        else:
            while stack and prec(c) <= prec(stack[-1]):
                result += stack.pop()
            stack.append(c)  # Push the current operator to the stack

    # Pop all the remaining elements from the stack
    while stack:
        result += stack.pop()

    print(f"Postfix expression: {result}")  # Output the result

# Driver code
if __name__ == "__main__":
    exp = "(p+q)*(m-n)"  # Infix expression
    print(f"Infix expression: {exp}")
    infixToPostfix(exp)  # Convert the infix expression to postfix