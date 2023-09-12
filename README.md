# Simple-Bank-Application
## Description
This simple bank application is a Java-based application that simulates the basic functionalities of a banking system. It incorporates user authentication, account management, and file operations to provide a seamless banking experience. Users can perform various tasks such as checking their balance, depositing funds, and withdrawing money.

## Table of Contents
- Features
- Installation
- Usage
- Code Overview

## Features
1. **User Authentication**: authenticate users using a username and password
2. **Account Management**: users can check their balance, make deposits, and withdraw money
3. **File Operations**: performs read and write operations to store user information
4. **Manager Operations**: allows a manager to view all user accounts and their balances

## Installation
To clone and run this project locally, use the following command: `git clone https://github.com/jrkave/Simple-Bank-Application.git`

## Usage
Open the project in your favorite IDE and run the Bank.java file to start the application. Follow the prompts in the console to interact with the application.

## Code Overview
- Bank.java: This is the main file that drives the application. It contains the main method and facilitates user interactions through the console.
- Manager.java: This file defines the Manager class which contains methods to view all user accounts and their respective balances.
- FileOps.java: This file manages file operations, including reading from and writing to the Users.txt file to store user information persistently.
- Users.txt: A text file that stores user information such as usernames, passwords, and account balances.
