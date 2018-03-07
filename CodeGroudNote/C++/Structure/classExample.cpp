#include <iostream>
#include <queue>
using namespace std;

class Person{
    string name;
    int age;
public:
    Person();
    Person(string name);
    string getName();
    int getAge();
};

Person::Person() {
    this->name = "GOD";
    this->age = 0;
}

int Person::getAge() {
    return this->age;
}

Person::Person(string name) {
    this->name = name;
}

string Person::getName() {
    return this->name;
}

class Student: public Person{
    int studentNo;

public:
    Student();
    int getStudentNo();
    void setStudentNo(int stuNo);
};

Student::Student():Person(){
    this->studentNo = 11111;
}

int Student::getStudentNo() {
    return this->studentNo;
}

void Student::setStudentNo(int stuNo) {
    this->studentNo = stuNo;
}

int main(){
    Student student;
    cout << student.getName() << endl;
}