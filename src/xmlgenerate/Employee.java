/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlgenerate;

/**
 *
 * @author gabri
 */
class Employee {
    private int id;
    private String name;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    private String surname;
    private String gender;
    private String salary;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAdress() {
        return address;
    }

    public void setAdress(String Adress) {
        this.address = Adress;
    }
    @Override
    public String toString() {
        return "Employee: ID="+this.id+" Name=" + this.name+" Surname=" + this.surname + " Salary=" + this.salary + " Gender=" + this.gender +
                " Adress=" + this.address;
    }
}
