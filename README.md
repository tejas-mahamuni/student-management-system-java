# Student Management System (File Handling Based)

## Project Overview
This project is a console-based Student Management System developed using Core Java. It demonstrates the use of file handling, object-oriented programming, serialization, and data management without using a database.

All student records are stored persistently in a file and can be managed through various operations such as adding, viewing, searching, updating, and deleting.

---

## Objectives
- Implement file handling using Java
- Apply Object-Oriented Programming concepts
- Use serialization and deserialization
- Manage data efficiently using ArrayList
- Ensure data persistence without a database

---

## Technologies Used
- Java (Core Java)
- File Handling (FileInputStream, FileOutputStream)
- Serialization (Serializable interface)
- Collections (ArrayList)
- Exception Handling

---

## Project Structure
- `Student.java`  
  Model class representing student data (id, name, cgpa)

- `Services.java`  
  Contains business logic for all operations (CRUD, sorting, export)

- `FileHandler.java`  
  Handles reading and writing data to file using serialization

- `Main.java`  
  Menu-driven interface for user interaction

---

## Features

### 1. Add Student
- Input: ID, Name, CGPA
- Ensures unique ID
- Validates input data
- Stores record in file

### 2. View All Students
- Displays all stored student records

### 3. Search Student
- Search by student ID
- Displays details if found

### 4. Update Student
- Modify name and CGPA
- Updates record in file

### 5. Delete Student
- Removes student record by ID

### 6. Sorting
- Sort students by CGPA (descending)
- Sort students by ID (ascending)

### 7. File Storage
- `.dat` file used for serialized object storage
- `.txt` file used for human-readable data

### 8. Automatic Synchronization
- Both `.dat` and `.txt` files are updated after every operation

---

## Validation Rules
- ID must be unique and positive
- Name cannot be empty
- CGPA must be between 0 and 10

---

## File Handling Approach
The system follows a read-modify-write approach:
1. Read all records from file
2. Modify data in memory (ArrayList)
3. Rewrite the entire file with updated data

This ensures consistency and avoids data corruption.

---

## How to Run
1. Compile all Java files
2. Run the main class


---

## Sample Output

===== STUDENT MANAGEMENT SYSTEM =====

1. Add Student
2. View All Students
3. Search Student
4. Update Student
5. Delete Student
6. Sort by CGPA
7. Sort by ID
8. Exit


---

## Conclusion
This project demonstrates effective use of file handling and object-oriented programming in Java. It provides a simple yet complete system for managing student records without using a database, making it suitable for academic purposes and foundational learning.
