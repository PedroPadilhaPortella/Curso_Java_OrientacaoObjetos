import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker 
{
    private String Name;
    private WorkerLevel Level;
    private Double BaseSalary;
    private Department Department;
    private List<HourContract> Contracts = new ArrayList<>();

    public Worker(String Name, WorkerLevel Level, Double BaseSalary, Department Department) 
    {
        this.Name = Name;
        this.Level = Level;
        this.BaseSalary = BaseSalary;
        this.Department = Department;
    }

    public Worker() {
    }

    public void AddContract(HourContract contract) {
        Contracts.add(contract);
    }

    public void RemoveContract(HourContract contract) {
        Contracts.remove(contract);
    }

    public Double Income(Integer year, Integer month) {
        Calendar cal = Calendar.getInstance();
        double sum = BaseSalary;
        for (HourContract contract : Contracts) {
            cal.setTime(contract.getDate());
            int c_year = cal.get(Calendar.YEAR);
            int c_month = cal.get(Calendar.MONTH) + 1;

            if(c_year == year && c_month == month ) {
                sum += contract.TotalValue();
            }
        }
        
        return sum;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public WorkerLevel getLevel() {
        return this.Level;
    }

    public void setLevel(WorkerLevel Level) {
        this.Level = Level;
    }

    public Double getBaseSalary() {
        return this.BaseSalary;
    }

    public void setBaseSalary(Double BaseSalary) {
        this.BaseSalary = BaseSalary;
    }

    public Department getDepartment() {
        return this.Department;
    }

    public void setDepartment(Department Department) {
        this.Department = Department;
    }

    public List<HourContract> getContracts() {
        return this.Contracts;
    }
}
