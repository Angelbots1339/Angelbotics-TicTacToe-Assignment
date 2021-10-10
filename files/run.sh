#!/bin/bash
# To be called by the .replit file's run

echo "---Angelbotics TicTacToe Lesson---"
echo "Compiling..."
javac -d classes src/*.java
echo "Done!"
echo "Starting java virtual machine..."
echo
java -cp classes src/Main
echo ""