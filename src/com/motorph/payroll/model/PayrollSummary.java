package com.motorph.payroll.model;

import com.motorph.payroll.view.SelectDateRange;
import com.motorph.payroll.view.AllAttends;
import com.motorph.payroll.view.AttendanceStatus;
import com.motorph.payroll.view.DisplayPayslip;
import com.motorph.payroll.view.Payslip;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;

public class PayrollSummary {
    private Employee employee;
    private double totalHours;
    private double overtimeHours;
    private double grossPay;
    private double sssDeduction;
    private double philhealthDeduction;
    private double pagibigDeduction;
    private double totalDeductions;
    private double netPay;
    private List<Attendance> attendanceRecords;
    private LocalDate startDate;
    private LocalDate endDate;
    private double lateMinutes;
    private int daysPresent;

    public PayrollSummary(Employee employee, List<Attendance> attendanceRecords,
                         double totalHours, double overtimeHours, double grossPay, 
                         double sssDeduction, double philhealthDeduction,
                         double pagibigDeduction, double totalDeductions, double netPay,
                         LocalDate startDate, LocalDate endDate, double lateMinutes,
                         int daysPresent) {
        this.employee = employee;
        this.attendanceRecords = attendanceRecords;
        this.totalHours = totalHours;
        this.overtimeHours = overtimeHours;
        this.grossPay = grossPay;
        this.sssDeduction = sssDeduction;
        this.philhealthDeduction = philhealthDeduction;
        this.pagibigDeduction = pagibigDeduction;
        this.totalDeductions = totalDeductions;
        this.netPay = netPay;
        this.startDate = startDate;
        this.endDate = endDate;
        this.lateMinutes = lateMinutes;
        this.daysPresent = daysPresent;
    }

    public void printPayslip() {
        new Payslip(employee, attendanceRecords, startDate, endDate, daysPresent,
            totalHours, overtimeHours, lateMinutes, grossPay, sssDeduction,
            philhealthDeduction, pagibigDeduction, totalDeductions, netPay).setVisible(true);
//        StringBuilder payslip = new StringBuilder();
//        
//        // Pay Period
//        payslip.append("Pay Period: ").append(startDate.format(dateFormatter))
//               .append(" - ").append(endDate.format(dateFormatter)).append("\n");
//        
//        // Employee Details
//        payslip.append("\nEmployee Details:\n")
//               .append("ID: ").append(employee.getEmployeeId()).append("\n")
//               .append("Name: ").append(employee.getLastName()).append(", ").append(employee.getFirstName()).append("\n")
//               .append("Position: ").append(employee.getPosition()).append("\n")
//               .append("Status: ").append(employee.getStatus()).append("\n");
//        
//        // Government Numbers
//        payslip.append("\nGovernment Numbers:\n")
//               .append("SSS: ").append(employee.getSssNumber()).append("\n")
//               .append("PhilHealth: ").append(employee.getPhilhealthNumber()).append("\n")
//               .append("TIN: ").append(employee.getTinNumber()).append("\n")
//               .append("Pag-IBIG: ").append(employee.getPagibigNumber()).append("\n");
//        
//        // Attendance Summary
//        payslip.append("\nAttendance Summary:\n")
//               .append(String.format("Days Present:       %d days\n", daysPresent))
//               .append(String.format("Total Hours Worked: %.2f hours\n", totalHours))
//               .append(String.format("Overtime Hours:     %.2f hours\n", overtimeHours))
//               .append(String.format("Late Minutes:       %.2f minutes\n", lateMinutes));
//        
//        // Detailed Attendance Records
//        payslip.append("\nDetailed Attendance Records:\n")
//               .append("Date          Time In   Time Out  Total Hours  OT Hours\n")
//               .append("----------------------------------------------------\n");
//        
//        for (Attendance record : attendanceRecords) {
//            payslip.append(String.format("%-12s %-9s %-9s %-12.2f %-8.2f\n",
//                record.getDate().format(dateFormatter),
//                record.getTimeIn() != null ? record.getTimeIn().format(timeFormatter) : "N/A",
//                record.getTimeOut() != null ? record.getTimeOut().format(timeFormatter) : "N/A",
//                record.getTotalHours(),
//                record.getOvertimeHours()));
//        }
//        
//        // Earnings
//        payslip.append("\nEarnings:\n")
//               .append(String.format("Basic Salary:       PHP %-,12.2f\n", employee.getBasicSalary()))
//               .append(String.format("Rice Subsidy:       PHP %-,12.2f\n", employee.getRiceSubsidy()))
//               .append(String.format("Phone Allowance:    PHP %-,12.2f\n", employee.getPhoneAllowance()))
//               .append(String.format("Clothing Allowance: PHP %-,12.2f\n", employee.getClothingAllowance()))
//               .append(String.format("Gross Pay:          PHP %-,12.2f\n", grossPay));
//        
//        // Deductions
//        payslip.append("\nDeductions:\n")
//               .append(String.format("SSS:               PHP %-,12.2f\n", sssDeduction))
//               .append(String.format("PhilHealth:        PHP %-,12.2f\n", philhealthDeduction))
//               .append(String.format("Pag-IBIG:          PHP %-,12.2f\n", pagibigDeduction))
//               .append(String.format("Total Deductions:  PHP %-,12.2f\n", totalDeductions));
//        
//        payslip.append("\n----------------------------------------------------\n")
//               .append(String.format("NET PAY:           PHP %-,12.2f\n", netPay))
//               .append("\n====================================================\n")
//               .append("          This is a system-generated payslip.        \n");
//
//        // Display the payslip in one JOptionPane
//        JOptionPane.showMessageDialog(null, payslip.toString(), "Employee Payslip", JOptionPane.INFORMATION_MESSAGE);
    }

    public void displayAttendanceStatus() {
        
//        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        
        if (!attendanceRecords.isEmpty()) {
            new AttendanceStatus(employee, attendanceRecords, daysPresent, totalHours, overtimeHours, lateMinutes).setVisible(true);
//
//            System.out.println("\n================ ATTENDANCE STATUS ================");
//            System.out.printf("Employee ID: %d\n", employee.getEmployeeId());
//            System.out.printf("Name: %s, %s\n", employee.getLastName(), employee.getFirstName());
//            System.out.printf("Position: %s\n", employee.getPosition());
//            System.out.printf("Status: %s\n", employee.getStatus());
//            System.out.println("================================================");
//
//            
//            System.out.println("\nAttendance Summary:");
//            System.out.printf("Days Present: %d days\n", daysPresent);
//            System.out.printf("Total Hours: %.2f hours\n", totalHours);
//            System.out.printf("Overtime Hours: %.2f hours\n", overtimeHours);
//            System.out.printf("Late Minutes: %.2f minutes\n", lateMinutes);
//            
//            System.out.println("\nDetailed Records:");
//            System.out.printf("%-12s | %-8s | %-8s | %-6s | %-8s | %-8s\n", 
//                "Date", "Time In", "Time Out", "Hours", "OT Hours", "Status");
//            System.out.println("------------------------------------------------------------");
//            
//            for (Attendance record : attendanceRecords) {
//                String timeIn = record.getTimeIn() != null ? 
//                    record.getTimeIn().format(timeFormatter) : "N/A";
//                String timeOut = record.getTimeOut() != null ? 
//                    record.getTimeOut().format(timeFormatter) : "N/A";
//                String status = determineStatus(record);
//                
//                System.out.printf("%-12s | %-8s | %-8s | %6.2f | %8.2f | %-8s\n",
//                    record.getDate().format(dateFormatter),
//                    timeIn,
//                    timeOut,
//                    record.getTotalHours(),
//                    record.getOvertimeHours(),
//                    status);
//            }
            return;
        }
        JOptionPane.showMessageDialog(null, "No attendance records found for this period.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void displayAllAttendanceRecords() {
        new AllAttends(employee, attendanceRecords, totalHours, overtimeHours, lateMinutes).setVisible(true);
        
//        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
//        
//        System.out.println("\n================ ALL ATTENDANCE RECORDS ================");
//        System.out.printf("Employee ID: %d\n", employee.getEmployeeId());
//        System.out.printf("Name: %s, %s\n", employee.getLastName(), employee.getFirstName());
//        System.out.printf("Position: %s\n", employee.getPosition());
//        System.out.println("======================================================");
//        
//        if (attendanceRecords.isEmpty()) {
//            System.out.println("No attendance records found for this employee.");
//        } else {
//            System.out.printf("%-12s | %-8s | %-8s | %-6s | %-8s | %-10s | %-8s\n", 
//                "Date", "Time In", "Time Out", "Hours", "OT Hours", "Late (min)", "Status");
//            System.out.println("----------------------------------------------------------------------");
//            
//            attendanceRecords.sort((a1, a2) -> a1.getDate().compareTo(a2.getDate()));
//            
//            for (Attendance record : attendanceRecords) {
//                String timeIn = record.getTimeIn() != null ? 
//                    record.getTimeIn().format(timeFormatter) : "N/A";
//                String timeOut = record.getTimeOut() != null ? 
//                    record.getTimeOut().format(timeFormatter) : "N/A";
//                String status = determineStatus(record);
//                
//                System.out.printf("%-12s | %-8s | %-8s | %6.2f | %8.2f | %10.0f | %-8s\n",
//                    record.getDate().format(dateFormatter),
//                    timeIn,
//                    timeOut,
//                    record.getTotalHours(),
//                    record.getOvertimeHours(),
//                    record.getLateMinutes(),
//                    status);
//            }
//            
//            // Print summary
//            System.out.println("----------------------------------------------------------------------");
//            System.out.printf("TOTAL: %d records | %.2f hours | %.2f OT hours | %.0f late minutes\n", 
//                attendanceRecords.size(), totalHours, overtimeHours, lateMinutes);
//        }
//        System.out.println("======================================================\n");
    }

    private String determineStatus(Attendance record) {
        if (record.getTimeIn() == null || record.getTimeOut() == null) {
            return "ABSENT";
        }
        if (record.getLateMinutes() > 0) {
            return "LATE";
        }
        return "PRESENT";
    }

    // Getters
    public Employee getEmployee() { return employee; }
    public List<Attendance> getAttendanceRecords() { return attendanceRecords; }
    public double getTotalHours() { return totalHours; }
    public double getOvertimeHours() { return overtimeHours; }
    public double getGrossPay() { return grossPay; }
    public double getSssDeduction() { return sssDeduction; }
    public double getPhilhealthDeduction() { return philhealthDeduction; }
    public double getPagibigDeduction() { return pagibigDeduction; }
    public double getTotalDeductions() { return totalDeductions; }
    public double getNetPay() { return netPay; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public double getLateMinutes() { return lateMinutes; }
    public int getDaysPresent() { return daysPresent; }
}