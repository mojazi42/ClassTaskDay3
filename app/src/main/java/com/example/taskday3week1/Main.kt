package com.example.taskday3week1

// Person class with open modifier for inheritance
open class Person(open val name: String, open val age: Int) {
    open fun displayInfo() {
        println("Name: $name, Age: $age")
    }
}

// Interface for scholarship eligibility
interface ScholarshipEligible {
    fun isEligible(): Boolean
}

// Student class inheriting from Person and implementing ScholarshipEligible
class Student(name: String, age: Int, val studentId: Int, var grade: String) : Person(name, age), ScholarshipEligible {
    override fun displayInfo() {
        println("Name: $name, Age: $age, Student ID: $studentId, Grade: $grade")
    }

    override fun isEligible(): Boolean {
        return grade == "A" || grade == "B"
    }
}

// Data class Course
data class Course(val courseName: String, val courseCode: String, val credits: Int)

// Enum class with maxCredits property
enum class DepartmentType(val maxCredits: Int) {
    COMPUTER_SCIENCE(21),
    MATHEMATICS(18),
    PHYSICS(20),
    ENGINEERING(24);

    // Function to check if a student can register for a course
    fun canRegister(currentCredits: Int): Boolean {
        return currentCredits <= maxCredits
    }
}

// Single main() function
fun main() {
    // Testing DepartmentType Enum
    val dept = DepartmentType.COMPUTER_SCIENCE
    println("Can register with 19 credits? ${dept.canRegister(19)}")  // true
    println("Can register with 22 credits? ${dept.canRegister(22)}")  // false

    // Testing Person class
    val person = Person("Mohammed", 24)
    person.displayInfo()

    // Testing Student class
    val student = Student("Abdulaziz", 23, 12345, "A")
    student.displayInfo()
    println("Eligible for Scholarship: ${student.isEligible()}")
}
