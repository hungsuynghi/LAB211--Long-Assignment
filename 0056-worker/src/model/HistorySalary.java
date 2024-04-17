/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */

/**
 * Represents a history of salary changes for a worker, extending the Worker class.
 */
public class HistorySalary extends Worker{
    private String status;
    private String date;


    public HistorySalary(String status, String date) {
        this.status = status;
        this.date = date;
    }

    public HistorySalary(String status, String date, String id, String name, int age, int salary, String workLocation) {
        super(id, name, age, salary, workLocation);
        this.status = status;
        this.date = date;
    }

    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    
    @Override
    public String toString() {
        return String.format("%-10s %-15s %-10s %-10s %-12s %-10s %-10s", super.getId(), super.getName(), super.getAge(),
                super.getSalary(), super.getWorkLocation(), status, date);
    }

}
 b  