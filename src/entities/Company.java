package entities;

public class Company extends TaxPayer {
    private Integer numberOfEmployees;

    public Company(String name, Double anualIncome, Integer numberOfEmployees) {
        super(name, anualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public double tax() {
        double tax = 0.0;
        if (numberOfEmployees < 10.0) {
            tax = getAnualIncome() * 0.16;
        } else {
            tax = getAnualIncome() * 0.14;
        }
        return tax;
    }

    @Override
    public String toString() {
        return getName() + ": $ " + String.format("%.2f", tax());
    }
}
